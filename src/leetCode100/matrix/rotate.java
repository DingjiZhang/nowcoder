package leetCode100.matrix;

public class rotate {

    // 顺时针转90：转置+每行反转
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) return;

        int n = matrix.length;
        // 转置：上三角
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }

        // 每行反转
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int t = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = t;
                l++;
                r--;
            }
        }

    }
}
