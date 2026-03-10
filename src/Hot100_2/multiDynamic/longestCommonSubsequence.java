package Hot100_2.multiDynamic;

import java.util.Scanner;

public class longestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int[][] dp = longestCommonSubsequence(s1, s2);
        String ans = backTrack(dp, s1, s2);

        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(ans);

    }

    private static String backTrack(int[][] dp, String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }

    public static int[][] longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        // dp表示text1的前i个字符 和 text2前j个字符的lcs长度
        // 下标为0的表示空字符串 都为0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 1. 当前字符相等 当前最长lcs就是前i-1和j-1 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 2. 当前字符不相等，取上方和左方的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }
}
