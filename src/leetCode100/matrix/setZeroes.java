package leetCode100.matrix;

public class setZeroes {

    /*
     * 原地算法
     * 使用首行首列当标志位
     * 1.两个布尔值记录首行首列需不需要置零
     * 2.遍历矩阵用首行首列做标记
     * 3.遍历矩阵，根据标记置零（除首行首列）
     * 4.根据布尔首行首列置零
     * */
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length, n = matrix[0].length;

        // 首行首列布尔值
        boolean zeroFirstRow = false, zeroFirstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroFirstCol = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroFirstRow = true;
                break;
            }
        }

        // 做标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 根据布尔置首行首列
        if (zeroFirstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (zeroFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

    }
}
