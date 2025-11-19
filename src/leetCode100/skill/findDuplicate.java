package leetCode100.skill;

public class findDuplicate {

    /*
     * 位运算解法
     *  对于只出现一次数的每一个bit来说，因为正常数在nums和【1..n】的个数是一样的，所有正常的每一个bit上1出现的个数是相等的
     * 1. 遍历每一个bits位（int 32位）
     * 2.统计 nums中这一位是1的数量
     * 3.统计 【1..n】中这一位是1的数量
     * 4.数量相等则这一位为0，nums中多则这一位1，拼起来就是重复的数
     * */
    public int findDuplicateBits(int[] nums) {
        int n = nums.length - 1;
        int ans = 0;

        // 对int的每一位做统计
        for (int bit = 0; bit < 32; bit++) {
            int mask = 1 << bit;

            int cntNums = 0, cntRange = 0;
            // 统计nums中这一位是1的个数
            for (int x : nums) {
                if ((x & mask) != 0) cntNums++;
            }

            // 统计【1..n】中这一位是1的数量
            for (int i = 1; i <= n; i++) {
                if ((i & mask) != 0) cntRange++;
            }
            // 如果nums中1的数量比range多，说明重复数这一位是1
            if (cntNums > cntRange) {
                ans |= mask; // 把该位设为1
            }
        }
        return ans;
    }

    // 环形链表法
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            // 1st meet
            if (slow == fast) break;
        }
        fast = 0;
        // 2nd meet
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
