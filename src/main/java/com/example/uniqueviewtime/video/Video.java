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

  public int getUniqueViewTime() {

    ViewFragment arr[] = new ViewFragment[this.getViewFragments().size()];

    arr = this.getViewFragments().toArray(arr);

    Stack<ViewFragment> stack = new Stack<>();

    Arrays.sort(arr, new Comparator<ViewFragment>() {
      public int compare(ViewFragment i1, ViewFragment i2) {
        return i1.getStartTime() - i2.getStartTime();
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
    int totalUVT = 0;

    while (!stack.isEmpty()) {
      ViewFragment t = stack.pop();
      int fragmentUVT = t.getEndTime() - t.getStartTime();

      totalUVT += fragmentUVT;
    }
    return totalUVT;
  }

}
