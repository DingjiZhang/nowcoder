package leetCode100.myBinaryTree;

public class maxPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // 递归计算左右节点，只有最大贡献值大于0时才选取
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 该节点的最大贡献值：自己 + 左右
        int priceCur = node.val + leftGain + rightGain;
        // 更新
        maxSum = Math.max(priceCur, maxSum);

        // 离开节点向上传递时，只能传一边
        return node.val + Math.max(leftGain, rightGain);
    }
}
