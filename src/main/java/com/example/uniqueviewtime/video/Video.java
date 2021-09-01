package com.example.uniqueviewtime.video;

import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.example.uniqueviewtime.viewFragment.ViewFragment;

import java.util.Comparator;

@Entity(name = "videos")
@Table(name = "videos")
public class Video {

  @Id
  @SequenceGenerator(name = "video_sequence", sequenceName = "video_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_sequence")
  @Column(name = "video_id")
  private Long id;

  @Column(name = "url")
  private String url;

  @Transient
  @Column(name = "Unique_View_Time")
  private int uniqueViewTime;

  @OneToMany(mappedBy = "video", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
  private final List<ViewFragment> viewFragments = new ArrayList<>();

  // Constructor
  public Video() {

  }

  public Video(String url) {
    this.url = url;
  }

  // Getters & Setters
  public Long getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<ViewFragment> getViewFragments() {
    return viewFragments;
  }

  public void addViewFragment(ViewFragment viewFragment) {
    viewFragment.setVideo(this);
    viewFragments.add(viewFragment);
  }

  // calculates unique view time
  public int getUniqueViewTime() {

    // create an array that will hold all the view fragments of a video
    ViewFragment arr[] = new ViewFragment[this.getViewFragments().size()];

    // set the contents of the array to equal the view fragments of the array
    arr = this.getViewFragments().toArray(arr);

    // create a stack of view fragmemts
    Stack<ViewFragment> stack = new Stack<>();

    // sort the view fragments in order of starting time
    Arrays.sort(arr, new Comparator<ViewFragment>() {
      public int compare(ViewFragment i1, ViewFragment i2) {
        return i1.getStartTime() - i2.getStartTime();
      }
    });

    // push the first index of the array of fragments onto the stack
    stack.push(arr[0]);

    // itterate through the array of fragments starting at the 2nd index
    for (int i = 1; i < arr.length; i++) {
      // check the top of the stack and store it into a variable
      ViewFragment top = stack.peek();
      // if the top's end time is less than the next index of the array's start time
      // it means that they dont overlap
      if (top.getEndTime() < arr[i].getStartTime())
        // meaning you can just have the next index value be the the new top of the
        // stack
        stack.push(arr[i]);
      // if there isnt a gap meaning there is an overlap
      else if (top.getEndTime() < arr[i].getEndTime()) {
        // set the variable top's end time to the next value in the array's end time
        // and replace the old top of the stack with the corrected top.
        top.setEndTime(arr[i].getEndTime());
        stack.pop();
        stack.push(top);
      }
    }
    // create a variable that will hold the total UVT.
    int totalUVT = 0;
    // while the stack is populated
    while (!stack.isEmpty()) {
      // take off the top of the stack and store it in a variable
      ViewFragment t = stack.pop();
      // store the difference of the end time and the start time in a variable
      // (get the fragment length)
      int fragmentUVT = t.getEndTime() - t.getStartTime();
      // add the fragment length to the total
      totalUVT += fragmentUVT;
    }
    // once the stack is empty, return the total
    return totalUVT;
  }

}
