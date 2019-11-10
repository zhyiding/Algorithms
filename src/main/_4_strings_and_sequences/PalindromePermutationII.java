package _4_strings_and_sequences;

import java.util.ArrayList;
import java.util.List;

// 267
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) return ans;

        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        char odd = 0;
        for (char i = 0; i < 256; i++) {
            if (map[i] % 2 == 1) {
                if (odd != 0) return ans;
                odd = i;
            }
            map[i] /= 2;
        }

        StringBuilder sb = new StringBuilder();
        if (odd != 0) sb.append(odd);
        buildPalindromes(map, ans, sb, s.length());
        return ans;
    }

    public void buildPalindromes(int[] map, List<String> ans, StringBuilder sb, int N) {
        if (sb.length() == N) {
            ans.add(sb.toString());
            return;
        }

        for (char i = 0; i < 256; i++) {
            if (map[i] > 0) {
                sb.insert(0, i);
                sb.append(i);
                map[i]--;
                buildPalindromes(map, ans, sb, N);

                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                map[i]++;
            }
        }
    }

    public static void main (String[] args) {
        PalindromePermutationII solution = new PalindromePermutationII();
        List<String> list = solution.generatePalindromes("a");
        System.out.println(list);
    }
}
