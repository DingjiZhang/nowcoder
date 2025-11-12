package nowCoder.otherAlgorithm;

public class MoreThanHalfNum {

    /*当 cnt == 0 时，换候选 cand = x, cnt = 1；
遇到与 cand 相同的数 cnt++，不同则 cnt--。
在“保证存在多数元素”的前提下，最后留下的 cand 就是答案
    时间 O(n)，空间 O(1)
    */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        int cand = 0, cnt = 0;
        for (int x : numbers) {
            if (cnt == 0) {
                cand = x;
                cnt = 1;
            } else if (x == cand) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cand;
    }
}
