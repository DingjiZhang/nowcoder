package leetCode100.doublePointer;

public class trap {

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        // 左右指针
        int left = 0, right = n - 1;
        // 左指针左边的最大高度，右指针右边的最大高度
        int leftMax = height[left], rightMax = height[right];
        // 左右端存不了水
        left++;
        right--;
        // 中间靠拢
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                // 左边最大小于右边最大
                // 当前列靠左边的最大高度决定能储多少水
                // 当前要考虑的列是left位置
                // 当前列的储水量=leftMax - 当前列高度
                res += leftMax - height[left];
                left++;
            } else {
                // 右边
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
