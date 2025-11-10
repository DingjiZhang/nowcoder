package nowCoder.myTrackback;

public class hasPath {
    // (1) 状态 dfs(i,j,k)；(2) 两个基例；(3) 标记→四向扩展→回溯；(4) 外层枚举起点。
    public boolean hasPath(char[][] matrix, String word) {
        if (word == null || word.isEmpty()) return true;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] w = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(matrix, w, i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    // 表示在矩阵中，从(i,j)位置开始，寻找word中第k个字符及其后续是否全部能匹配成功
    private boolean dfs(char[][] a, char[] w, int i, int j, int k, boolean[][] vis) {
        if (a[i][j] != w[k]) return false; // 不匹配，失败
        if (k == w.length - 1) return true; // 最后一位都匹配上了，成功

        vis[i][j] = true; // 占用当前格
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 四个方向
        for (int[] d : dir) {
            int ni = i + d[0], nj = j + d[1];
            // 在矩阵中，且新位置未被访问过
            if (ni >= 0 && ni < a.length && nj >= 0 && nj < a[0].length && !vis[ni][nj]) {
                if (dfs(a, w, ni, nj, k + 1, vis)) { // 往下匹配一位成功了
                    vis[i][j] = false; // 下一位已经成功了，所以当前位置可以被释放了
                    return true;
                }
            }
        }
        vis[i][j] = false; //离开之前释放 回溯，撤销占用
        return false;
    }

}
