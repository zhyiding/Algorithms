package _9_dynamic_programming._2_finite_state_machines;

import java.util.Arrays;

// #188
public class Stock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (2 * k > prices.length) k = prices.length / 2;

        int[] dp = new int[2 * k + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int p : prices) {
            for (int i = 1; i <= 2 * k; i++) {
                if (i % 2 == 1) {
                    dp[i] = Math.max(dp[i], dp[i-1] - p);
                } else {
                    dp[i] = Math.max(dp[i], dp[i-1] + p);
                }
            }
        }
        return dp[2 * k];
    }

    public static void main(String[] args) {
        Stock4 stock = new Stock4();
        System.out.println(stock.maxProfit(2, new int[] {3,2,6,5,0,3}) == 7);
    }
}
