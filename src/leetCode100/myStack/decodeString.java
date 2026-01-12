package leetCode100.myStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class decodeString {

    public String decodeString(String s) {
        Deque<Integer> stack_num = new ArrayDeque<>(); // 存字符串中数字
        Deque<String> stack_res = new ArrayDeque<>(); // 存带重复字符串
        StringBuilder res = new StringBuilder();
        int num = 0; //

        for (Character x : s.toCharArray()) {
            if (x == '[') {
                stack_num.push(num); // 括号前的数字压栈
                stack_res.push(res.toString()); // 括号前的字母压栈
                num = 0; // 重复数字归零
                res = new StringBuilder();// res 重置
            } else if (x == ']') {
                int cur_num = stack_num.pop(); // 出栈当前重复数字
                String last_res = stack_res.pop(); // 紧贴这一组括号外，还没有重复的字符串（要重复的在res里）
                StringBuilder cur_res = new StringBuilder();
                for (int i = 0; i < cur_num; i++) {
                    cur_res.append(res);
                }
                res = new StringBuilder(last_res + cur_res);
            } else if (x >= '0' && x <= '9') {
                num = num * 10 + (x - '0');

            } else
                res.append(x);
        }
        return res.toString();
    }
}
