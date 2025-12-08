package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveDuplicatesFromSortedArrayIITest {

	@ParameterizedTest
	@MethodSource("approachProvider")
	void testOne(ISolutionApproach approach) {
		int[] arr = { 1, 1, 1, 2, 2, 3 };
		int actualK = approach.removeDuplicates(arr);
		int expectedK = 5;
		int[] expUpdatedArr = { 1, 1, 2, 2, 3 };

		assertThat(actualK).isEqualTo(expectedK);
		assertThat(Arrays.copyOf(arr, actualK)).isEqualTo(expUpdatedArr);
	}

	@ParameterizedTest
	@MethodSource("approachProvider")
	void testTwo(ISolutionApproach approach) {
		int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		int actualK = approach.removeDuplicates(arr);
		int expectedK = 7;
		int[] expUpdatedArr = { 0, 0, 1, 1, 2, 3, 3 };

		assertThat(actualK).isEqualTo(expectedK);
		assertThat(Arrays.copyOf(arr, actualK)).isEqualTo(expUpdatedArr);
	}

	@ParameterizedTest
	@MethodSource("approachProvider")
	void testThree(ISolutionApproach approach) {
		int[] arr = { 1, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 6, 6, 6, 7, 7, 8 };
		int actualK = approach.removeDuplicates(arr);
		int expectedK = 13;
		int[] expUpdatedArr = { 1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8 };

		assertThat(actualK).isEqualTo(expectedK);
		assertThat(Arrays.copyOf(arr, actualK)).isEqualTo(expUpdatedArr);
	}

	private static ISolutionApproach[] approachProvider() {
		return new ISolutionApproach[] { new LC80_Approach_1(), new LC80_Approach_2() };
	}

}
