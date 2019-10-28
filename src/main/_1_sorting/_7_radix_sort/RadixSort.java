package _1_sorting._7_radix_sort;

import java.util.Arrays;

public class RadixSort {

    public static void radixSort(String[] strs, int range) {
        if (strs.length == 0 || range == 0) return;
        for (int i = range; i >= 0; i--) {
            countingSort(strs, i);
        }
    }

    public static void countingSort(String[] strs, int index) {
        int[] count = new int[26];
        String[] output = new String[strs.length];

        // count characters at index
        for (String s : strs) {
            int c = index >= s.length() ? 0 : s.charAt(index) - 'a';
            count[c]++;
        }

        // shift
        for (int i = 1; i < 26; i++) {
            count[i] += count[i - 1];
        }

        // build output
        for (int i = strs.length - 1; i >= 0; i--) {
            int c = index >= strs[i].length() ? 0 : strs[i].charAt(index) - 'a';
            count[c]--;
            output[count[c]] = strs[i];
        }

        for (int i = 0; i < output.length; i++) {
            strs[i] = output[i];
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"bucket", "insertion", "selection", "merge", "heap", "bubble", "quick", "radix", "shuffle"};
        radixSort(strs, 10);
        System.out.println(Arrays.toString(strs));
    }
}
