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

		for (int k = 0; k < (N - 2); k++) {
			if (nums[k] > 0) {
				// when 1st element of triplet is positive, in sorted array,
				// then further triplets summing to zero can't be found.
				break;
			}

			if (k > 0 && nums[k] == nums[k - 1]) {
				continue;
			}

			int target = -1 * nums[k];

			int i = k + 1;
			int j = N - 1;
			while (i < j) {
				int pairSum = nums[i] + nums[j];
				if (pairSum < target) {
					i = i + 1;
				} else if (pairSum > target) {
					j = j - 1;
				} else {
					List<Integer> triplet = List.of(nums[k], nums[i], nums[j]);
					result.add(triplet);
					i = i + 1;
					j = j - 1;
					while (i < j && nums[i] == nums[i - 1]) {
						i = i + 1;
					}
					while (i < j && nums[j] == nums[j + 1]) {
						j = j - 1;
					}
				}
			}
		}

		return result;
	}
}
