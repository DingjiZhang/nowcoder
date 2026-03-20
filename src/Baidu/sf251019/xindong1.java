package Baidu.sf251019;

import java.util.Scanner;

public class xindong1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n];
        long mn = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            mn = Math.min(a[i], mn);
        }

        long ans = 0;
        long limit = 2 * mn;

        for (int i = 0; i < n; i++) {
            ans += (a[i] - 1) / limit;
            /* 原始：把数a分成k段，每段不超过limit，K >= ceil(a/limit):
            k = (a[i] + limit - 1) / limit;
            ans += k - 1;
             */
        }

        System.out.println(ans);
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] == target) {
                return mid; // 找到目标值，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
            }
        }
        return -1; // 未找到目标值
    }
}
