package leetCode100.myHeap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保留较大一半，最多多一个
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆：保留较小一半
    }

    public void addNum(int num) {
        if (A.size() == B.size()) { // 相等的时候，最终需要向A添加元素
            B.add(num);
            A.add(B.poll());
        } else {
            A.add(num);
            B.add(A.poll());
        }

    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
