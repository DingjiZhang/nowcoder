package Baidu.yf251019;

import java.util.*;

public class duanban {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] ans = new int[n];

        // 枚举组的大小 len
        for (int len = 1; len <= n; len++) {
            int best = 0;
            // 枚举所有长度为len的连续区间[l,r]
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;

                // 求该区间最小值
                int mn = Integer.MAX_VALUE;
                for (int i = l; i <= r; i++) {
                    mn = Math.min(mn, a[i]);
                }

                // 维护“len长度的最大最小值”
                best = Math.max(best, mn);
            }
            ans[len - 1] = best;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    // 优化1 滑动窗口求最小值：单调队列
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] ans = new int[n];

        for (int len = 1; len <= n; len++) {
            Deque<Integer> deque = new ArrayDeque<>();
            int best = 0;

            for (int i = 0; i < n; i++) {
                // 维护单调递增队列，队首是最小值下标,弹出队尾大的值
                while (!deque.isEmpty() && a[deque.peekLast()] >= a[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                // 移出窗口外元素
                while (!deque.isEmpty() && deque.peekFirst() <= i - len) {
                    deque.pollFirst();
                }
                // 窗口形成
                if (i >= len - 1) {
                    int windMin = a[deque.peekFirst()];
                    best = Math.max(best, windMin);
                }
            }
            ans[len - 1] = best;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
