package _9_dynamic_programming._2_finite_state_machines;

import java.util.Arrays;

// #123
public class Stock3 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] states = new int[4];
        Arrays.fill(states, Integer.MIN_VALUE);

        for (int p : prices) {
            states[0] = Math.max(states[0], -p);
            states[1] = Math.max(states[1], states[0] + p);
            states[2] = Math.max(states[2], states[1] - p);
            states[3] = Math.max(states[3], states[2] + p);
        }
        return states[3];
    }

    public static void main(String[] args) {
        Stock3 stock = new Stock3();
        System.out.println(stock.maxProfit(new int[] {3,3,5,0,0,3,1,4}) == 6);
    }
}
