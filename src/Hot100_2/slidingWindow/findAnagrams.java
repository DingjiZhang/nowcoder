package Hot100_2.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;

        int[] pCharCount = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCharCount[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        int left = 0, right = p.length() - 1;
        while (right < s.length()) {
            if (Arrays.equals(pCharCount, windowCount)) ans.add(left);

            windowCount[s.charAt(left) - 'a']--;
            left++;
            right++;
            if (right < s.length()) {
                windowCount[s.charAt(right) - 'a']++;
            }
        }
        return ans;
    }

}
