package Hot100_2.doublePointers;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0; // 指向非0末尾
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        for (int i = slow; i < len; i++) nums[i] = 0;
    }
}
