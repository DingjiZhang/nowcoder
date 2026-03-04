package Hot100_2.hash;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 1;
        for (Integer num : set) {
            int len = 1;
            if (set.contains(num - 1)) continue;

            while (set.contains(num + 1)) {
                len++;
                maxLen = Math.max(maxLen, len);
                num++;
            }
        }
        return maxLen;
    }
}
