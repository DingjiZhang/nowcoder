package nowCoder.otherAlgorithm;

import java.util.Arrays;

public class PrintMinNumber {

    // 这题用“拼接比较”的排序规则：把每个数转成字符串，按 a+b 与 b+a 的字典序比较，a+b 更小就把 a 放前面。
    // 排完直接拼接即可。
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";

        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) s[i] = String.valueOf(numbers[i]);

        Arrays.sort(s, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String t : s) sb.append(t);
        return sb.toString();
    }
}
