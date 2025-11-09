package nowCoder.myDynamic;

public class NumToStr {
    /*
    * 设 dp[i] 为前 i 个字符的解码数（dp[0]=1 空前缀）。
转移到第 i 位（下标 i-1）：
	•	若 s[i-1] != '0'：可把它单独解码 ⇒ dp[i] += dp[i-1]
	•	若 10 <= value(s[i-2..i-1]) <= 26：可把两位一起解码 ⇒ dp[i] += dp[i-2]

用两个滚动变量即可。
    * */
    // 12310
    public int solve(String nums) {
        if (nums == null || nums.length() == 0) return 0;
        // 首尾0，无法解码
        if (nums.charAt(0) == '0') return 0;

        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1], 首位非0，即为1种

        for (int i = 1; i < nums.length(); i++) {
            int cur = 0; // 当前位的解码数

            char c = nums.charAt(i);
            char p = nums.charAt(i - 1);

            // 单独解码当前位
            if (c != '0') cur += prev1;
            // 解码两位
            int two = (p - '0') * 10 + (c - '0');
            if (two >= 10 && two <= 26) cur += prev2;

            if (cur == 0) return 0;

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;

    }
}
