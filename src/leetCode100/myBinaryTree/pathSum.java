package leetCode100.myBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class pathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 前缀和 + map + dfs RLN
        // 从根到当前节点，所有前缀和的频次  pre = cur - target
        Map<Long, Integer> preFreq = new HashMap<>();
        preFreq.put(0L, 1);

        return dfs(root, 0L, targetSum, preFreq);
    }

    // 进入当前节点，寻找到cur且权值和为target的路径有几条
    private int dfs(TreeNode node, long pre, int target, Map<Long, Integer> freq) {
        if (node == null) return 0;

        long cur = pre + node.val;
        long needPre = cur - target; // 总权重 - 目标权重 = 需要的前缀和

        int cnt = freq.getOrDefault(needPre, 0); // 以node为结尾的路径条数

        // 放入当前路径
        freq.put(cur, freq.getOrDefault(cur, 0) + 1);

        cnt += dfs(node.left, cur, target, freq);
        cnt += dfs(node.right, cur, target, freq);

        // 出去时，删除这一条
        freq.put(cur, freq.get(cur) - 1);

        return cnt;
    }
}
