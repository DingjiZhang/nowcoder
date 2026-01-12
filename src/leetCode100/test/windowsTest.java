package leetCode100.test;

import java.util.*;

public class windowsTest {

    // 找到s中所有p的排列，返回所有起始索引
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) return new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char[] arr = p.toCharArray();
        for (char c : arr) need.put(c, need.getOrDefault(c, 0) + 1);

        int l = 0, r = 0;
        int valid = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }

            // l++
            while (r - l >= p.length()) {
                if (valid == need.size()) ans.add(l);
                char d = s.charAt(l);
                l++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ans;
    }


    // 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int ans = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
