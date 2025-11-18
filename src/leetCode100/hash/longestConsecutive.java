package leetCode100.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) { // 只从起点开始
                int curNum = x;
                int curLen = 1;
                while (set.contains(curNum + 1)) { // 扩展到断点
                    curNum++;
                    curLen++;
                }
                best = Math.max(best, curLen);
            }
        }
        return best;
    }

    //把“连续段长度”记录在段两端点上，遇到新数时与左右段合并：
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> len = new HashMap<>();
        int best = 0;
        for (int x : nums) {
            if (len.containsKey(x)) continue; // 忽略重复
            int L = len.getOrDefault(x - 1, 0);
            int R = len.getOrDefault(x + 1, 0);
            int curLen = L + 1 + R;
            len.put(x, curLen);
            // 更新两个端点
            len.put(x - L, curLen);
            len.put(x + R, curLen);
            best = Math.max(best, curLen);
        }
        return best;
    }
}
