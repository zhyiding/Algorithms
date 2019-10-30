package _9_dynamic_programming._2_finite_state_machines;

// #121, DFA approach
public class Stock {
    public int maxProfit(int[] prices) {
        int state1 = Integer.MIN_VALUE;
        int state2 = Integer.MIN_VALUE;

        for (int p : prices) {
            state1 = Math.max(state1, -p);
            state2 = Math.max(state1 + p, state2);
        }
        return state2;
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        System.out.println(stock.maxProfit(new int[] {7,1,5,3,6,4}) == 5);
    }
}
