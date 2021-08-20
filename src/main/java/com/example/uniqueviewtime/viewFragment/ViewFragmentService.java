package com.example.uniqueviewtime.viewFragment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewFragmentService {
  private final ViewFragmentRepository viewFragmentRepository;

  @Autowired
  public ViewFragmentService(ViewFragmentRepository viewFragmentRepository) {
    this.viewFragmentRepository = viewFragmentRepository;
  }

  public List<ViewFragment> getViewFragments() {
    return viewFragmentRepository.findAll();
  }

  public void addNewViewFragment(ViewFragment viewFragment) {
    viewFragmentRepository.save(viewFragment);
  }

}
