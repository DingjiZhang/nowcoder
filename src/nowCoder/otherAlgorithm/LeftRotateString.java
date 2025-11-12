package nowCoder.otherAlgorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LeftRotateString {

    // 这题就是把字符串左移 n 位（循环）。最简单做法：切两段拼起来。
    public String LeftRotateString1(String str, int n) {
        if (str == null || str.isEmpty()) return "";
        int len = str.length();
        n %= len;
        if (n == 0) return str;
        return str.substring(n) + str.substring(0, n);
    }


    public String LeftRotateString2(String str, int n) {
        if (str == null || str.isEmpty()) return "";

        int len = str.length();
        int k = n % len;
        if (k == 0) return str;

        Deque<Character> dq = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) dq.addLast(str.charAt(i));
        for (int i = 0; i < k; i++) dq.addLast(dq.removeFirst());

        StringBuilder sb = new StringBuilder(len);
        for (char c : dq) sb.append(c);
        return sb.toString();
    }
}
