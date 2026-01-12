package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens {

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] colPos = new int[n];
        boolean[] isChoosenCol = new boolean[n]; // 默认false，true表示c列被选
        boolean[] r_diag = new boolean[2 * n - 1];
        boolean[] l_diag = new boolean[2 * n - 1];
        dfs(0, n, colPos, isChoosenCol, r_diag, l_diag);
        return ans;
    }

    // r代表i 相当于行的下标
    private void dfs(int r, int n, int[] colPos, boolean[] isChoosenCol, boolean[] rDiag, boolean[] lDiag) {
        if (r == n) {
            // 生成棋盘
            List<String> board = new ArrayList<>();
            for (int c : colPos) {
                char[] str = new char[n];
                for (int i = 0; i < n; i++) {
                    str[i] = (i == c) ? 'Q' : '.';
                }
                board.add(new String(str));
            }
            ans.add(board);
        }

        for (int c = 0; c < n; c++) {
            // 1.列是否被选过，2. 对角线
            if (!isChoosenCol[c] && !rDiag[r + c] && !lDiag[r - c + n - 1]) {
                colPos[r] = c;

                isChoosenCol[c] = rDiag[r + c] = lDiag[r - c + n - 1] = true;
                dfs(r + 1, n, colPos, isChoosenCol, rDiag, lDiag);
                isChoosenCol[c] = rDiag[r + c] = lDiag[r - c + n - 1] = false;
            }
        }
    }
}
