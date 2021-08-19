package com.example.uniqueviewtime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UniqueViewTimeApplicationTests {

	UniqueViewTime uVTTest = new UniqueViewTime();

	@Test
	void testingUVT() {

		// given
		ViewFragment firstFragment = new ViewFragment(0.0, 1.1);
		ViewFragment secondFragment = new ViewFragment(2.5, 5.6);

		ViewFragment arr[] = new ViewFragment[2];
		arr[0] = firstFragment;
		arr[1] = secondFragment;

		// when
		Double uVTResult = uVTTest.uniqueViewTimeCalculator(arr);

		// Expect
		assertEquals(4.2, uVTResult);

	}

}
