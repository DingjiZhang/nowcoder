package nowCoder.myTree;

public class reConstructBinaryTree {
    private int index = 0; // 遍历前序序列的下标

    private TreeNode solve(int[] pre, int[] tempVin) {

        /* 统计左右字数个数 */

        int leftLen = 0; // 当前节点左子树个数
        int rightLen = 0; // 当前节点右子树个数
        for (int i = 0; i < tempVin.length; i++) {
            if (pre[index] == tempVin[i]) {
                break;
            }
            leftLen++;
        }
        rightLen = tempVin.length - leftLen - 1;

        int leftIndex = 0, rightIndex = 0;
        int[] left = new int[leftLen]; // 当前节点左子树
        int[] right = new int[rightLen]; // 当前节点右子树
        // 在中序中分割出左右子树
        boolean flag = false;
        for (int i = 0; i < tempVin.length; i++) {
            if (pre[index] == tempVin[i]) {
                flag = true;
            } else if (!flag) { // 左
                left[leftIndex++] = tempVin[i];
            } else { // 右
                right[rightIndex++] = tempVin[i];
            }
        }

        /* core */
        TreeNode node = new TreeNode(pre[index]); // 当前的顶节点
//        System.out.printf("%d左子树：", pre[index]);
//        for (int i = 0; i < left.length; i++) {
//            System.out.printf("%d", left[i]);
//        }
//        System.out.printf(", %d右子树：", pre[index]);
//        for (int i = 0; i < right.length; i++) {
//            System.out.printf("%d", right[i]);
//        }
//        System.out.println(" ");

        if (index < pre.length && left.length > 0) {
            index++; // 遍历前序序列的下标+1
            node.left = solve(pre, left); // 创建当前节点的左子树
        }
        if (index < pre.length && right.length > 0) {
            index++;
            node.right = solve(pre, right);
        }
        return node;
    }

    // 根据前序和中序构建二叉树
    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        index = 0;

        if (preOrder == null || vinOrder == null || preOrder.length != vinOrder.length || preOrder.length == 0) {
            return null;
        }
        return solve(preOrder, vinOrder);
    }

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int vin[] = {4, 7, 2, 1, 5, 3, 8, 6};
    }
}
