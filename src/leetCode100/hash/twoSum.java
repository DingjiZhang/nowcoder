package leetCode100.hash;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> viMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (viMap.containsKey(target - nums[i])) {
                return new int[]{viMap.get(target - nums[i]), i};
            }
            viMap.put(nums[i], i);
        }
        return new int[0];
    }

}
