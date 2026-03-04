package Hot100_2.hash;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // num,i
        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];
            if (map.containsKey(needValue)) {
                return new int[]{map.get(needValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
