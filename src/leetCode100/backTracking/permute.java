package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.List;

public class permute {

    private List<Integer> nums;
    private List<List<Integer>> ans;

    private void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

    // 固定第x位（所有情况）
    private void dfs(int x) {
        // 当前位是最后一位，加入结果
        if (x == nums.size() - 1) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        // 固定当前位置，遍历所有的可取数字
        for (int i = x; i < nums.size(); i++) {
            swap(i, x); // 交换：将nums[i] 放到第x位
            dfs(x + 1); // 开始固定下一位
            swap(i, x); //  回溯的时候，恢复过来
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.ans = new ArrayList<>();
        this.nums = new ArrayList<>();
        for (int num : nums) this.nums.add(num);

        dfs(0); // 开始固定第1位
        return ans;
    }
}
