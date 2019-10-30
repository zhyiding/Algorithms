package _4_strings_and_sequences;

import java.util.HashMap;
import java.util.Map;

// #325
public class LongestSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>(); // Map.Entry = <PrefixSum, Index>
        hm.put(0, -1);
        int answer = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (hm.containsKey(prefixSum - k)) {
                answer = Math.max(answer, i - hm.get(prefixSum - k));
            }
            if (!hm.containsKey(prefixSum)) {
                hm.put(prefixSum, i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarraySumEqualsK().maxSubArrayLen(new int[] {1, -1, 5, -2, 3}, 3));
    }
}
