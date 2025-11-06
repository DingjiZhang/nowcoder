package nowCoder.myTree;

public class HasSubtree {
    private boolean judge(TreeNode n1, TreeNode n2) { /// 第二部分：匹配
        if (n2 == null) { // 说明B的某一方向的节点已经完全匹配成功
            return true;
        }
        if (n1 == null) { // 说明在某一方向上，A的节点是缺少于B的
            return false;
        }
        if (n1.val == n2.val) {
            boolean flag1 = true; // 默认左子树是匹配的 假如不匹配就返回false
            boolean flag2 = true;
            if (n1.left != null || n2.left != null) {
                flag1 = judge(n1.left, n2.left); // 比较子树A和二叉树B的左子树
            }
            if (flag1 && (n1.right != null || n2.right != null)) {
                flag2 = judge(n1.right, n2.right);
            }
            return flag1 && flag2; // 左右子树都要匹配
        } else {
            return false;
        }
    }

    // 二叉树先序遍历
    private boolean dfs(TreeNode node, TreeNode root) { /// 第一部分：查找
        boolean flag = false;
        if (node.val == root.val) { // LNR 先序的操作点 在这
            flag = judge(node, root); /// 进入第二部分比较
        }
        if (flag) {
            return true; ///通过当前节点，已经找到了完全匹配的B。截断
        }

        boolean hasSameLeft = false; /// 记录当前节点左子树查找结果（包含了匹配过程） 如果查找成功（包含了匹配过程）返回true
        boolean hasSameRight = false; /// 记录当前节点右子树查找结果
        if (node.left != null) {
            hasSameLeft = dfs(node.left, root); /// 当前节点的val不等于B的root，遍历左子树，看是否匹配B
        }
        if ((!hasSameLeft) && node.right != null) { // !hasSameLeft 剪枝
            hasSameRight = dfs(node.right, root);
        }
        return hasSameLeft | hasSameRight; /// 只需要找到节点的某一个方向的子树进行匹配就好
    }

    // 1. 遍历A，与B的root比较
    // 2. 如果A的当前节点与B的root值相等，那就抽出A中以当前节点为顶的子树，继续比较
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return dfs(root1, root2);
    }
}
