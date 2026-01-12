package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return ans;
        dfs(n, n);
        return ans;
    }

    private void dfs(int openLeft, int closeLeft) {
        if (openLeft == 0 && closeLeft == 0) {
            ans.add(path.toString());
            return;
        }

        if (openLeft == closeLeft) {
            // 剩下的左右相等，只能放（
            path.append('(');
            dfs(openLeft - 1, closeLeft);
            path.deleteCharAt(path.length() - 1);
        } else if (openLeft < closeLeft) {
            // 剩下的左 少于右，可以放（也可以放）
            if (openLeft > 0) {
                path.append('(');
                dfs(openLeft - 1, closeLeft);
                path.deleteCharAt(path.length() - 1);
            }
            //
            path.append(')');
            dfs(openLeft, closeLeft - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
