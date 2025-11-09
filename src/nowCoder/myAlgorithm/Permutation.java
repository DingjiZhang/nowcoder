package nowCoder.myAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str == null || str.isEmpty()) return ans;

        char[] a = str.toCharArray();
        Arrays.sort(a); // 字典序
        boolean[] used = new boolean[a.length]; // 记录在一条路径中，有没有被用过
        StringBuilder path = new StringBuilder();

        dfs(a, used, path, ans);
        return ans;
    }

    private void dfs(char[] a, boolean[] used, StringBuilder path, ArrayList<String> ans) {
        if (path.length() == a.length) {
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < a.length; i++) {
            // 剪枝：同一层相同字符只用一次
            // 去重关键：同一层里（一条路径中），若当前字符与前一个相同，且前一个还没被用过，就跳过
            if (i > 0 && a[i] == a[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                path.append(a[i]);
                dfs(a, used, path, ans);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}
