package leetCode100.backTracking;

public class exist {

    /*
     * 图+回溯
     * */
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;

        char[] words = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, words, r, c, 0)) return true;
            }
        }
        return false;
    }

    private final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private boolean dfs(char[][] board, char[] words, int r, int c, int index) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != words[index]) {
            return false;
        }

        if (index == words.length - 1) return true;
        board[r][c] = '\0';
        for (int[] d : DIRS) {
            if (dfs(board, words, r + d[0], c + d[1], index + 1)) {
                board[r][c] = words[index]; // 成功时恢复
                return true;
            }
        }
        board[r][c] = words[index]; // 失败时也恢复
        return false;
    }
}
