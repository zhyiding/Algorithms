package _2_searching._2_binary_search;

/* LeetCode #33 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0;
        int j = nums.length - 1;

        // if rotated, find the pivot
        if (nums[i] > nums[j]) {
            while (i < j) {
                int mid = i + (j - i + 1) / 2;
                if (nums[mid] > nums[i]) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
        }

        int pivot = i;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int realMid = (mid + pivot) % nums.length;
            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        System.out.println(solution.search(new int[] {3,5,6,0,1,2}, 4));
        System.out.println(solution.search(new int[] {3,5,6,0,1,2}, 1));
    }
}
