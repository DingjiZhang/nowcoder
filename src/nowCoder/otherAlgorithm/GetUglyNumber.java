package nowCoder.otherAlgorithm;

public class GetUglyNumber {

    /*
    * 丑数的经典解法：三指针动态规划。
维护指针 p2,p3,p5，分别指向当前要乘 2、3、5 的位置；每次取 min(2*dp[p2], 3*dp[p3], 5*dp[p5]) 作为下一个丑数，
* 等于哪个就把相应指针往前挪（可能多个同时相等，去重）。
    * */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;

        int[] dp = new int[index];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < index; i++) {
            long a = dp[p2] * 2L;
            long b = dp[p3] * 3L;
            long c = dp[p5] * 5L;
            long next = Math.min(a, Math.min(b, c));
            dp[i] = (int) next;

            if (next == a) p2++;
            if (next == b) p3++;
            if (next == c) p5++; // 可能多个相等，需要都前进
        }
        return dp[index - 1];
    }
}
