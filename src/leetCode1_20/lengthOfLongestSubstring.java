package leetCode1_20;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int ans = 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
