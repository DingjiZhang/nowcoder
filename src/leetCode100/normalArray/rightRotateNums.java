package leetCode100.normalArray;

public class rightRotateNums {

    // 向右移动k个数，意味着右边k个数到头
    // 翻转所有，尾部的k个数就到头了
    // 翻转前k个，翻转剩下的
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
