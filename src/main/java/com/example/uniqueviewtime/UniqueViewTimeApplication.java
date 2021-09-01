package com.example.uniqueviewtime;

import java.util.List;

import com.example.uniqueviewtime.video.Video;
import com.example.uniqueviewtime.video.VideoRepository;
import com.example.uniqueviewtime.viewFragment.ViewFragment;
import com.example.uniqueviewtime.viewFragment.ViewFragmentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })

@SpringBootApplication
public class UniqueViewTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniqueViewTimeApplication.class, args);
	}

	// seeds a sample video with 2 sample fragments
	@Bean
	public CommandLineRunner commandLineRunner(VideoRepository videoRepository,
			ViewFragmentRepository viewFragmentRepository) {
		return args -> {
			Video testVideo = new Video("https://www.youtube.com/watch?v=LCLCTDK4pEA&ab_channel=PeopleFluent");

			ViewFragment first30 = new ViewFragment(0, 30000, testVideo);
			ViewFragment next30after30 = new ViewFragment(60000, 90000, testVideo);

			testVideo.addViewFragment(first30);
			testVideo.addViewFragment(next30after30);

			videoRepository.save(testVideo);
			viewFragmentRepository.saveAll(List.of(first30, next30after30));

		};
	}

}
