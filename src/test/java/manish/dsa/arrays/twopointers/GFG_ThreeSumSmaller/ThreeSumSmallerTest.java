package manish.dsa.arrays.twopointers.GFG_ThreeSumSmaller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ThreeSumSmallerTest {

	<T extends SolutionApproach & Debuggable> void doTestWithApproach(T approach, TestCase tc) {

		// ===== Run the algorithm =====
		long actualCount = approach.countTriplets(tc.input.n, tc.input.sum, tc.input.arr);

		// ===== Collect & print test debug info: =====
		// Print test case
		tc.log();
		// Print actual output
		List<List<Long>> actualTriplets = approach.getTriplets();
		approach.logActualOutput(actualCount, actualTriplets);
		System.out.println();

		// ===== Assertions: =====
		// Test if expected triplets size matches expected count (this is only test for
		// test case validity)
		assertThat(tc.output.expectedTriplets).hasSize((int) tc.output.expectedCount);

		// Test actual vs expected
		assertThat(actualCount).isEqualTo(tc.output.expectedCount);
		assertThat(actualTriplets).containsExactlyInAnyOrderElementsOf(tc.output.expectedTriplets);
	}

	@ParameterizedTest
	@MethodSource("approachAndTestCases")
	<T extends SolutionApproach & Debuggable> void testRemoveDuplicates(T approach, TestCase tc) {

		doTestWithApproach(approach, tc);
	}

	// --- Inner static classes for test data ---
	static class TestCaseInput {
		final int n;
		final int sum;
		final long[] arr;

		public TestCaseInput(int n, int sum, long[] arr) {
			super();
			this.n = n;
			this.sum = sum;
			this.arr = arr;
		}

		void log() {
			System.out.println("Logging Test Case Input:");
			System.out.println("Input: n = " + n);
			System.out.println("Input: sum = " + sum);
			System.out.println("Input: arr[] = " + Arrays.toString(arr));
		}
	}

	static class TestCaseOutput {
		final long expectedCount;
		final List<List<Long>> expectedTriplets;

		TestCaseOutput(long expectedCount, List<List<Long>> expectedTriplets) {
			this.expectedCount = expectedCount;
			this.expectedTriplets = expectedTriplets;
		}

		void log() {
			System.out.println("Logging Test Case Expected Output:");
			System.out.println("Expected Output: expectedCount = " + expectedCount);
			System.out.println("Expected Output: expectedTriplets = " + expectedTriplets);
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
		List<Supplier<T>> approachSuppliers = List.of(() -> (T) new GFG_ThreeSumSmaller_Approach(true));

		// @formatter:off
		TestCase[] cases = {
			new TestCase(
				new TestCaseInput(0, 18, new long[] {}),
				new TestCaseOutput(0L, List.of())
			),
			new TestCase(
				new TestCaseInput(1, 10, new long[] { 7L }),
				new TestCaseOutput(0L, List.of())
			),
			new TestCase(
				new TestCaseInput(2, 7, new long[] { 1L, 2L }),
				new TestCaseOutput(0L, List.of())
			),
			new TestCase(
				// arr[] = {-2, 0, 1, 3}, sum = 2, n = 4
				new TestCaseInput(4, 2, new long[] { 1L, 0L, 3L, -2L }),
				// expected count = 2, triplets = {(-2,0,1), (-2,0,3)}
				new TestCaseOutput(2L, List.of(
					List.of(-2L, 0L, 3L),
					List.of(-2L, 0L, 1L)
				))
			),
			new TestCase(
				new TestCaseInput(5, 8, new long[] { -2L, 0L, 1L, 3L, 5L }),
				new TestCaseOutput(8L, List.of(
					List.of(-2L, 0L, 5L),
					List.of(-2L, 0L, 3L),
					List.of(-2L, 0L, 1L),
					List.of(-2L, 1L, 5L),
					List.of(-2L, 1L, 3L),
					List.of(-2L, 3L, 5L),
					List.of(0L, 1L, 5L),
					List.of(0L, 1L, 3L)
				))
			),
			new TestCase(
				new TestCaseInput(8, 100, new long[] { 0L, 20L, 30L, 40L, 60L, 70L, 90L, 100L }),
				new TestCaseOutput(7L, List.of(
					List.of(0L, 20L, 70L),
					List.of(0L, 20L, 60L),
					List.of(0L, 20L, 40L),
					List.of(0L, 20L, 30L),
					List.of(0L, 30L, 60L),
					List.of(0L, 30L, 40L),
					List.of(20L, 30L, 40L)
				))
			),
			new TestCase(
				new TestCaseInput(9, 100, new long[] { 0L, 20L, 22L, 30L, 60L, 70L, 72L, 90L, 100L }),
				new TestCaseOutput(11L, List.of(
					List.of(0L, 20L, 72L),
					List.of(0L, 20L, 70L),
					List.of(0L, 20L, 60L),
					List.of(0L, 20L, 30L),
					List.of(0L, 20L, 22L),
					List.of(0L, 22L, 72L),
					List.of(0L, 22L, 70L),
					List.of(0L, 22L, 60L),
					List.of(0L, 22L, 30L),
					List.of(0L, 30L, 60L),
					List.of(20L, 22L, 30L)
				))
			),
		};
		// @formatter:on

		// Cartesian product: each approach × each test case
		return approachSuppliers.stream().flatMap((approachSupplier) -> {
			return Arrays.stream(cases).map(tc -> Arguments.of(approachSupplier.get(), tc));
		});
	}

}
