package manish.dsa.arrays.twopointers.LC75_SortColors;

import java.util.Arrays;

public class LC75_SortColors_OptimalApproach_DutchNationalFlag implements SolutionApproach, Debuggable {
	/*
	 * @formatter:off
	 * Let's divide the array into already sorted segments of zero's / one's /
	 * two's, and the segment that is still yet to be processed.
	 *
	 * First, let N = Length (or size) of the array.
	 *
	 * Let's take the starting & ending index of the array:
	 * start = 0 (first index of array),
	 * end = N - 1 (last index of array).
	 *
	 * Now let's partition the array into:
	 * 1) The leftmost part containing all zero's (All 0's).
	 * 2) Next segment contains all one's (All 1's).
	 * 3) Next segment is the part which is yet to be processed one by one.
	 * 4) Finally, the rightmost part - which contains all two's (All 2's).
	 *
	 * To divide an array into 4 parts, we need 3 index variables or pointers
	 * (i.e. plain int variables which store array indexes):
	 * => low, mid, high.
	 *
	 * The following invariant must be maintained during the processing,
	 * which uses these 3 pointers to divide the array into 4 parts,
	 * as described above:
	 * - All zero's in the closed range [start, low - 1].
	 * - All one's in the closed range [low, mid - 1].
	 * - All unprocessed elements in the closed range [mid, high].
	 * - All two's in the closed range [high + 1, end].
	 *
	 * We initialize these pointers as below, to keep the invariant satisfied
	 * even before processing starts:
	 *
	 * start = 0
	 * end = N - 1
	 *
	 * low = start	(low = 0)
	 * mid = start	(mid = 0)
	 * high = end	(high = N - 1)
	 *
	 * With this initialization, the invariant holds true. You can verify the
	 * ranges for each part as described above.
	 *
	 * @formatter:on
	 */
	@Override
	public void sortColors(int[] nums) {
		// We will use the integers 0, 1, and 2 to represent
		// the color red, white, and blue, respectively.
		int low = 0;
		int high = nums.length - 1;
		int mid = low;

		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, mid, low);
				low = low + 1;
				mid = mid + 1; // coz nums[low] can only contain 1.
			} else if (nums[mid] == 2) {
				swap(nums, mid, high);
				high = high - 1;
			} else {
				mid = mid + 1;
			}
		}
	}

	@Override
	public void logActualOutput(int[] updatedNums) {
		System.out.println("Logging Actual Output:");
		System.out.println("Actual Output: nums = " + Arrays.toString(updatedNums));
		System.out.println("============================================\n");
	}

	private void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
