package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class LC80_Approach_2 implements SolutionApproach, Debuggable {

	@Override
	public int removeDuplicates(int[] nums) {
		int N = nums.length;

		if (N < 3) {
			return N;
		}

		int i = 1;

		for (int j = 2; j < N; j++) {
			if (nums[j] != nums[i - 1]) {
				nums[i + 1] = nums[j];
				i = i + 1;
			}
		}

		return i + 1;
	}

	@Override
	public void logActualOutput(int k, int[] updatedNums) {
		System.out.println("Logging Actual Output:");
		System.out.println("Actual Output: k = " + k);
		System.out.println("Actual Output: nums = " + Arrays.toString(updatedNums));
		System.out.println("Actual Output: nums upto k elements = " + Arrays.toString(Arrays.copyOf(updatedNums, k)));
		System.out.println("============================================\n");
	}

}
