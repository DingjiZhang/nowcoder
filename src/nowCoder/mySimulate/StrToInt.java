package nowCoder.mySimulate;

public class StrToInt {

    public int StrToInt(String s) {
        if (s == null) return 0;
        int n = s.length(), i = 0;

        // 跳过空格
        while (i < n && s.charAt(i) == ' ') i++;
        if (i == n) return 0;

        int sign = 1;
        char c = s.charAt(i);
        if (c == '+' || c == '-') {
            sign = (c == '-') ? -1 : 1;
            i++;
        }

        int ans = 0;
        boolean hasDigit = false;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break; // 非数字停止
            hasDigit = true;
            int d = ch - '0';

            // 溢出检查
            long limit = (sign == 1) ? Integer.MAX_VALUE : 1L + Integer.MAX_VALUE; // 正数最大值/负数绝对值最大值
            if (ans > (limit - d) / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            ans = ans * 10 + d;
            i++;
        }
        return hasDigit ? sign * ans : 0;
    }

    public static void main(String[] args) {

    }

}
