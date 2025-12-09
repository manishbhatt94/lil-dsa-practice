package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveDuplicatesFromSortedArrayIITest {

	@ParameterizedTest
	@MethodSource("approachAndTestCases")
	void testRemoveDuplicates(ISolutionApproach_LC80 approach, TestCase tc) {
		// work on a copy of input array - since the algorithm modifies the input array
		int[] arrCopy = Arrays.copyOf(tc.input.nums, tc.input.nums.length);
		int actualK = approach.removeDuplicates(arrCopy);

		assertThat(tc.output.expectedArr).hasSize(tc.output.expectedK);
		assertThat(actualK).isEqualTo(tc.output.expectedK);
		assertThat(Arrays.copyOf(arrCopy, actualK)).isEqualTo(tc.output.expectedArr);
	}

	// --- Inner static classes for test data ---
	static class TestCaseInput {
		final int[] nums;

		TestCaseInput(int[] nums) {
			this.nums = nums;
		}
	}

	static class TestCaseOutput {
		final int expectedK;
		final int[] expectedArr;

		TestCaseOutput(int expectedK, int[] expectedArr) {
			this.expectedK = expectedK;
			this.expectedArr = expectedArr;
		}
	}

	static class TestCase {
		final TestCaseInput input;
		final TestCaseOutput output;

		TestCase(TestCaseInput input, TestCaseOutput output) {
			this.input = input;
			this.output = output;
		}
	}

	// --- Provider combining approaches × test cases ---
	private static Stream<Arguments> approachAndTestCases() {
		ISolutionApproach_LC80[] approaches = { new LC80_Approach_1(), new LC80_Approach_2() };

		// @formatter:off
		TestCase[] cases = {
				new TestCase(
						new TestCaseInput(new int[] { 1, 1, 1, 2, 2, 3 }),
						new TestCaseOutput(5, new int[] { 1, 1, 2, 2, 3 })
				),
				new TestCase(
						new TestCaseInput(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }),
						new TestCaseOutput(7, new int[] { 0, 0, 1, 1, 2, 3, 3 })
				),
				new TestCase(
						new TestCaseInput(new int[] { 1, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 6, 6, 6, 7, 7, 8 }),
						new TestCaseOutput(13, new int[] { 1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8 })
				),
		};
		// @formatter:on

		// Cartesian product: each approach × each test case
		return Arrays.stream(approaches)
				.flatMap(approach -> Arrays.stream(cases).map(tc -> Arguments.of(approach, tc)));
	}

}
