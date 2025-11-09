package nowCoder.myDynamic;

public class maxValue {
    /*
     *这题是经典网格 DP：只能向右或向下走，设
dp[i][j] = 到达 (i,j) 的最大礼物值，则

dp[i][j] = grid[i][j] + max(dp[i-1][j], dp[i][j-1])
边界：第一行只能从左来、第一列只能从上来
     * */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n]; // dp[j]:表示当前行到列j的最大值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[j] = dp[j] + grid[i][j];  // 只能从上面来
                else dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j]; // 上/左 取大
            }
        }
        return dp[n - 1];
    }
}
