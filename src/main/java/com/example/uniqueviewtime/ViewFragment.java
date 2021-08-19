package com.example.uniqueviewtime;

public class ViewFragment {

  private int startTime;
  private int endTime;

  // Constructors
  public ViewFragment() {

  }

  public ViewFragment(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  // Getters and Setters
  public int getStartTime() {
    return this.startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getEndTime() {
    return this.endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }
}
