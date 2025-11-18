package leetCode100.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    // 模板
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {// 扩展右边界
            char c = s.charAt(r);
            while (set.contains(c)) { // 扩展左边界
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
        }
        return ans;

    }
}
