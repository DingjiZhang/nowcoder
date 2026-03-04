package leetCode21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int n = s.length();
        int k = words.length;
        int L = words[0].length();
        int totalLen = k * L;
        if (n < totalLen) return res;

        // need
        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.put(w, need.getOrDefault(w, 0) + 1);

        // Loop
        for (int offset = 0; offset < L; offset++) {
            int left = offset;
            int cnt = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + L <= n; right += L) {
                String w = s.substring(right, right + L);

                if (!need.containsKey(w)) {
                    // reset window
                    window.clear();
                    cnt = 0;
                    left = right + L;
                    continue;
                }

                // add w
                window.put(w, window.getOrDefault(w, 0) + 1);
                cnt++;

                // shrink
                while (window.get(w) > need.get(w)) {
                    String leftWord = s.substring(left, left + L);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += L;
                    cnt--;
                }

                if (cnt == k) {
                    res.add(left);

                    String leftWord = s.substring(left, left + L);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += L;
                    cnt--;
                }
            }
        }
        return res;
    }
}
