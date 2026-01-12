package leetCode100.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hashTest {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;
        for (int x : set) {
            if (set.contains(x - 1)) continue;

            int curNum = x;
            int curLen = 1;
            while (set.contains(curNum + 1)) {
                curNum++;
                curLen++;
            }
            best = Math.max(best, curLen);
            if (2 * best > set.size()) break;
        }
        return best;
    }

}
