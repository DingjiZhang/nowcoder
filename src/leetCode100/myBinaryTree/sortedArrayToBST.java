package leetCode100.myBinaryTree;

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        // 中序遍历，选择中间处数字作为根，一分为二
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) >> 1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, l, mid - 1);
        root.right = createTree(nums, mid + 1, r);
        return root;
    }

}
