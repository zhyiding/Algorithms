package _9_dynamic_programming._2_finite_state_machines;

import java.util.LinkedList;
import java.util.Queue;

public class StockWithKCoolDownDay {
    public int maxProfit(int[] prices, int k) {
        if (prices.length == 0) return 0;
        Queue<Integer> CDQueue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            CDQueue.offer(0);
        }
        int state1 = Integer.MIN_VALUE; // purchased
        int state2 = 0; // sold
        for (int p : prices) {
            int cooldown = CDQueue.poll();
            state1 = Math.max(state1, cooldown - p);
            CDQueue.offer(state2);
            state2 = Math.max(state2, state1 + p);
        }
        return state2;
    }

    public static void main(String[] args) {
        StockWithKCoolDownDay stock = new StockWithKCoolDownDay();
        System.out.println(stock.maxProfit(new int[] {1,2,3,0,2,3}, 1) == 4);
        System.out.println(stock.maxProfit(new int[] {1,2,3,0,2,3}, 2) == 3);
    }
}
