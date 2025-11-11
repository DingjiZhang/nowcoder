package nowCoder.mySimulate;

import java.util.ArrayList;

public class printMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        //四个边界指针「上、下、左、右」围成当前还未打印的外层圈，每打印一圈就收缩一次边界。
        // 注意单行/单列时不要重复打印
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return ans;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            // 左 到 右
            for (int j = left; j <= right; j++) ans.add(matrix[top][j]);
            // 上 到 下
            for (int i = top + 1; i <= bottom; i++) ans.add(matrix[i][right]);
            // 右 到 左（至少两行时）
            if (top < bottom) {
                for (int j = right - 1; j >= left; j--) ans.add(matrix[bottom][j]);
            }
            // 下 到 上（至少两列时）
            if (left < right) {
                for (int i = bottom - 1; i > top; i--) ans.add(matrix[i][left]);
            }
            // 收缩边界
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans;
    }
}
