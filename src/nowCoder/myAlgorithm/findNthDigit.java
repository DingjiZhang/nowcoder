package nowCoder.myAlgorithm;

public class findNthDigit {

    // Digit: 123456789101112...
    public int findNthDigit(int n) {
        // 0 ~ 9 直接返回
        if (n <= 9) return n;

        // 先减掉一位数段的 10 位 (0..9)
        n -= 10;

        long digits = 2;
        long start = 10;
        long count = 9 * start;

        // 不断跨过整段，直到n落到当前
        while (n >= digits * count) {
            n -= digits * count;
            digits++;
            start *= 10;
            count = 9 * start;
        }

        // 落在本段
        long index = n / digits;
        int offset = (int) (n % digits);

        long num = start + index;
        String s = Long.toString(num);
        return s.charAt(offset) - '0';
    }
}
