package leetCode200;

public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 一方为空情况
        if (m == 0) {
            if (n % 2 == 0) return ((nums2[n / 2 - 1] + nums2[n / 2]) / 2.0);
            else return nums2[n / 2];
        }
        if (n == 0) {
            if (m % 2 == 0) return ((nums1[m / 2 - 1] + nums1[m / 2]) / 2.0);
            else return nums1[m / 2];
        }

        // 合并递增数组
        int[] nums = new int[m + n];
        int cnt = 0;
        int i = 0, j = 0;
        while (cnt != (m + n)) {
            if (i == m) {
                while (j != n) nums[cnt++] = nums2[j++];
                break;
            }
            if (j == n) {
                while (i != m) nums[cnt++] = nums1[i++];
                break;
            }
            if (nums1[i] < nums2[j]) nums[cnt++] = nums1[i++];
            else nums[cnt++] = nums2[j++];
        }

        // 返回
        if (cnt % 2 == 0) return ((nums[cnt / 2 - 1] + nums[cnt / 2]) / 2.0);
        else return nums[cnt / 2];
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0; // 两个指针

        for (int i = 0; i <= len / 2; i++) {
            left = right; // left记录上一次right值
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                // 选第一个数组值的情况：a数组还没遍历完 并且 （b数组遍历完了，或者 a数组当前值<b数组的值）
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }

        if (len % 2 == 0) {
            // 偶数
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int leftK = (n + m + 1) / 2;
        int rightK = (n + m + 2) / 2;
        // 奇偶合并
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, leftK) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, rightK)) / 2.0;
    }

    // 在两个数组（分别递增）中寻找第k小的数，注意K代表第几个 1开始
    // s指向当前要比较数的下标
    private int getKth(int[] num1, int s1, int e1, int[] num2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;
        // 总是让len1 < len2
        if (len1 > len2) return getKth(num2, s2, e2, num1, s1, e1, k);
        if (len1 == 0) return num2[s2 + k - 1];

        if (k == 1) return Math.min(num1[s1], num2[s2]);

        int i = s1 + Math.min(len1, k / 2) - 1; // 下标 -1
        int j = s2 + Math.min(len2, k / 2) - 1;
        if (num1[i] > num2[j]) {
            // 排除num2中下标到s2到j的数，个数：j - s2 + 1
            return getKth(num1, s1, e1, num2, j + 1, e2, k - (j - s2 + 1));
        } else {
            return getKth(num1, i + 1, e1, num2, s2, e2, k - (i - s1 + 1));
        }
    }


    public double findMedianSortedArrays4(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) return findMedianSortedArrays4(B, A);

        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2, half = (m + n + 1) / 2;
            int j = half - i;

            // i需要增大
            if (j != 0 && i != m && B[j - 1] > A[i]) iMin = i + 1;
                // i需要减小
            else if (i != 0 && j != n && A[i - 1] > B[j]) iMax = i - 1;
                // 切好了，拿结果
            else {
                int maxLeft = 0;
                if (i == 0) maxLeft = B[j - 1];
                else if (j == 0) maxLeft = A[i - 1];
                else maxLeft = Math.max(A[i - 1], B[j - 1]);
                if ((m + n) % 2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = B[j];
                else if (j == n) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);
                return (minRight + maxLeft) / 2.0;
            }
        }
        return 0.0;
    }


}
