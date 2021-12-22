package Trees.P104;

/**
 * LeetCode P104.
 * Maximum Depth of Binary Tree
 *
 * @author Jonghoon Jang
 * @version Dec, 2021
 */
public class MaxDepth {

    /**
     * A binary tree's maximum depth is the number of nodes along the
     * longest path from the root node down to the farthest leaf node.
     *
     * @param root a root of the binary tree
     * @return maximum depth of binary tree as an integer
     */
    public int getMaxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = getMaxDepth(root.left);
        int maxRight = getMaxDepth(root.right);

        return 1 + Math.max(maxLeft, maxRight);
    }

}
