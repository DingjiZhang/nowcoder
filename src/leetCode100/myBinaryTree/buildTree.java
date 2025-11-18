package leetCode100.myBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class buildTree {

    /*
    * 	1.	preorder 里：每次取一个新根（指针往右走）
	2.	inorder 里：用区间 [inL, inR] + map 找根的位置，然后左右两边就是左右子树
	3.	递归下去，直到 inL > inR，说明这个子树为空
    * */
    private Map<Integer, Integer> indexMap; //inorder 值 -> 下标
    private int[] preorder;
    private int preIndex = 0; // 当前用到的前序下标

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;

        this.preorder = preorder;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        // 整棵树的中序
        return build(0, n - 1);
    }

    // 根据中序区间构造子树
    private TreeNode build(int inL, int inR) {
        if (inL > inR) return null;

        // 当前子树的根：前序数组的 preIndex 位置
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = indexMap.get(rootVal);

        // 左子树
        root.left = build(inL, inRootIndex - 1);
        // 右子树
        root.right = build(inRootIndex + 1, inR);

        return root;
    }
}
