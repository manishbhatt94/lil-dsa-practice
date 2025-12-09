package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

interface ISolutionApproach_LC80 {
	int removeDuplicates(int[] nums);

	static void logActualOutput(int k, int[] updatedNums) {
		System.out.println("Logging Actual Output:");
		System.out.println("Actual Output: k = " + k);
		System.out.println("Actual Output: nums = " + Arrays.toString(updatedNums));
		System.out.println("Actual Output: nums upto k elements = " + Arrays.toString(Arrays.copyOf(updatedNums, k)));
		System.out.println("============================================\n");
	}
}

public class RemoveDuplicatesFromSortedArrayII {

	private ISolutionApproach_LC80 approach;

	public RemoveDuplicatesFromSortedArrayII() {
		super();
	}

	public RemoveDuplicatesFromSortedArrayII(ISolutionApproach_LC80 approach) {
		this.approach = approach;
	}

	public int removeDuplicates(int[] nums) {
		return approach.removeDuplicates(nums);
	}
}
