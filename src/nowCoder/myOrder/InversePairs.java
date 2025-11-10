package nowCoder.myOrder;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class InversePairs {
    private static final long MOD = 1_000_000_7L;

    public int InversePairs(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int n = nums.length;
        int[] temp = new int[n];
        long ans = mergeSortCount(nums, temp, 0, n - 1);
        return (int) (ans % MOD);
    }

    private long mergeSortCount(int[] a, int[] temp, int l, int r) {
        if (l > r) return 0;
        int m = l + (r - l) / 2;
        long cnt = 0;
        cnt += mergeSortCount(a, temp, l, m);
        cnt += mergeSortCount(a, temp, m + 1, l);
        cnt %= MOD;

        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                cnt += (m - i + 1);
                if (cnt >= MOD) cnt %= MOD;
            }
        }
        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        
    }
}
