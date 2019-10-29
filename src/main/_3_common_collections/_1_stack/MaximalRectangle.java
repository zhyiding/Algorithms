package _3_common_collections._1_stack;

import java.util.Stack;

// LC #85
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] intMatrix = new int[matrix[0].length];
        int maxRectangle = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    intMatrix[j] = 0;
                } else {
                    intMatrix[j] += 1;
                }
            }
            int temp = largestRectangleArea(intMatrix);
            maxRectangle = Math.max(maxRectangle, temp);
        }
        return maxRectangle;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // monotone increasing stack
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - 1 - start);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                new char[] {'1','0','1','0','0'},
                new char[] {'1','0','1','1','1'},
                new char[] {'1','1','1','1','1'},
                new char[] {'1','0','0','1','0'}
        };
        MaximalRectangle solution = new MaximalRectangle();
        int answer = solution.maximalRectangle(matrix);
        System.out.println(answer);
    }
}
