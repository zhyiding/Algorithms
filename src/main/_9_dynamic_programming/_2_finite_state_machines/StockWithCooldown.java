package _9_dynamic_programming._2_finite_state_machines;

// #309
public class StockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int cooldown = 0;
        int state1 = Integer.MIN_VALUE; // purchased
        int state2 = 0; // sold
        for (int p : prices) {
            state1 = Math.max(state1, cooldown - p);
            cooldown = state2;
            state2 = Math.max(state2, state1 + p);
        }
        return state2;
    }

    public static void main(String[] args) {
        StockWithCooldown stock = new StockWithCooldown();
        System.out.println(stock.maxProfit(new int[] {1,2,3,0,2}) == 3);
    }
}
