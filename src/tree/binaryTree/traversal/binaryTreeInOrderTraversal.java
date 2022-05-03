package tree.binaryTree.traversal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class binaryTreeInOrderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> inOrderTraversalNodes = new LinkedList<>();
        inOrderTraversal(root, inOrderTraversalNodes);
        return inOrderTraversalNodes;
    }

    public void inOrderTraversal(TreeNode root, LinkedList<Integer> inOrderNodes) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft(), inOrderNodes);
        inOrderNodes.addLast(root.getVal());
        inOrderTraversal(root.getRight(), inOrderNodes);
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
