package _3_common_collections._6_priority_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 373
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0 || k == 0)  return ans;

        // sort by minimum sum
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]
        );

        for (int i = 0; i < Math.min(len1, k); i++)  minHeap.add(new int[] {i, 0});
        while (k > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            ans.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (cur[1] + 1 < len2) {
                minHeap.add(new int[] {cur[0], cur[1] + 1});
            }
            k--;
        }
        return ans;
    }
}
