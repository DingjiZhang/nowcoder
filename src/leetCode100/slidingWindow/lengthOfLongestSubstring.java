package leetCode100.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    // 模板
    public int lengthOfLongestSubstring(String s) {
        // set维护最长不重复子集
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {// 扩展右边界 - 增大
            char c = s.charAt(r);
            // ****先根据set缩小到最小，再增加当前，并记录长度
            while (set.contains(c)) { // 移动左边界 - 缩小
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r)); // 增大
            ans = Math.max(ans, r - l + 1);
        }
        return ans;

    }
}
