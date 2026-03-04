package leetCode21_40;

public class divide {
    public int divide(int dividend, int divisor) {
        // 1.特判 唯一溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean negative = (dividend ^ divisor) < 0;

        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int ans = 0;
        while (a <= b) {
            int value = b;
            int power = 1;

            while (value >= Integer.MIN_VALUE / 2 && a <= value + value) {
                value += value;
                power += power;
            }

            a -= value;
            ans += power;
        }

        return negative ? -ans : ans;
    }
}
