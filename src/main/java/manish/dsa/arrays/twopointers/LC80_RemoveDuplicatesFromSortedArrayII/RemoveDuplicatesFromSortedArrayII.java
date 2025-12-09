package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

interface ISolutionApproach_LC80 {
	int removeDuplicates(int[] nums);
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
