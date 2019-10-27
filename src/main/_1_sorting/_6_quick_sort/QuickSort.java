package _1_sorting._6_quick_sort;

import _1_sorting._8_shuffle.RandomShuffle;

import java.util.Arrays;

/**
 * Implementation of quick sort
 * Time complexity = O(N log(N))
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        if (nums.length <= 1) return;
        // To avoid worst case, shuffle the array before quick sort
        RandomShuffle.shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int p = partition(nums, start, end);
        sort(nums, start, p - 1);
        sort(nums, p + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i < end && nums[i] <= nums[start]) i++;
            while (j > start && nums[j] >= nums[start]) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        quickSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
