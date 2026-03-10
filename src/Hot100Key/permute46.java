package Hot100Key;

import java.util.ArrayList;
import java.util.List;

public class permute46 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return ans;

        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>(len);

        dfs(nums, path, used);
        return ans;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
