package leetCode100.subString;

import java.util.*;

public class maxSlidingWindow {
    /*
     * 维护一个队列，存数组下标，值递减，对头就是最大值
     * 1. 队头出了范围弹掉
     * 2. 队尾的值<= 当前值，弹掉
     * 3. 压入当前下标
     * 4. 满足了当前窗口大小，记录队头
     * */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) return new int[0];

        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 1.
            while (!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();
            // 2.
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            // 3.
            q.offerLast(i);
            // 4.
            if (i >= k - 1) {
                ans.add(nums[q.peekFirst()]);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        maxSlidingWindow solution = new maxSlidingWindow();
        int[] nums = {3, 1, 1, 3};
        int size = 3;
        int[] result = solution.maxSlidingWindow(nums, size);
        System.out.println(result);
    }

}
