package manish.dsa.arrays.twopointers.GFG_ThreeSumSmaller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GFG_ThreeSumSmaller_Approach implements SolutionApproach, Debuggable {

	private final boolean shouldStoreTriplets;
	private final List<List<Long>> triplets;

	public GFG_ThreeSumSmaller_Approach(boolean shouldStoreTriplets) {
		super();
		this.shouldStoreTriplets = shouldStoreTriplets;
		this.triplets = new ArrayList<>();
	}

	@Override
	public long countTriplets(int n, int sum, long arr[]) {
		if (n < 3) {
			return 0;
		}
		Arrays.sort(arr);
		long count = 0L;

		for (int i = 0; i < (n - 2); i++) {
			if ((arr[i] + arr[i + 1] + arr[i + 2]) >= sum) {
				break;
			}
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				long currSum = arr[i] + arr[left] + arr[right];

				if (currSum >= sum) {
					right = right - 1;
				} else {
					addTriplet(arr, i, left, right);
					count = count + (right - left);
					left = left + 1;
				}
			}
		}

		return count;
	}

	@Override
	public List<List<Long>> getTriplets() {
		return triplets;
	}

	@Override
	public void logActualOutput(long count, List<List<Long>> triplets) {
		System.out.println("Logging Actual Output:");
		System.out.println("Actual Output: count = " + count);
		System.out.println("Actual Output: triplets.size() = " + triplets.size());
		System.out.println("Actual Output: triplets = " + triplets);
		System.out.println("============================================\n");
	}

	// debug this method addTriplet
	private void addTriplet(long[] arr, int firstIndex, int secondIndex, int thirdLastIndex) {
		if (shouldStoreTriplets == false) {
			return;
		}
		for (int thirdIndex = secondIndex + 1; thirdIndex <= thirdLastIndex; thirdIndex++) {
			triplets.add(List.of(arr[firstIndex], arr[secondIndex], arr[thirdIndex]));
		}
	}

}
