package _4_strings_and_sequences;

import java.util.Collections;
import java.util.PriorityQueue;

// #480
public class SlidingWindowMedian {

    PriorityQueue<Integer> MAX_HEAP = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> MIN_HEAP = new PriorityQueue<Integer>();

    void addNum(int num) {
        // Add to max heap
        MAX_HEAP.add(num);
        MIN_HEAP.add(MAX_HEAP.peek());
        MAX_HEAP.poll();

        //adjust size
        while (MAX_HEAP.size() < MIN_HEAP.size()) {
            MAX_HEAP.add(MIN_HEAP.peek());
            MIN_HEAP.poll();
        }
    }

    public double findMedian() {
        return MAX_HEAP.size() == MIN_HEAP.size() ? ((double)MAX_HEAP.peek() + (double)MIN_HEAP.peek()) / 2.0 : MAX_HEAP.size() > MIN_HEAP.size() ? MAX_HEAP.peek() : MIN_HEAP.peek();
    }

    void removeNum(int num) {
        if(num <= MAX_HEAP.peek()) {
            MAX_HEAP.remove(num);
        }
        else {
            MIN_HEAP.remove(num);
        }



    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int size = nums.length - k + 1;
        double[] medians = new double[size];
        for(int i = 0; i < k; i++) {
            addNum(nums[i]);
        }
        medians[0] = findMedian();
        for(int i = 1; i < size; i++) {
            removeNum(nums[i - 1]);
            addNum(nums[i + k - 1]);
            medians[i] = findMedian();
        }
        return medians;
    }
}
