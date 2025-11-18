package leetCode100.slidingWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAnagrams {
    // 找到s中所有p的排列，返回所有起始索引
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) return new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (Character c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int valid = 0; //表示wiondow中满足need的字符个数
        List<Integer> ans = new ArrayList<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            // 窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (r - l >= p.length()) {
                // 这里做答案操作
                // 当窗口符合条件时，起始索引加入
                if (valid == need.size()) ans.add(l);
                // 缩左侧
                char d = s.charAt(l);
                l++;
                // 窗口内数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return ans;
    }

}
