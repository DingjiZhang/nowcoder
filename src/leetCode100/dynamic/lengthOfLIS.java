package leetCode100.dynamic;

public class lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // tails[i]：长度为 i+1 的递增子序列中，最小的结尾元素
        int[] tails = new int[n];
        // 当前已经维护的最长递增子序列长度
        int size = 0;

        for (int x : nums) {
            // 在 tails[0..size-1] 中二分查找
            // 找到“第一个 >= x 的位置” l
            int l = 0, r = size;
            while (l < r) {
                int mid = (l + r) / 2;
                if (tails[mid] < x) l = mid + 1;
                else r = mid;
            }
            // 循环结束时，l 是第一个 >= x 的位置（或等于 size）
            // 1）如果存在 tails[l] >= x：用 x 替换 tails[l]，让这个长度的结尾更小
            // 2）如果 l == size：说明 x 比所有 tails 都大，可以扩展一个新的长度
            tails[l] = x;
            if (l == size) size++;
        }
        return size;
    }
}
