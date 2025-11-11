package nowCoder.myBitwise;

public class NumberOf1 {
    // 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf1(int n) {
        // n & (n-1) 会把 n 最低位的 1 清掉。清多少次就有多少个 1。
        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }
}
