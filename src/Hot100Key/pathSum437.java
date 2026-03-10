package Hot100Key;

import leetCode100.myBinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class pathSum437 {

    private int ans;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCnt = new HashMap<>();
        prefixSumCnt.put(0L, 1);
        dfs(root, 0, targetSum, prefixSumCnt);
        return ans;
    }

    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> prefixSumCnt) {
        if (node == null) return;

        s += node.val;
        ans += prefixSumCnt.getOrDefault(s - targetSum, 0);
        prefixSumCnt.put(s, prefixSumCnt.getOrDefault(s, 0) + 1);

        dfs(node.left, s, targetSum, prefixSumCnt);
        dfs(node.right, s, targetSum, prefixSumCnt);

        prefixSumCnt.put(s, prefixSumCnt.get(s) - 1);
    }
}
