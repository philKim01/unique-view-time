package com.example.uniqueviewtime.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
  private final VideoRepository videoRepository;

  @Autowired
  public VideoService(VideoRepository videoRepository) {
    this.videoRepository = videoRepository;
  }

  public List<Video> getVideos() {
    return videoRepository.findAll();
  }

  // adds video to the repository
  public void addNewVideo(Video video) {
    videoRepository.save(video);
  }

  // deletes video from the repository by ID
  public void deleteVideo(Long id) {
    boolean exists = videoRepository.existsById(id);

    if (!exists) {
      throw new IllegalStateException("Video with id " + id + " does not exist");
    }
    videoRepository.deleteById(id);
  }
}
