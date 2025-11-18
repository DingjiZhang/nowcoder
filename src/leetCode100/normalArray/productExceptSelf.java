package leetCode100.normalArray;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] B = new int[n];

        // 向右乘前积
        B[0] = 1;
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] * nums[i - 1];
        }

        // 向左乘后积
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= suffix;
            suffix *= nums[i];
        }
        return B;
    }
}
