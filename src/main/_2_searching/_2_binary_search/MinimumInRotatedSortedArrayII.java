package _2_searching._2_binary_search;

// LC #154
public class MinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int i, int j) {
        if (isSorted(nums, i, j)) return nums[i];
        int mid = i + (j - i) / 2;
        return Math.min(helper(nums, i, mid), helper(nums, mid + 1, j));
    }

    public boolean isSorted(int[] nums, int i, int j) {
        return i == j || nums[i] < nums[j];
    }
}
