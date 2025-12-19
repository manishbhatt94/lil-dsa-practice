package manish.dsa.arrays.twopointers.LC26_RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class LC26_Approach_1 implements SolutionApproach, Debuggable {

	@Override
	public int removeDuplicates(int[] nums) {
		// TODO Auto-generated method stub
		return 0;
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
