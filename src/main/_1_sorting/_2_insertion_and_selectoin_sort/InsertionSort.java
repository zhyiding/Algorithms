package _1_sorting._2_insertion_and_selectoin_sort;


import java.util.Arrays;

/* *
 * Implementation of Insertion Sort
 * Time complexity = O(N^2)
 */
public class InsertionSort {

    public static void sort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    insert(nums, i, j);
                }
            }
        }
    }

    public static void insert(int[] nums, int from, int to) {
        int target = nums[from];
        for (int i = from - 1; i >= to; i--) {
            nums[i + 1] = nums[i];
        }
        nums[to] = target;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        sort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
