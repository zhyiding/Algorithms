package _2_searching._2_binary_search;

/* LC #74 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;

        int lo = 0;
        int hi = m - 1;
        // search by row
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        int r = lo;
        lo = 0;
        hi = n - 1;
        // search by column
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[r][mid] == target) return true;
            else if (matrix[r][mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return matrix[r][lo] == target;
    }
}
