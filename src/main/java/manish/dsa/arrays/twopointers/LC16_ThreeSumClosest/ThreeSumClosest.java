package manish.dsa.arrays.twopointers.LC16_ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		if (n < 3) {
			throw new IllegalArgumentException("Invalid input");
		}
		Arrays.sort(nums);

		int minDiff = Integer.MAX_VALUE;
		int closestTripletSum = Integer.MAX_VALUE;

		for (int i = 0; i < (n - 2); i++) {
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int diff = Math.abs(sum - target);
				if (diff < minDiff) {
					minDiff = diff;
					closestTripletSum = sum;
				}

				if (sum > target) {
					right = right - 1;
				} else if (sum < target) {
					left = left + 1;
				} else {
					// sum == target
					// minimum possible difference found (directly return)
					// or triplet with sum closest (i.e. equal) to target found
					return sum;
				}
			}
		}

		return closestTripletSum;
	}
}
