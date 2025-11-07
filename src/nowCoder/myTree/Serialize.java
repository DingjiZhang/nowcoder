package nowCoder.myTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Serialize {
    // 层序序列化，根 -> 依次输出每个节点左右孩子；为空输出 #
    String Serialize(TreeNode root) {
        if (root == null) return "{}";

        List<String> out = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);   // 先放根
        out.add(String.valueOf(root.val));

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur.left != null) {  // 左
                q.offer(cur.left);
                out.add(String.valueOf(cur.left.val));
            } else {
                out.add("#");
            }

            if (cur.right != null) {  // 右
                q.offer(cur.right);
                out.add(String.valueOf(cur.right.val));
            } else {
                out.add("#");
            }
        }
        // 去掉末尾多余#
        int lastIndex = out.size() - 1;
        while (lastIndex >= 0 && out.get(lastIndex).equals("#")) lastIndex--;

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i <= lastIndex; i++) {
            if (i > 0) sb.append(',');
            sb.append(out.get(i));
        }
        sb.append('}');
        return sb.toString();

    }

    // 反序列化 按层序恢复，父节点出队，依次读取左右俩孩子
    TreeNode Deserialize(String str) {
        if (str == null || str.isEmpty() || str.equals("{}")) return null;

        String s = str.charAt(0) == '{' ? str.substring(1, str.length() - 1) : str;
        if (s.isEmpty()) return null;

        String[] arr = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode parent = q.poll();

            // 左孩子
            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            // 右孩子
            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
