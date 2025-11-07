package nowCoder.myTree;


public class GetNext {
    // 对pNode在二叉树中位置的讨论

    // 更简洁！
    // 1. pNode有右子树，后继就是其右子树的最左节点
    // 2. pNode没有右子树，沿着next一路往上，找到第一个把（当前）当成左孩子的祖先，该祖先的父亲就是后继。（这一步就是判断pNode是不是在整棵树的左侧）
    // 如果没找到，说明pNode是整棵树的最右节点，后继null
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 1.
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 2. 无右子树：向上找“第一次从左边走到父亲”的时刻
        TreeLinkNode cur = pNode;
        while (cur.next != null && cur == cur.next.right) {
            cur = cur.next; // 自己是父亲的右孩子，继续往上爬
        }
        return cur.next;  // 可能为 null：说明原结点是整棵树的最右结点
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 1. 有右孩子，下一个就是其右子树的最左下节点
        if (pNode.right != null) {
            pNode = pNode.right;
            // 找最左下
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else { // 没有右孩子
            TreeLinkNode parentNode = pNode.next;
            // 4. 父节点为空，pNode是根节点
            if (parentNode == null) {
                return null;
            }
            // 2. pNode是其父节点的左孩子，父节点就是下一个
            if (parentNode.left == pNode) {
                return parentNode;
            } else {
                // 3.1 pNode是其父节点的右孩子，且不是最后一个节点，下一个就是父节点的父节点
                // 3.2 如果pNode是最后一个节点，即最左下，他的下一个是null
                boolean isNotLast = false;
                while (parentNode.next != null) {
                    if (parentNode.next.left == parentNode) { // 在爷爷节点的左子树上
                        isNotLast = true;
                        break;
                    }
                    parentNode = parentNode.next;
                }
                return isNotLast ? parentNode.next : null;
            }
        }
    }

}
