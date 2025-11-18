package leetCode100.normalArray;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int cur = nums[0];  // 局部：以当前下标为结尾的最大和
        int best = nums[0]; // 全局：所有cur的最大

        for (int i = 1; i < nums.length; i++) {
            // 继续累加更大 还是重新开始更大
            cur = Math.max(nums[i], cur + nums[i]);
            best = Math.max(best, cur);
        }
        return best;
    }
}
