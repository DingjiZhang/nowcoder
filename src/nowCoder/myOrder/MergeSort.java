package nowCoder.myOrder;

public class MergeSort {

    public static void sort(int[] a) {
        int[] tmp = new int[a.length];      // 只申请一次临时数组，反复复用
        ms(a, tmp, 0, a.length - 1);        // 排序整个区间 [0..n-1]
    }

    // 对 a[l..r] 做归并排序
    private static void ms(int[] a, int[] tmp, int l, int r) {
        if (l >= r) return;                  // 基例：长度 ≤1 的区间天然有序
        int m = l + (r - l) / 2;             // 中点；写法防止 l+r 溢出

        ms(a, tmp, l, m);                    // 递归排左半段 [l..m]
        ms(a, tmp, m + 1, r);                // 递归排右半段 [m+1..r]

        // 小优化：若两段本就有序可跳过合并
        if (a[m] <= a[m + 1]) return;

        merge(a, tmp, l, m, r);              // 把两个有序段线性归并为一个有序段
    }

    // 把 a[l..m] 与 a[m+1..r] 两个有序段合成一个有序段写回 a[l..r]
    private static void merge(int[] a, int[] tmp, int l, int m, int r) {
        int i = l, j = m + 1, k = l;         // i 指左段，j 指右段，k 写入 tmp 的位置

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) tmp[k++] = a[i++]; // <= 保证“稳定”（相等时先拿左边）
            else tmp[k++] = a[j++];
        }
        while (i <= m) tmp[k++] = a[i++];    // 左段剩余直接拷贝
        while (j <= r) tmp[k++] = a[j++];    // 右段剩余直接拷贝

        System.arraycopy(tmp, l, a, l, r - l + 1); // 把归并结果写回原数组
    }
}
