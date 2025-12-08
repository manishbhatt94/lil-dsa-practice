package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

interface ISolutionApproach {
	int removeDuplicates(int[] nums);
}

public class RemoveDuplicatesFromSortedArrayII {

	private ISolutionApproach approach;

	public RemoveDuplicatesFromSortedArrayII() {
		super();
	}

	public RemoveDuplicatesFromSortedArrayII(ISolutionApproach approach) {
		this.approach = approach;
	}

	public int removeDuplicates(int[] nums) {
		return approach.removeDuplicates(nums);
	}
}
