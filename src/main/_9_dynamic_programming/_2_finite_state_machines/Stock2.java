package _9_dynamic_programming._2_finite_state_machines;

// #122
public class Stock2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int state1 = Integer.MIN_VALUE; // purchased
        int state2 = 0; // init or sold

        for (int p : prices) {
            int old_s2 = state2;
            state1 = Math.max(state1, state2 - p);
            state2 = Math.max(old_s2, state1 + p);
        }
        return state2;
    }

    public static void main(String[] args) {
        Stock2 stock = new Stock2();
        System.out.println(stock.maxProfit(new int[] {7,1,5,3,6,4}) == 7);
    }
}
