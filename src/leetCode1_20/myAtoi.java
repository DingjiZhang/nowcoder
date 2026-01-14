package leetCode1_20;

public class myAtoi {
    public int myAtoi(String s) {
        int res = 0, bundry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = s.length();

        if (length == 0) return 0;
        while (s.charAt(i) == ' ') if (++i == length) return 0;

        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;

        for (int j = i; j < length; j++) {
            if (s.charAt(j) < '0' || s.charAt(j) > '9') break;
            if (res > bundry || res == bundry && s.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(j) - '0');
        }
        return sign * res;
    }
}
