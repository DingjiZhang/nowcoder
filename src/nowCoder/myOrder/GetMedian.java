package nowCoder.myOrder;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {
    /*用双堆解决：左边用最大堆装“较小的一半”，右边用最小堆装“较大的一半”。保持不变式：
	•	left（最大堆）的大小与 right（最小堆）的大小相等或多 1；
	•	left.peek() ≤ right.peek()。
     *
     *	•	若总数为奇数，中位数就是 left.peek()；
	•	若为偶数，中位数是 (left.peek()+right.peek())/2.0。
     * */

    // 最大堆：堆顶是左半部分最大值
    private PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    // 最小堆：堆顶是右半部分最小值
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void Insert(Integer num) {
        // 按大小分堆
        if (left.isEmpty() || num <= left.peek()) left.offer(num);
        else right.offer(num);

        // 重新平衡：left的元素要么等于right 要么多1
        if (left.size() > right.size() + 1) right.offer(left.poll());
        else if (right.size() > left.size()) left.offer(right.poll());
    }

    public Double GetMedian() {
        int n = left.size() + right.size();
        if (n == 0) return 0.0;

        if ((n & 1) == 1) return (double) left.peek();
        else return (left.peek() + right.peek()) / 2.0;
    }
}
