package _3_common_collections._6_priority_queue;

import java.util.PriorityQueue;

// #295
public class MedianOfDataStream {

    PriorityQueue<Integer> lowerPart = null; // maximum of smaller numbers
    PriorityQueue<Integer> higherPart = null; // minimum of larger numbers
    long count;

    /** initialize your data structure here. */
    public void MedianFinder() {
        lowerPart = new PriorityQueue<>((a, b) -> (b - a));
        higherPart = new PriorityQueue<>();
        count = 0;
    }

    public void addNum(int num) {
        count++;

        lowerPart.offer(num);
        higherPart.offer(lowerPart.poll());
        if (higherPart.size() > lowerPart.size()) {
            lowerPart.offer(higherPart.poll());
        }
    }

    public double findMedian() {
        if (count % 2 == 1) return lowerPart.peek() / 1.0;
        return (lowerPart.peek() + higherPart.peek()) / 2.0;
    }
}
