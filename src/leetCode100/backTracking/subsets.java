package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    // 位运算，构建000 - 111 的选择数组，为1表示当前位置的元素在子集中
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return ans;

        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) { // eg 3: 011
            t.clear();
            for (int i = 0; i < n; i++) { // eg: 选第二位和第三位数字加入t
                if ((mask & (1 << i)) != 0) t.add(nums[i]);
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    // 回溯法：每一个位置有选和不选两种情况
    // 选：加入，下一个递归，回溯
    // 不选：下一个递归
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    // 处理当前位置i的选择与否
    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        // 1.选
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);

        // 2. 不选
        dfs(cur + 1, nums);
    }
}
