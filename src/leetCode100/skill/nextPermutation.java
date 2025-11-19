package leetCode100.skill;

public class nextPermutation {
    /*
     * 下一个字典序
     * 1.从后往前找第一个逆序对，小数在前，位置i
     * 2.从后往前找第一个大于nums[i]的数，交换
     * 3.翻转i后面的数，[i+1, n)在操作2后是降序的，变成升序（如果整个降序，直接3）
     * */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
