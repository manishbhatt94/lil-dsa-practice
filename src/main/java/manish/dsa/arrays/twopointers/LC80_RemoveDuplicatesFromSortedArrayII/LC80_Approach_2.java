package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

public class LC80_Approach_2 implements ISolutionApproach_LC80 {

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

}
