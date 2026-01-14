package leetCode1_20;

public class isMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        // 初始化
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pj = p.charAt(j - 1); // 当前模式位置

                if (pj != '*') {
                    if (matches(s.charAt(i - 1), pj)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    // 0次，跳过 X*
                    dp[i][j] = dp[i][j - 2];

                    // >= 1次，若 s[i-1] 能和 x=p[j-2] 匹配，则看 dp[i-1][j]
                    char x = p.charAt(j - 2);
                    if (matches(s.charAt(i - 1), x))
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(char sc, char pc) {
        return pc == '.' || sc == pc;
    }
}
