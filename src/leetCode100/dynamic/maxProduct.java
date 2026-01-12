package leetCode100.dynamic;

public class maxProduct {

    /*
     * 子数组最大乘积
     * 维护：
     * 1. 当前最大值imax = Max(imax * nums[i], nums[i])
     * 2. 当前最小值imin = Min(imin * nums[i], nums[i])
     * 3. 最大值 max = Max(max, imax)
     * 4. 如果num[i]是负数，交换imax与imin
     * */
    public int maxProduct(int[] nums) {
        int imax = 1, imin = 1, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int t = imax;
                imax = imin;
                imin = t;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(imax, max);
        }
        return max;
    }
}
