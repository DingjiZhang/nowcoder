package Hot100_2.multiDynamic;

public class minDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // 表示word1前i个字符 转成word2 前j个字符所需操作数；竖着是word1 横着是word2
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化，横着看，word1转word2是插入
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // 初始化，竖着看，是删除
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 相同
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不同，取上左上，左的最小值 +1，表示三种不同操作
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
