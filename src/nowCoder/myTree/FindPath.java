package nowCoder.myTree;

import java.util.ArrayList;

public class FindPath {

    private ArrayList<ArrayList<Integer>> ans;

    /**
     * @param node   二叉树节点
     * @param target 目标权值和
     * @param sum    当前路径权值和
     * @param list   当前路径
     */
    private void solve(TreeNode node, int target, int sum, ArrayList<Integer> list) {
        if (node != null) {
            sum += node.val;
            list.add(node.val);

            if (node.left == null && node.right == null) { // 叶子节点
                if (sum == target) {
                    ArrayList<Integer> res = new ArrayList<>(list);
                    ans.add(res);
                }
            } else {
                solve(node.left, target, sum, list); // 递归左
                solve(node.right, target, sum, list); // 递归右
            }

            // 回溯操作点（往上了） 消除当前节点对查找路径的影响
            sum -= node.val;
            list.remove(list.size() - 1);
        }
    }

    // 从root开始，以叶子结束 才是一条路径
    // LNR, 往下的时候 +val，往上的时候 -val
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, target, 0, list);

        ans.sort((a, b) -> b.size() - a.size()); // 按路径长度降序排列
        return ans;
    }
}
