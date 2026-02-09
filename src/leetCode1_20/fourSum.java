package leetCode1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int L = j + 1, R = n - 1;
                while (L < R) {
                    if (L > j + 1 && nums[L] == nums[L - 1]) {
                        L++;
                        continue;
                    }
                    if (R < n - 1 && nums[R] == nums[R + 1]) {
                        R--;
                        continue;
                    }

                    long sum = (long) nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum > target) R--;
                    else if (sum < target) L++;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        L++;
                        R--;
                    }
                }
            }
        }
        return ans;
    }
}
