package leetCode1_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        Map<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        dfs(ans, map, digits, 0, new StringBuffer());
        return ans;
    }

    public void dfs(List<String> ans, Map<Character, String> map, String digits, int index, StringBuffer com) {
        if (index == digits.length())
            ans.add(com.toString());
        else {
            char dig = digits.charAt(index);
            String letters = map.get(dig);
            int lettCount = letters.length();
            for (int i = 0; i < lettCount; i++) {
                com.append(letters.charAt(i));
                dfs(ans, map, digits, index + 1, com);
                com.deleteCharAt(index);
            }
        }
    }
}
