package leetCode100.dynamic;

public class rob {
    /*
     * 1. 子问题
     * 2. 递推
     * 3. 计算顺序
     * 4. 空间优化（optional）
     *
     * f(k): 偷k间最大利润
     * f(0) = 0
     * f(1) = nums[0]
     * f(k) = max{f(k-1), f(k-2) + nums[k-1]}
     * */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= n; k++) {
            dp[k] = Math.max(dp[k - 1], nums[k - 1] + dp[k - 2]);
        }
        return dp[n];
    }

    public int rob2(int[] nums) {
        int prev = 0;
        int curr = 0;
        // 每次循环
        for (int h : nums) {
            // 循环开始，curr表示dp[k-1], prev表示dp[k-2]
            // dp[k] = ..
            int temp = Math.max(curr, h + prev);
            prev = curr;
            curr = temp;
            // 循环结束，curr表示dp[k], prev表示dp[k-1]
        }
        return curr;
    }
}
