package _9_dynamic_programming._1_array_dynamic_programming;

// #91
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.equals("")) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '0') {
                if (i == 0) return 0;
                if (chs[i-1] > '2' || chs[i-1]=='0') return 0;
                dp[i+1] = dp[i-1];
            }
            else if (i > 0 && chs[i-1]=='1')
                dp[i+1] = dp[i]+dp[i-1];
            else if (i > 0 && chs[i-1]=='2' && chs[i] <= '6')
                dp[i+1] = dp[i]+dp[i-1];
            else
                dp[i+1] = dp[i];
        }
        return dp[chs.length];
    }
}
