package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RemoveDuplicatesFromSortedArrayIITest {

	<T extends SolutionApproach & Debuggable> void doTestWithApproach(T approach, TestCase tc) {

		// ===== Prepare =====
		// work on a copy of input array - since the algorithm modifies the input array
		int[] arrCopy = Arrays.copyOf(tc.input.nums, tc.input.nums.length);

		// ===== Run the algorithm =====
		int actualK = approach.removeDuplicates(arrCopy);

		// ===== Collect & print test debug info: =====
		// Print test case
		tc.log();
		// Print actual output
		approach.logActualOutput(actualK, arrCopy);
		System.out.println();

		// ===== Assertions: =====
		// Test if expected array size matches expected k (this is only for test case
		// validity check)
		assertThat(tc.output.expectedArr).hasSize(tc.output.expectedK);
		// Test actual vs expected
		assertThat(actualK).isEqualTo(tc.output.expectedK);
		assertThat(Arrays.copyOf(arrCopy, actualK)).isEqualTo(tc.output.expectedArr);

	}

	@ParameterizedTest
	@MethodSource("approachAndTestCases")
	<T extends SolutionApproach & Debuggable> void testRemoveDuplicates(T approach, TestCase tc) {

		doTestWithApproach(approach, tc);
	}

	// --- Inner static classes for test data ---
	private static class TestCaseInput {
		final int[] nums;

		TestCaseInput(int[] nums) {
			this.nums = nums;
		}

		void log() {
			System.out.println("Logging Test Case Input:");
			System.out.println("Input: nums = " + Arrays.toString(nums));
		}
	}

	private static class TestCaseOutput {
		final int expectedK;
		final int[] expectedArr;

		TestCaseOutput(int expectedK, int[] expectedArr) {
			this.expectedK = expectedK;
			this.expectedArr = expectedArr;
		}

		void log() {
			System.out.println("Logging Test Case Expected Output:");
			System.out.println("Expected Output: expectedK = " + expectedK);
			System.out.println("Expected Output: expectedArr = " + Arrays.toString(expectedArr));
		}
	}

	static class TestCase {
		final TestCaseInput input;
		final TestCaseOutput output;

		TestCase(TestCaseInput input, TestCaseOutput output) {
			this.input = input;
			this.output = output;
		}

		void log() {
			input.log();
			System.out.println("---------------------------------------\n");
			output.log();
			System.out.println("---------------------------------------\n");
		}
	}

	// --- Provider combining approaches × test cases ---
	private static <T extends SolutionApproach & Debuggable> Stream<Arguments> approachAndTestCases() {

		@SuppressWarnings("unchecked")
		List<Supplier<T>> approachSuppliers = List.of(() -> {
			return (T) new LC80_Approach_1();
		}, () -> {
			return (T) new LC80_Approach_2();
		});

		// @formatter:off
		TestCase[] cases = {
			new TestCase(
				new TestCaseInput(new int[] {}),
				new TestCaseOutput(0, new int[] {})
			),
			new TestCase(
				new TestCaseInput(new int[] { 7 }),
				new TestCaseOutput(1, new int[] { 7 })
			),
			new TestCase(
				new TestCaseInput(new int[] { 1, 2 }),
				new TestCaseOutput(2, new int[] { 1, 2 })
			),
			new TestCase(
				new TestCaseInput(new int[] { 1, 1 }),
				new TestCaseOutput(2, new int[] { 1, 1 })
			),
			new TestCase(
				new TestCaseInput(new int[] { -7, -4, -1 }),
				new TestCaseOutput(3, new int[] { -7, -4, -1 })
			),
			new TestCase(
				new TestCaseInput(new int[] { 1, 1, 2 }),
				new TestCaseOutput(3, new int[] { 1, 1, 2 })
			),
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
		return approachSuppliers.stream().flatMap((approachSupplier) -> {
			return Arrays.stream(cases).map(tc -> Arguments.of(approachSupplier.get(), tc));
		});
	}

}
