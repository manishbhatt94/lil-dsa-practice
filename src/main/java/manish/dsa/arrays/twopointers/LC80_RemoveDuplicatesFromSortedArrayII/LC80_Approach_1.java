package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class LC80_Approach_1 implements SolutionApproach, Debuggable {

	@Override
	public int removeDuplicates(int[] nums) {
		int N = nums.length;

		if (N < 1) {
			return 0;
		}

		int i = 0;
		int j = 1;

		while (j < N) {
			if (nums[j] == nums[i]) {
				// case: 'same number'
				// then check if nums[i]'s previous is also same or not
				// if not, then include it
				if (i == 0 || nums[i] != nums[i - 1]) {
					nums[i + 1] = nums[j];
					i = i + 1;
				}
			} else {
				// case: 'diff number'
				// unique so far - so include it
				nums[i + 1] = nums[j];
				i = i + 1;
			}
			j = j + 1;
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
