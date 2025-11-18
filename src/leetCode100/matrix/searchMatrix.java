package leetCode100.matrix;

public class searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        // 右上角开始
        int m = matrix.length, n = matrix[0].length;
        int top = 0, right = n - 1;
        while (top < m && right >= 0) {
            int x = matrix[top][right];
            if (target == x) return true;
            else if (target > x) top++;
            else right--;
        }
        return false;
    }
}
