package nowCoder.myDynamic;

public class jumpFloor {
    /*这题就是斐波那契（Fibonacci）模型：

设 dp[n] 为跳上 n 级台阶的方法数。最后一步要么跳 1 级、要么跳 2 级，所以
dp[n] = dp[n-1] + dp[n-2]，且 dp[1]=1，dp[2]=2。
因此答案是第 n 个（以 1 开始计）“斐波那契但起始为 1,2”的数，等价于标准 Fibonacci 的 F_{n+1}*/
    public int jumpFloor(int number) {
        if (number <= 2) return number;
        int a = 1, b = 2; // dp[1]=1, dp[2]=2
        for (int i = 3; i <= number; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    // 求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
    /*
    * 设 f(n) 为到第 n 级的方法数，则
	•	f(1)=1；
	•	对 n≥2：第一次跳 k(1≤k≤n) 级后还剩 n−k 级，所以
f(n)=f(n−1)+f(n−2)+…+f(1)+f(0)，其中 f(0)=1。
而 f(n−1)=f(n−2)+…+f(1)+f(0)，所以 f(n)=2·f(n−1) ⇒ f(n)=2^(n−1)。
    * */
    public int jumpFloorII(int number) {
        if (number <= 0) return 0;
        return 1 << (number - 1);
    }
}
