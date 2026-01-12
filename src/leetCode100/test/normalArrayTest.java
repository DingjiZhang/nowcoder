package leetCode100.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class normalArrayTest {
    //!!
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int cur = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            best = Math.max(best, cur);
        }
        return best;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];

        List<int[]> ans = new ArrayList<>();
        // !!!
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0], ne = intervals[i][1];
            if (ns > e) {
                ans.add(new int[]{s, e});
                s = ns;
                e = ne;
            } else { // 合并
                // !!!!
                e = Math.max(e, ne);
            }
        }
        ans.add(new int[]{s, e});
        return ans.toArray(new int[ans.size()][]);
    }


    public void rotate(int[] nums, int k) {
        // 翻转3次
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }


    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] B = new int[n];
        B[0] = 1;
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= suffix;
            suffix *= nums[i];
        }
        return B;
    }

    public int firstMissingPositive(int[] nums) {
        // num[i] 的 家 在下标 num[i] - 1
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                // swap
                int idx = nums[i] - 1;
                int t = nums[i];
                nums[i] = nums[idx];
                nums[idx] = t;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}
