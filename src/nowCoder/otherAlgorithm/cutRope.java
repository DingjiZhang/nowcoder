package nowCoder.otherAlgorithm;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class cutRope {

    // 每段尽量切成3
    // 不要留下1； 1*3<2*2
    public int cutRope(int n) {
        // 必须切成至少两段
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        long res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        // 此时 n ∈ {2,3,4}：直接乘。n=4 等价 2*2
        res *= n;
        return (int) res;
    }

    // 进阶 空间O(1) 时间O(logn) 快速幂
    private static final long MOD = 998244353L;

    private long powMod(long a, long e, long mod) {
        long res = 1 % mod;  // 初值设为 1 的同余类；若 mod==1 则为 0，避免最后返回 1 的错误
        a %= mod;            // 先把底数缩到 [0, mod) 内，防止无谓的大数运算
        while (e > 0) {      // 处理指数 e 的二进制位，从低位到高位
            if ((e & 1) == 1)            // 若当前最低位为 1
                res = (res * a) % mod;   // 把当前 base 乘进答案
            a = (a * a) % mod;           // base 自身平方：1→2→4→8…次方
            e >>= 1;                     // 指数右移一位，相当于丢掉刚处理过的最低位
        }
        return res;          // 循环结束时 res 即 a^e % mod
    }

    public long cutRope2(long number) {
        if (number == 2) return 1;
        if (number == 3) return 2;

        long k = number / 3;
        long r = number % 3;

        if (r == 0) {
            return powMod(3, k, MOD);
        } else if (r == 1) {
            // 用 4 代替 3+1
            return (powMod(3, k - 1, MOD) * 4) % MOD;
        } else { // r == 2
            return (powMod(3, k, MOD) * 2) % MOD;
        }
    }

}
