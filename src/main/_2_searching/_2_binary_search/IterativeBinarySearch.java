package _2_searching._2_binary_search;

/* Search for element index, if doesn't exist, return negative insert position */
public class IterativeBinarySearch {

    public static int binarySearch(int[] nums, int target) {
        // assert isSorted(nums);
        // assert countUniqueElements(nums) == nums.length;

        int N = nums.length;
        if (N == 0 || target < nums[0]) return -1;
        if (target > nums[N - 1]) return -1 - N;

        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            if (lo == hi && nums[lo] != target) {
                return -1 - lo;
            }
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
