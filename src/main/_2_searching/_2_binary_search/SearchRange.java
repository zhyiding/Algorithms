package _2_searching._2_binary_search;

import java.util.Arrays;

/* LeetCode #34 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] {-1, -1};
        }

        int[] answer = new int[2];
        int i = 0;
        int j = nums.length - 1;
        // Search for beginning point
        while (i < j) {
            if (i == j - 1) {
                if (nums[i] == target) {
                    answer[0] = i;
                } else if (nums[i] != target && nums[j] == target) {
                    answer[0] = j;
                } else {
                    answer[0] = -1;
                }
                break;
            }
            int mid = i + (j - i + 1) / 2;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid;
            }
        }

        // Search for ending point
        i = 0;
        j = nums.length - 1;
        while (i < j) {
            if (i == j - 1) {
                if (nums[j] == target) {
                    answer[1] = j;
                } else if (nums[i] == target && nums[j] != target) {
                    answer[1] = i;
                } else {
                    answer[1] = -1;
                }
                break;
            }
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid;
            } else {
                j = mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SearchRange solution = new SearchRange();
        int[] answer = solution.searchRange(new int[] {5,7,7,8,8,10}, 8);
        System.out.println(Arrays.toString(answer));
    }
}
