package leetCode100.doublePointer;

public class moveZeros {
    public void moveZeroes(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int x = nums[l];
            if (x == 0) {
                while (l < r) {
                    nums[l] = nums[++l];
                }
                nums[l--] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null) return;

        int j = 0;
        // 遍历非0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        // 剩下的都是0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
