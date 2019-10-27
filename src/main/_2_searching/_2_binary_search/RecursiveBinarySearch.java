package _2_searching._2_binary_search;

/* Search for element index, if doesn't exist, return negative -1 */
public class RecursiveBinarySearch {

    public static int binarySearch(int[] nums, int target) {
        // assert isSorted(nums);
        // assert countUniqueElements(nums) == nums.length;
        if (nums.length == 0) return -1;
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        // assert subarrayIsSorted(nums, start, end);
        // assert countUniqueElements(nums) == nums.length;
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target){
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return binarySearch(nums, target, start, mid);
        }
    }
}
