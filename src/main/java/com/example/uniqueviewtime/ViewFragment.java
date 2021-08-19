package com.example.uniqueviewtime;

public class ViewFragment {

  private Double startTime;
  private Double endTime;

  // Constructors
  public ViewFragment() {

  }

  public ViewFragment(Double startTime, Double endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  // Getters and Setters
  public Double getStartTime() {
    return this.startTime;
  }

  public void setStartTime(Double startTime) {
    this.startTime = startTime;
  }

  public Double getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Double endTime) {
    this.endTime = endTime;
  }
}
