
package manish.dsa.arrays.twopointers.LC167_TwoSumII;

public class TwoSumII {
    // Assumes input is 1-indexed in LeetCode; we'll return 0-indexed pair for simplicity
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l, r};
            if (sum < target) l++;
            else r--;
        }
        return new int[0];
    }
}
