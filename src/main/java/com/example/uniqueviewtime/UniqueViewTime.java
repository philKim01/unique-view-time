package com.example.uniqueviewtime;

import java.util.Arrays;
import java.util.Stack;
import java.util.Comparator;

public class UniqueViewTime {

  public Double uniqueViewTimeCalculator(ViewFragment arr[]) {

    Stack<ViewFragment> stack = new Stack<>();

    Arrays.sort(arr, new Comparator<ViewFragment>() {
      public int compare(ViewFragment i1, ViewFragment i2) {
        if (i1.getStartTime() < i2.getStartTime())
          return -1;
        if (i1.getStartTime() > i2.getStartTime())
          return 1;
        return 0;
      }
    });

    stack.push(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      ViewFragment top = stack.peek();
      if (top.getEndTime() < arr[i].getStartTime())
        stack.push(arr[i]);
      else if (top.getEndTime() < arr[i].getEndTime()) {
        top.setEndTime(arr[i].getEndTime());
        stack.pop();
        stack.push(top);
      }
    }
    Double totalUVT = 0.0;

    while (!stack.isEmpty()) {
      ViewFragment t = stack.pop();
      Double fragmentUVT = t.getEndTime() - t.getStartTime();

      totalUVT += fragmentUVT;
    }

    return totalUVT;
  }

}
