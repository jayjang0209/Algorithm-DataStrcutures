package tree.binaryTree.traversal;

import java.util.LinkedList;
import java.util.List;

public class binaryTreeInOrderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> inOrderTraversalNodes = new LinkedList<>();
        dfs(root, inOrderTraversalNodes);
        return inOrderTraversalNodes;
    }

    public void dfs(TreeNode root, LinkedList<Integer> inOrderNodes) {
        if (root == null) {
            return;
        }
        dfs(root.getLeft(), inOrderNodes);
        inOrderNodes.addLast(root.getVal());
        dfs(root.getRight(), inOrderNodes);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getRight() {
        return right;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
