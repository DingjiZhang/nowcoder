package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class partition {

    /**
     * 子集型回溯：
     * 方法一：假设每个字符间有有一个逗号，选or不选 --> 分割
     * 方法二：枚举子串结束的位置
     *
     * @param s 输入字符串
     * @return 回文字符串列表
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) return ans;

        List<String> path = new ArrayList<>();
        dfs(0, 0, s, path, ans);
        return ans;
    }

    /*
     * 考虑 i 后面的逗号选还是不选
     * start 表示回文串开始的位置
     * */
    private void dfs(int i, int start, String s, List<String> path, List<List<String>> ans) {
        if (i == s.length()) { // 分割完毕
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不分割
        if (i < s.length() - 1) { // i == n - 1时只能分割
            // 考虑 i + 1
            dfs(i + 1, start, s, path, ans);
        }

        // 分割, 选 i 和 i+1 之间的逗号
        if (isPalindrome(s, start, i)) {
            path.add(s.substring(start, i + 1));
            // 考虑i+1
            dfs(i + 1, i + 1, s, path, ans);
            path.remove(path.size() - 1); // 回溯
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 考虑 s[i] ~ s[n-1] 怎么分割，枚举子串结束位置
    public List<List<String>> partition2(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) return ans;

        List<String> path = new ArrayList<>();
        dfs2(0, s, path, ans);
        return ans;
    }

    private void dfs2(int i, String s, List<String> path, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 枚举子串结束位置
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                path.add(s.substring(i, j + 1));
                // 考虑剩下的 s[j+1] ~ s[n-1]
                dfs2(j + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
