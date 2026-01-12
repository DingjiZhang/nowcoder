package leetCode100.dynamic;

import java.util.List;

public class wordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len + 1]; // 表示前i位已匹配
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (!dp[i]) continue;

            for (String word : wordDict) {
                if (i + word.length() <= len && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[len];
    }

}
