package _1_sorting._5_bucket_sort;

import java.util.*;

/**
 * LeetCode #347
 * Time complexity = O(N), better than using PriorityQueue of O(N*log(N))
 */
public class TopKFrequentElements {

    public static List<Integer> topK(int[] nums, int K) {
        // assert K <= countUniqueElements(nums) : "Invalid Argument K";
        if (nums.length == 0 || K == 0) return new ArrayList<>();

        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int n : nums) {
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : numFreq.keySet()) {
            int freq = numFreq.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(num);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = nums.length; i > 0; i--) {
            if (bucket[i] == null) continue;
            for (int num : bucket[i]) {
                answer.add(num);
                if (answer.size() == K) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 3, 2, 5, 6, 2, 1, 0, 8, 9, 8, 7};
        List<Integer> ans = topK(nums, 3);
        System.out.println(ans.toString());
    }
}
