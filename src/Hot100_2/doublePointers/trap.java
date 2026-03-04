package Hot100_2.doublePointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int ans = 0;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        left++;
        right--;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    // 栈
    public int trap2(int[] height) {
        Deque<Integer> st = new ArrayDeque<>();// 存下标
        int ans = 0;
        // 遍历
        for (int right = 0; right < height.length; right++) {
            // 当right是右墙,结算所有凹槽
            while (!st.isEmpty() && height[right] > height[st.peek()]) {
                int btm = st.pop();

                if (st.isEmpty()) break;

                int left = st.peek();

                int width = right - left - 1;
                int h = Math.min(height[right], height[left]) - height[btm];
                if (h > 0) ans += width * h;
            }
            st.push(right);
        }
        return ans;
    }

}
