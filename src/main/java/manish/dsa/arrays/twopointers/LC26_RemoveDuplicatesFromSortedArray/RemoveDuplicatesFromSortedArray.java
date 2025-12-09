package manish.dsa.arrays.twopointers.LC26_RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

interface ISolutionApproach_LC26 {
	int removeDuplicates(int[] nums);

	static void logActualOutput(int k, int[] updatedNums) {
		System.out.println("Logging Actual Output:");
		System.out.println("Actual Output: k = " + k);
		System.out.println("Actual Output: nums = " + Arrays.toString(updatedNums));
		System.out.println("Actual Output: nums upto k elements = " + Arrays.toString(Arrays.copyOf(updatedNums, k)));
		System.out.println("============================================\n");
	}
}

public class RemoveDuplicatesFromSortedArray {

	private ISolutionApproach_LC26 approach;

	public RemoveDuplicatesFromSortedArray() {
		super();
	}

	public RemoveDuplicatesFromSortedArray(ISolutionApproach_LC26 approach) {
		super();
		this.approach = approach;
	}

	public int removeDuplicates(int[] nums) {
		return approach.removeDuplicates(nums);
	}
}
