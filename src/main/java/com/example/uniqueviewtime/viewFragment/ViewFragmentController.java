package com.example.uniqueviewtime.viewFragment;

import java.util.List;
import java.util.Optional;

import com.example.uniqueviewtime.video.Video;
import com.example.uniqueviewtime.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/api/viewfragments")
public class ViewFragmentController {
  private final ViewFragmentService viewFragmentService;
  private final VideoRepository videoRepository;

  @Autowired
  public ViewFragmentController(ViewFragmentService viewFragmentService, VideoRepository videoRepository) {
    this.viewFragmentService = viewFragmentService;
    this.videoRepository = videoRepository;
  }

  @Autowired
  ViewFragmentRepository viewFragmentRepository;

  @GetMapping
  public List<ViewFragment> getViewFragments() {
    return viewFragmentService.getViewFragments();
  }

  @PostMapping(path = "{VideoId}")
  public ResponseEntity<ViewFragment> postNewViewFragment(@PathVariable("VideoId") Long videoId,
      @RequestBody ViewFragment viewFragment) {
    Optional<Video> videoData = videoRepository.findById(videoId);

    if (!videoData.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      viewFragmentService.addNewViewFragment(viewFragment);

      Video video = videoData.get();
      viewFragment.setVideo(video);
      video.addViewFragment(viewFragment);

      videoRepository.save(video);
      viewFragmentRepository.save(viewFragment);

      return new ResponseEntity<>(viewFragment, HttpStatus.OK);
    }
  }
}
