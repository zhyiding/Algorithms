package _1_sorting._4_heap_sort;

import java.util.Arrays;

/**
 * Implementation of Heap Sort
 * Time complexity = O(N*Log(N))
 */
public class HeapSort {

    // sort increasingly
    public static void heapSort(int[] nums) {
        if (nums.length <= 1) return;

        // build max heap through bottom-up
        int N = nums.length;
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(nums, i, N);
        }

        // sorting
        for (int i = N - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
    }

    public static void heapify(int[] nums, int top, int size) {
        int left = top * 2 + 1;
        int right = top * 2 + 2;
        if (left > size - 1) return; // top node has no children

        int maxChild = left;
        if (right <= size - 1) {
            maxChild = nums[left] > nums[right] ? left : right;
        }

        if (nums[top] < nums[maxChild]) {
            swap(nums, top, maxChild);
            heapify(nums, maxChild, size);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArr = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        heapSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
