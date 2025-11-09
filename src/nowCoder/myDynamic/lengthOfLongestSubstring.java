package nowCoder.myDynamic;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    // 用滑动窗口做：用 start 记录当前无重复子串的左端，i 为右端；用表记录每个字符上一次出现的位置。
    // 当遇到重复字符且其上次位置在窗口内，就把 start 跳到上次位置的右边。每步更新答案长度
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> last = new HashMap<>(); // 字符 -> 上次出现的下标
        int start = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer prev = last.get(c);
            if (prev != null && prev >= start) {// 重复且在窗口内
                start = prev + 1; // 左端跳过重复
            }
            last.put(c, i);
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
