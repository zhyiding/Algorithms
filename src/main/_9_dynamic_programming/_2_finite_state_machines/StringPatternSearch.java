package _9_dynamic_programming._2_finite_state_machines;

import java.util.Arrays;

// KMP algorithm using DFA
public class StringPatternSearch {

    public boolean containsPattern(String s, String p) {
        if (p.length() == 0) return true;
        if (s.length() == 0) return false;

        int[][] dfa = new int[128][p.length()];
        // build dfa
        dfa[p.charAt(0)][0] = 1;
        for (int i = 1, x = 0; i < p.length(); i++) {
            for (int c = 0; c < 26; c++) {
                dfa[c][i] = dfa[c][x];
            }
            dfa[p.charAt(i)][i] = i + 1;
            x = dfa[p.charAt(i)][x];
        }

        return search(s, p, dfa);
    }

    public boolean search(String s, String p, int[][] dfa) {
        int index = 0;
        for (char c : s.toCharArray()) {
            index = dfa[c][index];
            if (index == p.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        String p = "quick brown";
        System.out.println(new StringPatternSearch().containsPattern(s, p));
    }
}
