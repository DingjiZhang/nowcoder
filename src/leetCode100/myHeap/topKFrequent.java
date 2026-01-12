package leetCode100.myHeap;

import java.util.*;

public class topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// 元素-频率
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.offer(key);
            }
        }
        return pq.stream().mapToInt(Integer::intValue).toArray();
    }

    // 桶排序
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int f = entry.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(num);
        }

        int[] ans = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] != null) {
                for (int num : buckets[f]) {
                    ans[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return ans;
    }
}
