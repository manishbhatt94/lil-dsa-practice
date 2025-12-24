package manish.dsa.arrays.twopointers.LC75_SortColors;

import java.util.Arrays;

public class LC75_SortColors_Approach_AdHoc implements SolutionApproach, Debuggable {

	@Override
	public void sortColors(int[] nums) {
		// We will use the integers 0, 1, and 2 to represent
		// the color red, white, and blue, respectively.
		int i = -1;
		int j = i;
		int k = 0;

		while (k < nums.length) {

			if (nums[k] == 0) {
				if (k > 0 && nums[k - 1] == 2) {
					nums[k] = 2;
				}
				if (j >= 0 && nums[j] == 1) {
					j = j + 1;
					nums[j] = 1;
				}
				i = i + 1;
				nums[i] = 0;
				if (j < i) {
					j = i;
				}
			} else if (nums[k] == 1) {
				if (k > 0 && nums[k - 1] == 2) {
					nums[k] = 2;
				}
				j = j + 1;
				nums[j] = 1;
			}

			k = k + 1;
		}
	}

	@Override
	public void logActualOutput(int[] updatedNums) {
		System.out.println("Logging Actual Output:");
		System.out.println("Actual Output: nums = " + Arrays.toString(updatedNums));
		System.out.println("============================================\n");
	}

}
