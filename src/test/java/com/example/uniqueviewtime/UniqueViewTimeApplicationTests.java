package com.example.uniqueviewtime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.uniqueviewtime.video.Video;
import com.example.uniqueviewtime.viewFragment.ViewFragment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniqueViewTimeApplicationTests {

	@Test
	void testingUVT() {
		// given
		Video uVTTest = new Video();
		ViewFragment firstFragment = new ViewFragment(0, 5000, uVTTest);
		ViewFragment secondFragment = new ViewFragment(5000, 6000, uVTTest);

		uVTTest.addViewFragment(firstFragment);
		uVTTest.addViewFragment(secondFragment);

		// when
		int uVTResult = uVTTest.getUniqueViewTime();

		// Expect
		assertEquals(6000, uVTResult);
	}

	@Test
	void uVTTestWithOverlap() {

		// Given
		Video uVTTest = new Video();

		ViewFragment firstFragment = new ViewFragment(0, 3300, uVTTest);
		ViewFragment secondFragment = new ViewFragment(1500, 4500, uVTTest);
		ViewFragment thirdFragment = new ViewFragment(4000, 5000, uVTTest);

		uVTTest.addViewFragment(firstFragment);
		uVTTest.addViewFragment(secondFragment);
		uVTTest.addViewFragment(thirdFragment);

		// Expect
		int uVTResult = uVTTest.getUniqueViewTime();
		assertEquals(5000, uVTResult);
	}

	@Test
	void uVTTestWithGap() {
		// Given
		Video uVTTest = new Video();

		ViewFragment firstFragment = new ViewFragment(0, 3300, uVTTest);
		ViewFragment secondFragment = new ViewFragment(1500, 3500, uVTTest);
		ViewFragment thirdFragment = new ViewFragment(4500, 5000, uVTTest);

		uVTTest.addViewFragment(firstFragment);
		uVTTest.addViewFragment(secondFragment);
		uVTTest.addViewFragment(thirdFragment);

		// Expect
		int uVTResult = uVTTest.getUniqueViewTime();
		assertEquals(4000, uVTResult);
	}

}
