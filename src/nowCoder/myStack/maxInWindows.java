package nowCoder.myStack;

import java.util.*;

public class maxInWindows {
    /* 维护一个存下标的队列，使其下标对应的num是递减的 -> 那么每次窗口的最大值就是 peekFirst()
     * 遍历 i
     * 弹队头：出了窗口的下标，弹掉 （小标 <= i - size）
     * 弹队尾：队尾 <= 当前值的 都弹掉
     * 压入当前下标
     * 有了完整窗口就记录头
     * */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length)
            return ans;

        Deque<Integer> dq = new ArrayDeque<>(); // 存下标，值单调递减
        for (int i = 0; i < num.length; i++) {
            // 1) 过期：队头出了窗口就弹掉
            while (!dq.isEmpty() && dq.peekFirst() <= i - size) dq.pollFirst();

            // 2) 维护递减：把队尾 ≤ 当前值的都弹掉
            while (!dq.isEmpty() && num[dq.peekLast()] <= num[i]) dq.pollLast();

            // 3) 压入当前下标
            dq.offerLast(i);

            // 4) 形成完整窗口后，队头就是最大值
            if (i >= size - 1)
                ans.add(num[dq.peekFirst()]);
        }
        return ans;
    }

    public static void main(String[] args) {
        maxInWindows solution = new maxInWindows();
        int[] nums = {3, 1, 1, 3};
        int size = 3;
        ArrayList<Integer> result = solution.maxInWindows(nums, size);
        System.out.println(result); // Expected output: [4, 4, 6, 6, 5]
    }
}
