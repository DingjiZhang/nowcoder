package nowCoder.myTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class BFSPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(pRoot);

        while (!q.isEmpty()) {
            int sz = q.size(); // 当前层节点数
            ArrayList<Integer> level = new ArrayList<>(); // 本层结果
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            ans.add(level); // 收集一层
        }
        return ans;
    }

    // 之形 方向交替
    public ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>(); // 用来收集下一层
        q.offer(pRoot);
        boolean isL2R = true;

        while (!q.isEmpty()) {
            int sz = q.size();
            Deque<Integer> level = new ArrayDeque<>(); //本层结果
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (isL2R) level.offerLast(cur.val); // L->R
                else level.offerFirst(cur.val); // R->L

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            ans.add(new ArrayList<>(level));
            isL2R = !isL2R; // 翻转方向
        }
        return ans;
    }
}
