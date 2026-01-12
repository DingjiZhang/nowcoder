package leetCode100.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class doublePointerTest {

    public void moveZeroes(int[] nums) {
        if (nums == null) return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        for (int i = j; i < nums.length; i++) nums[i] = 0;
    }


    public int maxArea(int[] height) {
        if (height == null) return 0;

        int i = 0, j = height.length - 1, ans = 0;
        while (i < j) {
            ans = height[i] < height[j] ?
                    Math.max(ans, (j - i) * height[i++]) :
                    Math.max(ans, (j - i) * height[j--]);
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }

    public int trap(int[] height) {
        if (height == null) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int ans = 0;

        left++;
        right--;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
