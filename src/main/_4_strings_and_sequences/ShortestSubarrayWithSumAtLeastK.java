package _4_strings_and_sequences;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int minLen = n + 1;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + A[i];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (!q.isEmpty() && preSum[i] <= preSum[q.getLast()]) {
                q.pollLast();
            }

            while (!q.isEmpty() && preSum[i] - preSum[q.getFirst()] >= K) {
                int curLen = i - q.pollFirst();
                minLen = Math.min(minLen, curLen);
            }
            q.addLast(i);
        }
        return minLen == n + 1 ? -1 : minLen;
    }
}
