package nowCoder.myTree;

import java.util.HashMap;
import java.util.Map;

public class FindPath2 {
    /*从父亲到孩子，找等于sum的路径有几条
     * 前缀和 + Map + dfs
     *
     * */
    public int FindPath(TreeNode root, int sum) {
        if (root == null) return 0;
        // 前缀和pre频次表，key：从根到当前节点之前的所有可用前缀和，value：该前缀和出现的次数
        // pre = cur - target
        Map<Long, Integer> freq = new HashMap<>();
        // 初始化前缀：前缀和pre为0的有1个
        freq.put(0L, 1);
        return dfs(root, 0L, (long) sum, freq);
    }

    // 进入当前节点的时刻，寻找到cur且权值和为target的路径有几条
    private int dfs(TreeNode node, long pre, long target, Map<Long, Integer> freq) {
        if (node == null) return 0;

        long cur = pre + node.val; // 根到当前节点的总权重和
        long needPre = cur - target; // 需要寻找的前缀和：当前总权重 - 目标权重
        int count = freq.getOrDefault(needPre, 0); // 以node为结尾的条数

        freq.put(cur, freq.getOrDefault(cur, 0) + 1); // 入：放入当前节点的前缀和（纳入到当前节点的路径）

        /* LRN 后序遍历递归
         *  出：在最后离开N时，删除到该node路径
         * */
        count += dfs(node.left, cur, target, freq); // 左递归
        count += dfs(node.right, cur, target, freq); // 右递归
        // 后序遍历到N时的 操作空间
        freq.put(cur, freq.get(cur) - 1);

        return count;
    }
}
