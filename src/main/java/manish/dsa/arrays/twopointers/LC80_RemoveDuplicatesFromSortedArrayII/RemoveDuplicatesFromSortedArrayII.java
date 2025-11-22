package manish.dsa.arrays.twopointers.LC80_RemoveDuplicatesFromSortedArrayII;

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
        int N = nums.length;
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
}
