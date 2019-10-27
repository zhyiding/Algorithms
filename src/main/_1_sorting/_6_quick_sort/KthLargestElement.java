package _1_sorting._6_quick_sort;

import _1_sorting._8_shuffle.RandomShuffle;

/* LeetCode #215 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        RandomShuffle.shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        while(true) {
            while(i < hi && nums[i] <= nums[lo]) i++;
            while(j > lo && nums[lo] <= nums[j]) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
