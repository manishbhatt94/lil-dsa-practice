package manish.dsa.arrays.twopointers.LC15_ThreeSumToZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumToZero {

	public List<List<Integer>> threeSum(int[] nums) {
		int N = nums.length;
		List<List<Integer>> result = new ArrayList<>();

		if (N < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < (N - 2); i++) {
			if (nums[i] > 0) {
				// when 1st element of triplet is positive, in sorted array,
				// then further triplets summing to zero can't be found.
				break;
			}

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int target = -1 * nums[i];

			int left = i + 1;
			int right = N - 1;
			while (left < right) {
				if (nums[left] > target) {
					// first element itself, of pair, is greater than 'target'
					// so pair can't be found since any nums[left] (right > left)
					// will be greater only & so pairSum would exceed target
					break;
				}
				int pairSum = nums[left] + nums[right];
				if (pairSum < target) {
					left = left + 1;
				} else if (pairSum > target) {
					right = right - 1;
				} else {
					List<Integer> triplet = List.of(nums[i], nums[left], nums[right]);
					result.add(triplet);
					left = left + 1;
					right = right - 1;
					while (left < right && nums[left] == nums[left - 1]) {
						left = left + 1;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right = right - 1;
					}
				}
			}
		}

		return result;
	}
}
