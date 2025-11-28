package manish.dsa.arrays.twopointers.LC15_ThreeSumToZero;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Three Sum To Zero tests")
class ThreeSumToZeroTest {

	@Nested
	@DisplayName("Input array size is three or less")
	class WhenArraySizeThreeOrLess {

		ThreeSumToZero obj = new ThreeSumToZero();
		int[] input;
		List<List<Integer>> actual;
		List<List<Integer>> expected;

		@BeforeEach
		void beforeEachTest() {
			obj = new ThreeSumToZero();
		}

		@DisplayName("Input array has zero items")
		@Test
		void testArrayHasZeroItems() {
			// zero element array
			input = new int[0];
			actual = obj.threeSum(input);
			expected = new ArrayList<>();
			assertThat(actual).isEqualTo(expected);
		}

		@DisplayName("Input array has one item")
		@Test
		void testArrayHasOneItem() {
			// one element array (summing to zero)
			input = new int[] { 0 };
			actual = obj.threeSum(input);
			expected = new ArrayList<>();
			assertThat(actual).isEqualTo(expected);

			// one element array (not summing to zero)
			input = new int[] { 4 };
			actual = obj.threeSum(input);
			expected = new ArrayList<>();
			assertThat(actual).isEqualTo(expected);
		}

		@DisplayName("Input array has two items")
		@Test
		void testArrayHasTwoItems() {
			// two element array (summing to zero)
			input = new int[] { 7, -7 };
			actual = obj.threeSum(input);
			expected = new ArrayList<>();
			assertThat(actual).isEqualTo(expected);

			// two element array (not summing to zero)
			input = new int[] { 2, -8 };
			actual = obj.threeSum(input);
			expected = new ArrayList<>();
			assertThat(actual).isEqualTo(expected);
		}

		@DisplayName("When array has three items")
		@Test
		void testArrayHasThreeItems() {
			// three elements summing to zero - I
			input = new int[] { 0, 0, 0 };
			actual = obj.threeSum(input);
			expected = List.of(List.of(0, 0, 0));
			assertThat(actual).isEqualTo(expected);

			// three elements summing to zero - II
			input = new int[] { 5, -8, 3 };
			actual = obj.threeSum(input);
			expected = List.of(List.of(-8, 3, 5));
			assertThat(actual).isEqualTo(expected);

			// three elements not summing to zero
			input = new int[] { 2, 0, -3 };
			actual = obj.threeSum(input);
			expected = new ArrayList<>();
			assertThat(actual).isEqualTo(expected);
		}
	}

	@DisplayName("Input array size is more than three")
	@Nested
	class WhenArraySizeAboveThree {

		ThreeSumToZero obj = new ThreeSumToZero();
		int[] input;
		List<List<Integer>> actual;
		List<List<Integer>> expected;

		@BeforeEach
		void beforeEachTest() {
			obj = new ThreeSumToZero();
		}

		@Test
		void testOne() {
			input = new int[] { -1, 0, 1, 2, -1, -4 };
			actual = obj.threeSum(input);
			expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
			assertThat(actual).isEqualTo(expected);
		}

		@Test
		void testTwo() {
			input = new int[] { -7, -5, -2, -1, 0, 1, 1, 2, 3, 4, 4, 6, 6, 7, 8, 9 };
			actual = obj.threeSum(input);
			/**
			 * @formatter:off
			 * Expected output:
			 * List.of(
			 * 		List.of(-7, -2, 9),
			 * 		List.of(-7, -1, 8),
			 * 		List.of(-7, 0, 7),
			 * 		List.of(-7, 1, 6),
			 * 		List.of(-7, 3, 4),
			 * 		List.of(-5, -2, 7),
			 * 		List.of(-5, -1, 6),
			 * 		List.of(-5, 1, 4),
			 * 		List.of(-5, 2, 3),
			 * 		List.of(-2, -1, 3),
			 * 		List.of(-2, 0, 2),
			 * 		List.of(-2, 1, 1),
			 * 		List.of(-1, 0, 1)
			 * );
			 * @formatter:on
			 */
			expected = List.of(List.of(-7, -2, 9), List.of(-7, -1, 8), List.of(-7, 0, 7), List.of(-7, 1, 6),
					List.of(-7, 3, 4), List.of(-5, -2, 7), List.of(-5, -1, 6), List.of(-5, 1, 4), List.of(-5, 2, 3),
					List.of(-2, -1, 3), List.of(-2, 0, 2), List.of(-2, 1, 1), List.of(-1, 0, 1));
			assertThat(actual).isEqualTo(expected);
		}
	}

}
