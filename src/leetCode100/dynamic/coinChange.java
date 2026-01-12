package leetCode100.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class coinChange {

    // DFS + 剪枝
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount == 0) return 0;

        Arrays.sort(coins);
        reverse(coins);

        dfs(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[] coins, int amount, int cnt) {
        if (amount < 0) return;
        if (amount == 0) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (cnt >= ans) return;

        for (int c : coins) {
            dfs(coins, amount - c, cnt + 1);
        }
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    // 动态规划
    // dp[i] 表示金额i用到的最小coins数
    // 对每个金额i，对每个硬币coin如果i-coin >=0，则dp[i] = min(dp[i], dp[i-coin]+1)
    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount == 0) return 0;

        int max = amount + 1;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, max);
        dp[0] = 0;

        // 对每一个硬币
        for (int coin : coins) {
            // 从coin到amount逐步更新
            for (int i = coin; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
