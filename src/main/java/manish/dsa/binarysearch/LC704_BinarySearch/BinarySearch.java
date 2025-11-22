
package manish.dsa.binarysearch.LC704_BinarySearch;

public class BinarySearch {
    public int searchIterative(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public int searchRecursive(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return helper(nums, target, mid + 1, r);
        return helper(nums, target, l, mid - 1);
    }
}
