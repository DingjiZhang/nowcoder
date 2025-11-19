package leetCode100.skill;

public class sortColors {
    public void sortColors(int[] nums) {
        // 双指针，p0 从前 p2 从后
        // 注意 p2交换时，一直交换到nums[i]不为2止
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                int t = nums[i];
                nums[i] = nums[p2];
                nums[p2] = t;
                --p2;
            }
            if (nums[i] == 0) {
                int t = nums[i];
                nums[i] = nums[p0];
                nums[p0] = t;
                ++p0;
            }
        }
    }
}
