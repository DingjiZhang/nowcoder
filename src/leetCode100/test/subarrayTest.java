package leetCode100.test;

import java.util.*;

public class subarrayTest {

    public int subarraySum(int[] nums, int k) {
        if (nums == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         * 维护一个队列，存下标，值递减
         * 1. 队头出范围，弹队头
         * 2.队尾元素小于等于当前元素，都弹掉
         * 3.当前下标入队
         * 4.记录最大值，即队头
         * */
        if (nums == null || nums.length < k) return new int[0];

        Deque<Integer> q = new ArrayDeque();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            q.offerLast(i);
            if (i >= k - 1) {
                ans.add(nums[q.peekFirst()]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) return "";

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (valid == need.size()) {
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }
                char d = s.charAt(l);
                l++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
