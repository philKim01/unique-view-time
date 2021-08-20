package com.example.uniqueviewtime;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import com.example.uniqueviewtime.video.Video;
// import com.example.uniqueviewtime.viewFragment.ViewFragment;

// import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniqueViewTimeApplicationTests {

	// @Test
	// void testingUVT() {
	// // given
	// Video uVTTest = new Video();
	// ViewFragment firstFragment = new ViewFragment(0, 5000);
	// ViewFragment secondFragment = new ViewFragment(5000, 6000);

	// ViewFragment arr[] = new ViewFragment[2];
	// arr[0] = firstFragment;
	// arr[1] = secondFragment;

	// // when
	// int uVTResult = uVTTest.uniqueViewTimeCalculator(arr);

	// // Expect
	// assertEquals(6000, uVTResult);
	// }

	// @Test
	// void uVTTestWithOverlap() {

	// // Given
	// Video uVTTest = new Video();

	// ViewFragment firstFragment = new ViewFragment(0, 3300);
	// ViewFragment secondFragment = new ViewFragment(1500, 4500);
	// ViewFragment thirdFragment = new ViewFragment(4000, 5000);

	// ViewFragment arr[] = new ViewFragment[3];
	// arr[0] = firstFragment;
	// arr[1] = secondFragment;
	// arr[2] = thirdFragment;

	// // Expect
	// int uVTResult = uVTTest.uniqueViewTimeCalculator(arr);
	// assertEquals(5000, uVTResult);
	// }

	// @Test
	// void uVTTestWithGap() {
	// // Given
	// Video uVTTest = new Video();

	// ViewFragment firstFragment = new ViewFragment(0, 3300);
	// ViewFragment secondFragment = new ViewFragment(1500, 3500);
	// ViewFragment thirdFragment = new ViewFragment(4500, 5000);

	// ViewFragment arr[] = new ViewFragment[3];
	// arr[0] = firstFragment;
	// arr[1] = secondFragment;
	// arr[2] = thirdFragment;

	// // Expect
	// int uVTResult = uVTTest.uniqueViewTimeCalculator(arr);
	// assertEquals(4000, uVTResult);
	// }

}
