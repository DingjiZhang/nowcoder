package leetCode100.normalArray;

public class firstMissingPositive {
    /*
     * 原地哈希，使数num[i]在num[i]-1位置， 即1应该在索引0上 [1,n]都如此
     * 不在就while交换，最后遍历找第一个不对的位置 num[i] != i+1
     * 答案就是i+1
     * */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int len = nums.length;
        // [1,n] swap下标(i, num[i] - 1)
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int idx = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
            }
        }

        // 第一个位置不匹配
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}
