package leetCode100.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {

    /*
     * 1.剪枝1：避免重复：按顺序选择，前面选过的数后面不可以再选：如cand顺序是3，4，那么子集中3，4出现后，
     * 从4开始选时，后面不可以选3，于是：可以定义一个start下标，指示开始遍历的下标
     * 2.剪枝2：排序cand，若当前子集和超过了target，就停止这次遍历
     * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        Arrays.sort(candidates);
        List<Integer> state = new ArrayList<>(); //子集
        dfs(state, target, candidates, start, ans);
        return ans;
    }

    private void dfs(List<Integer> state, int target, int[] cands, int start, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝1
        for (int i = start; i < cands.length; i++) {
            // 剪枝2
            if (target - cands[i] < 0) break;
            // 尝试加入
            state.add(cands[i]);
            // 下一轮选择
            dfs(state, target - cands[i], cands, i, ans); // 注意这里的i
            state.remove(state.size() - 1);
        }
    }

    // 选与不选
    public List<List<Integer>> combinationSumSelectOrNot(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfsS(path, candidates, 0, target, ans);
        return ans;
    }

    private void dfsS(List<Integer> path, int[] cands, int index, int target, List<List<Integer>> ans) {
        if (index == cands.length || target < 0) return;

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选
        dfsS(path, cands, index + 1, target, ans);
        // 选
        path.add(cands[index]);
        dfsS(path, cands, index, target - cands[index], ans);
        path.remove(path.size() - 1);
    }
}
