package Hot100Key;

import java.util.Random;

public class searchInsert35 {
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums, target);
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 循环不变量 L-1 始终 <, R+1 始终 >=
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return left; // R+1
    }
}
