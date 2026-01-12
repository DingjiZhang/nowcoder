package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        dfs(ans, phoneMap, digits, 0, new StringBuffer());
        return ans;
    }

    private void dfs(List<String> ans, Map<Character, String> map, String digits, int index, StringBuffer comb) {
        if (index == digits.length()) ans.add(comb.toString());
        else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                comb.append(letters.charAt(i)); // 选了当前位
                dfs(ans, map, digits, index + 1, comb); // 选下一位
                comb.deleteCharAt(index);
            }
        }
    }

    // 还有一种队列方法：入队第一个数字对应的所有字母，出队一个a并和下一组字母组合成a*，再入队；遍历所有数字
}
