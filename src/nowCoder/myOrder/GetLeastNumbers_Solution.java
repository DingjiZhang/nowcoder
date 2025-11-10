package nowCoder.myOrder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) return ans;

        // 最大堆: 堆顶是k个里面最大的
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int x : input) {
            if (pq.size() < k) pq.offer(x);
            else if (x < pq.peek()) {
                pq.poll();
                pq.offer(x);
            }
        }
        ans.addAll(pq);
        Collections.sort(ans);
        return ans;
    }
}
