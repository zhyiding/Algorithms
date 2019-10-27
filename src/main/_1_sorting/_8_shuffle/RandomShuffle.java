package _1_sorting._8_shuffle;

import java.util.Arrays;
import java.util.Random;

public class RandomShuffle {

    public static void shuffle(int[] nums) {
        int N = nums.length;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            swap(nums, i, random.nextInt(N));
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] sortedArr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(sortedArr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
