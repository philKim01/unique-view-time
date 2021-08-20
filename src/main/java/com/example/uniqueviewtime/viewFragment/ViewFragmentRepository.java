package com.example.uniqueviewtime.viewFragment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewFragmentRepository extends JpaRepository<ViewFragment, Long> {
}
