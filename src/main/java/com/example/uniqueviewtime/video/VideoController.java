package com.example.uniqueviewtime.video;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/video")
public class VideoController {
  private final VideoService videoService;

  @Autowired
  public VideoController(VideoService videoService) {
    this.videoService = videoService;
  }

  @Autowired
  VideoRepository videoRepository;

  @GetMapping
  public List<Video> getVideos() {
    return videoService.getVideos();
  }

  @GetMapping(path = "{videoId}")
  public int getVideoUVT(@PathVariable("videoId") Long videoId) {
    Optional<Video> videoData = videoRepository.findById(videoId);
    Video _video = videoData.get();
    return _video.getUniqueViewTime();

  }

  @PostMapping
  public void postNewVideo(@RequestBody Video video) {
    videoService.addNewVideo(video);
  }

  @DeleteMapping(path = "{videoId}")
  public void deleteVideo(@PathVariable("videoId") Long videoId) {
    videoService.deleteVideo(videoId);
  }

  @PutMapping(path = "{videoId}")
  public ResponseEntity<Video> updateVideo(@PathVariable("videoId") Long videoId, @RequestBody Video video) {
    Optional<Video> videoData = videoRepository.findById(videoId);
    if (videoData.isPresent()) {
      Video _video = videoData.get();
      _video.setUrl(video.getUrl());
      return new ResponseEntity<>(videoRepository.save(_video), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
