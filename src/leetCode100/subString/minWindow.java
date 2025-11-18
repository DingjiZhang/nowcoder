package leetCode100.subString;

import java.util.HashMap;
import java.util.Map;

public class minWindow {

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) return "";

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引，长度
        int start = 0, len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            // 更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左窗口收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }
                // d 要移出的字符
                char d = s.charAt(l);
                l++;
                // 更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
