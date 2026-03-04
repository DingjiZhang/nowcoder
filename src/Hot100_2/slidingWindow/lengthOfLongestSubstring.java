package Hot100_2.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int r = 0, l = 0, winLen = 0;

        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
                winLen--;
            }
            set.add(c);
            r++;
            winLen++;
            max = Math.max(max, winLen);
        }
        return max;
    }

}
