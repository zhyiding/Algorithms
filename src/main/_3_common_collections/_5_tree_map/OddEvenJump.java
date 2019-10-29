package _3_common_collections._5_tree_map;

import java.util.Map;
import java.util.TreeMap;

// #975
public class OddEvenJump {

    public int oddEvenJumps(int[] A) {
        if (A.length == 0) return 1;
        int n = A.length;
        int goodJumps = 1;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        boolean[] isGoodAsOddJump = new boolean[n];
        boolean[] isGoodAsEvenJump = new boolean[n];
        tm.put(A[n - 1], n - 1);
        isGoodAsOddJump[n - 1] = true;
        isGoodAsEvenJump[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            // Odd jump next from this index
            Map.Entry<Integer, Integer> smallestLargerEntry = tm.ceilingEntry(A[i]);
            // Is next jump good? As even jump
            if (smallestLargerEntry != null && isGoodAsEvenJump[smallestLargerEntry.getValue()]) {
                goodJumps++;
                isGoodAsOddJump[i] = true;
            }

            // Even jump next from this index
            Map.Entry<Integer, Integer> largestSmallerEntry = tm.floorEntry(A[i]);
            if (largestSmallerEntry != null && isGoodAsOddJump[largestSmallerEntry.getValue()]) {
                // not a starting jump, so do not increment goodJumps
                isGoodAsEvenJump[i] = true;
            }
            tm.put(A[i], i);
        }
        return goodJumps;
    }
}
