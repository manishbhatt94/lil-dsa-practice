package manish.dsa.arrays.twopointers.LC75_SortColors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortColorsTest {

	<T extends SolutionApproach & Debuggable> void doTestWithApproach(T approach, TestCase tc) {

		// ===== Prepare =====
		// work on a copy of input array - since the algorithm modifies the input array
		int[] arrCopy = Arrays.copyOf(tc.input.nums, tc.input.nums.length);

		// ===== Run the algorithm =====
		approach.sortColors(arrCopy);

		// ===== Collect & print test debug info: =====
		// Print test case
		tc.log();
		// Print actual output
		approach.logActualOutput(arrCopy);
		System.out.println();

		// ===== Assertions: =====

		// Validate test case correctness:
		// Test that the input array contains only 0, 1, 2.
		List<Integer> inputArrList = IntStream.of(tc.input.nums).boxed().toList();
		assertThat(inputArrList).allSatisfy(num -> assertThat(num).isIn(0, 1, 2));

		// Test that algorithm doesn't change the array contents, only sorts them
		assertThat(tc.input.nums).containsExactlyInAnyOrder(arrCopy);

		// Test that the algorithm sorts the array
		assertThat(arrCopy).isSorted();
	}

	@ParameterizedTest
	@MethodSource("approachAndTestCases")
	<T extends SolutionApproach & Debuggable> void testRemoveDuplicates(T approach, TestCase tc) {

		doTestWithApproach(approach, tc);
	}

	// --- Inner static classes for test data ---
	static class TestCaseInput {
		final int[] nums;

		public TestCaseInput(int[] nums) {
			super();
			this.nums = nums;
		}

		void log() {
			System.out.println("Logging Test Case Input:");
			System.out.println("Input: nums[] = " + Arrays.toString(nums));
		}
	}

	static class TestCaseOutput {
		TestCaseOutput() {
			super();
		}

		void log() {
			System.out.println("Logging Test Case Expected Output:");
			System.out.println("Expected Output: No extra output.");
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
		List<Supplier<T>> approachSuppliers = List.of(() -> (T) new LC75_SortColors_Approach_AdHoc(),
				() -> (T) new LC75_SortColors_OptimalApproach_DutchNationalFlag());

		// @formatter:off
		TestCase[] cases = {
			new TestCase(
				new TestCaseInput(new int[] { 2, 0 }),
				new TestCaseOutput()
			),
			new TestCase(
				new TestCaseInput(new int[] { 2, 0, 1 }),
				new TestCaseOutput()
			),
			new TestCase(
				new TestCaseInput(new int[] { 2, 0, 2, 1, 1, 0 }),
				new TestCaseOutput()
			),
			new TestCase(
				new TestCaseInput(new int[] { 2, 0, 1, 1, 2, 0, 0, 2, 0, 1, 0, 2, 1 }),
				new TestCaseOutput()
			)
		};
		// @formatter:on

		// Cartesian product: each approach × each test case
		return approachSuppliers.stream().flatMap((approachSupplier) -> {
			return Arrays.stream(cases).map(tc -> Arguments.of(approachSupplier.get(), tc));
		});
	}

}
