package _1_sorting._2_insertion_and_selectoin_sort;

import java.util.Arrays;

/* *
 * Implementation of Selection Sort
 * Time complexity = O(N^2)
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 0; i < nums.length; i++) {
            int minVal = Integer.MAX_VALUE;
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < minVal) {
                    minVal = nums[j];
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        sort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
