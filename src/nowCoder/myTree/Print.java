package nowCoder.myTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS
public class Print {
    // 同一层从左往右打印
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        // BFS
        while (!queue.isEmpty() && root != null) { // 注意判空
            // 先倒出队列元素（当前层），再加入其左右孩子
            TreeNode node = queue.poll();
            // 结果列表
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] ans = new int[list.size()];
        int index = 0;
        for (int x : list) {
            ans[index++] = x;
        }
        return ans;
    }

    // 同上，区别是每一层是一个数组形式
    public List<List<Integer>> levelOrderList(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int sum = 1; // 保存每一层节点个数

        while (!queue.isEmpty() && root != null) { // 注意判空
            List<Integer> list = new LinkedList<>(); // 当前层的遍历结果
            int temp = 0; // 统计下一层的节点个数
            while (sum > 0) { // 遍历当前层
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    temp++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    temp++;
                }
                sum--;
            }
            sum = temp;
            ans.add(list);
        }
        return ans;
    }

    // “之”型打印，第一行从左往右 第二行从右往左...
    // 加一个变量记录当前是奇数层还是偶数层
    public List<List<Integer>> Print(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int sum = 1; // 保存每一层节点个数
        int num = 1; // 记录层数

        while (!queue.isEmpty() && root != null) { // 注意判空
            List<Integer> list = new LinkedList<>(); // 当前层的遍历结果
            int temp = 0; // 统计下一层的节点个数
            // 遍历当前层
            while (sum > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    temp++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    temp++;
                }
                sum--;
            }
            sum = temp;
            if (num % 2 == 0) {
                // 逆置list
                for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                    int res = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, res);
                }
            }
            num++;
            ans.add(list);
        }
        return ans;
    }


    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int sum = 1; // 保存每一层节点个数
        int num = 1; // 记录层数

        while (!queue.isEmpty() && pRoot != null) { // 注意判空
            ArrayList<Integer> list = new ArrayList<>(); // 当前层的遍历结果
            int temp = 0; // 统计下一层的节点个数
            // 遍历当前层
            while (sum > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                    temp++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    temp++;
                }
                sum--;
            }
            sum = temp;
            if (num % 2 == 0) {
                // 逆置list
                for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                    int res = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, res);
                }
            }
            num++;
            ans.add(list);
        }
        return ans;
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        // NLR
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(root.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return ans;
    }

}
