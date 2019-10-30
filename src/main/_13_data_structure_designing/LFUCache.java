package _13_data_structure_designing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

// #460
public class LFUCache {

    private int capacity;
    private int minFrequency;
    private HashMap<Integer, LinkedHashSet<Integer>> keysHash = null; // frequency to keys
    private HashMap<Integer, Integer> valueHash = null; // key to value
    private HashMap<Integer, Integer> freqHash = null; // key to frequency

    public LFUCache(int capacity) {
        keysHash = new HashMap<>();
        valueHash = new HashMap<>();
        freqHash = new HashMap<>();
        this.capacity = capacity;
        minFrequency = 0;
        keysHash.put(0, new LinkedHashSet<Integer>());
    }

    public int get(int key) {
        if (!valueHash.containsKey(key)) return -1;
        int value = valueHash.get(key);
        this.addFrequency(key);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
            addFrequency(key);
        } else {
            if (valueHash.size() == capacity) {
                int popout = keysHash.get(minFrequency).iterator().next();
                removeKey(popout);
            }
            minFrequency = 0;
            keysHash.get(0).add(key);
            freqHash.put(key, 0);
            valueHash.put(key, value);
        }
    }

    private void addFrequency(int key) {
        // update key to new frequency
        int oldFrequency = freqHash.get(key);
        int newFrequency = oldFrequency + 1;
        freqHash.put(key, newFrequency);

        // remove this key from frequency hashtable and put into higher frequency hashtable
        keysHash.get(oldFrequency).remove(key);
        if (!keysHash.containsKey(newFrequency)) {
            keysHash.put(newFrequency, new LinkedHashSet<>());
        }
        keysHash.get(newFrequency).add(key);

        // update minimum frequency
        if (oldFrequency == minFrequency && keysHash.get(oldFrequency).size() == 0) {
            minFrequency++;
        }
    }

    private void removeKey(int key) {
        int freq = freqHash.get(key);
        keysHash.get(freq).remove(key);
        valueHash.remove(key);
        freqHash.remove(key);
    }
}
