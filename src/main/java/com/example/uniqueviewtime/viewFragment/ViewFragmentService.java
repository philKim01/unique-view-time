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

  // returns all view fragments in the repository
  public List<ViewFragment> getViewFragments() {
    return viewFragmentRepository.findAll();
  }

  // adds a view fragment to the repository
  public void addNewViewFragment(ViewFragment viewFragment) {
    viewFragmentRepository.save(viewFragment);
  }

}
