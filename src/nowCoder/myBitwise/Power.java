package nowCoder.myBitwise;

public class Power {

    public double Power(double base, int exponent) {
        // 特判：0 的非正次幂无意义；题目保证不同时为 0，这里给个稳妥返回
        if (base == 0.0) {
            return (exponent > 0) ? 0.0 : 0.0; // 常见题解会返回 0
        }
        if (exponent == 0) return 1.0;

        double x = base;
        long e = exponent;                    // 用 long 防止 -2^31 溢出
        if (e < 0) {                          // 负指数：取倒数
            x = 1.0 / x;
            e = -e;
        }

        double ans = 1.0;
        while (e > 0) {
            if ((e & 1L) == 1L) ans *= x;   // 当前二进制位为 1，就把 x 乘进答案
            x *= x;                           // 底数平方：对应二进制进一位
            e >>= 1;                          // 指数右移一位
        }
        return ans;
    }
}
