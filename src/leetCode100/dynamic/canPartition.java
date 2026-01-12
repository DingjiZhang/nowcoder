package leetCode100.dynamic;

public class canPartition {

    /*
     * 分隔等和子集
     * */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1]; // 表示前i个数能否组成j
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // 初始化第一行，只用一个数nums[0]
        if (nums[0] <= target) dp[0][nums[0]] = true;

        // 填表：从(1, 1)开始
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j < num) {
                    // 只能不选
                    dp[i][j] = dp[i - 1][j];
                } else { // 可以选也可以不选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
            // 剪枝
            if (dp[i][target]) return true;
        }
        return dp[n - 1][target];
    }

    /*
     * 优化空间：注意到i行只与i-1行有关
     * */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1]; // 表示凑成j
        if (nums[0] <= target) dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if (dp[target]) return true;
        }
        return dp[target];
    }
}
