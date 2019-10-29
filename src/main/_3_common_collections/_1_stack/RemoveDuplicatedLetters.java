package _3_common_collections._1_stack;

import java.util.Stack;

public class RemoveDuplicatedLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (seen[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                seen[stack.pop() - 'a'] = false;
            }
            seen[c - 'a'] = true;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abacbd";
        System.out.println(new RemoveDuplicatedLetters().removeDuplicateLetters(s));
    }
}
