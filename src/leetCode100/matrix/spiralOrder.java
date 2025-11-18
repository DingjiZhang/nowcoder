package leetCode100.matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return ans;

        //
        int top = 0, btm = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (left <= right && top <= btm) {
            // left - right
            for (int j = left; j <= right; j++) ans.add(matrix[top][j]);
            // top - btm
            for (int i = top + 1; i <= btm; i++) ans.add(matrix[i][right]);
            // right - left (at least 2 rows)
            if (top < btm) {
                for (int j = right - 1; j >= left; j--) ans.add(matrix[btm][j]);
            }
            // btm - top (at least 2 cols)
            if (left < right) {
                for (int i = btm - 1; i > top; i--) ans.add(matrix[i][left]);
            }
            // closer
            top++;
            btm--;
            left++;
            right--;
        }
        return ans;
    }
}
