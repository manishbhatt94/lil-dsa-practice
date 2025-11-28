package manish.dsa.arrays.twopointers.LC16_ThreeSumClosest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Three Sum Closest - tests")
class ThreeSumClosestTest {

	ThreeSumClosest obj;

	@BeforeEach
	void beforeEachTest() {
		obj = new ThreeSumClosest();
	}

	@DisplayName("Test if Exception thrown when input array size < 3")
	@Test
	void testInvalidInputArraySizeLessThanThree() {
		// Input array size: Zero
		assertThatThrownBy(() -> {
			obj.threeSumClosest(new int[] {}, 5);
		}).isExactlyInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input");

		// Input array size: One
		assertThatThrownBy(() -> {
			obj.threeSumClosest(new int[] { 8 }, 8);
		}).isExactlyInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input");

		// Input array size: Two
		assertThatThrownBy(() -> {
			obj.threeSumClosest(new int[] { 3, 1 }, 2);
		}).isExactlyInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid input");
	}

	@DisplayName("When input array size is exactly three")
	@Nested
	class WhenArraySizeIsExactlyThree {

		@Test
		void testOne() {
			int[] input = { 0, 0, 0 };
			int target = 15;
			List<Integer> closestTriplet = List.of(0, 0, 0);
			int expected = closestTriplet.stream().mapToInt(Integer::intValue).sum();

			int actual = obj.threeSumClosest(input, target);

			assertThat(actual).isEqualTo(expected);
		}

		@Test
		void testTwo() {
			int[] input = { 4, -7, 2 };
			int target = -1;
			List<Integer> closestTriplet = List.of(-7, 2, 4);
			int expected = closestTriplet.stream().mapToInt(Integer::intValue).sum();

			int actual = obj.threeSumClosest(input, target);

			assertThat(actual).isEqualTo(expected);
		}
	}

	@Test
	void testOne() {
		int[] input = { -1, 2, 1, -4 };
		int target = 1;
		List<Integer> closestTriplet = List.of(-1, 1, 2);
		int expected = closestTriplet.stream().mapToInt(Integer::intValue).sum();

		int actual = obj.threeSumClosest(input, target);

		assertThat(actual).isEqualTo(expected);
	}

}
