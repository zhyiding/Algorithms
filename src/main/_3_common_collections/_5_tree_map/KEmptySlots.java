package _3_common_collections._5_tree_map;

import java.util.TreeSet;

// #683
public class KEmptySlots {
    public int kEmptySlots(int[] bulbs, int K) {
        if (bulbs.length == 0) return -1;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            ts.add(bulbs[i]);
            Integer higher = ts.higher(bulbs[i]);
            Integer lower = ts.lower(bulbs[i]);
            if (higher != null && higher - bulbs[i] == K + 1 ||
                    lower != null && bulbs[i] - lower == K + 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
