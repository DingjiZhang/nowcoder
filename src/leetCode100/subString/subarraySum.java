package leetCode100.subString;

import java.util.HashMap;
import java.util.Map;

public class subarraySum {

    // 返回 nums 中 和为k的子数组个数
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 前缀和 - 出现的次数
        map.put(0, 1); // 开头的前缀和就是0
        int preSum = 0;

        for (int x : nums) {
            preSum += x;
            // 搜索map中目标所要前缀和个数
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k); // 获取次数
            }
            // 更新 放入当前的前缀和
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
