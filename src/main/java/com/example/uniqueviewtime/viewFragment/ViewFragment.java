package com.example.uniqueviewtime.viewFragment;

import javax.persistence.*;

import com.example.uniqueviewtime.video.Video;

@Entity(name = "view_fragments")
@Table(name = "view_fragments")
public class ViewFragment {

  @Id
  @SequenceGenerator(name = "fragment_sequence", sequenceName = "fragment_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fragment_sequence")
  private Long id;

  @Column(name = "Start_Time", nullable = false)
  private int startTime;

  @Column(name = "End_Time", nullable = false)
  private int endTime;

  @ManyToOne
  @JoinColumn(name = "Video_id", referencedColumnName = "Video_id", foreignKey = @ForeignKey(name = "Video_id"))
  private Video video;

  // Constructors
  public ViewFragment() {

  }

  public ViewFragment(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public ViewFragment(int startTime, int endTime, Video video) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.video = video;
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

  public Long getVideoId() {
    return video.getId();
  }

  public void setVideo(Video video) {
    this.video = video;
  }
}
