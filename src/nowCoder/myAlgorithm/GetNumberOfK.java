package nowCoder.myAlgorithm;

import java.util.function.IntPredicate;

public class GetNumberOfK {
    // num 非降序
    // 二分法 找[l, r)
    public int GetNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int lb = lowerBound(nums, k); // 第一个 >= k
        if (lb == nums.length || nums[lb] != k) return 0;
        int ub = upperBound(nums, k); // 第一个 > k
        return ub - lb;
    }

    // 返回第一个 >= target 的下标（若不存在，返回 nums.length）
    private int lowerBound(int[] a, int k) {
        int l = 0, r = a.length; // [l, r)
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= k) r = m;
            else l = m + 1;
        }
        return l;
    }

    // 返回第一个 > target 的下标
    private int upperBound(int[] a, int k) {
        int l = 0, r = a.length; // [l, r)
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > k) r = m;
            else l = m + 1;
        }
        return l;
    }


    /*----   ----*/
    public int GetNumberOfK2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int lb = firstTrue(nums.length, i -> nums[i] >= k); // 第一个 >= k
        if (lb == nums.length || nums[lb] != k) return 0;
        int ub = firstTrue(nums.length, i -> nums[i] > k); // 第一个 > k
        return ub - lb;
    }

    private int firstTrue(int n, IntPredicate ok) {
        int l = 0, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (ok.test(m)) r = m;
            else l = m + 1;
        }
        return l;
    }
}

