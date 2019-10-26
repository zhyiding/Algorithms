package _1_sorting._1_bubble_sort;

import java.util.Arrays;

/**
 * Implementation of bubble sort algorithm.
 * Time complexity = O(N^2)
 */
public class BubbleSort {

    // sort increasingly
    public static void sort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
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
