package trees;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * For example:
 * Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 *
 * Return 6.
 */
public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        calculateMaxSum(root);
        return maxSum;
    }

    public static int calculateMaxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lMax = Math.max(0, maxPathSum(root.left));
        int rMax = Math.max(0, maxPathSum(root.right));
        maxSum = Math.max(maxSum, lMax + rMax + root.data);
        return Math.max(lMax, rMax) + root.data;
    }

    public static int maxPathSumBetweenTwoLeafNodes(TreeNode root) {
        return 0;
    }
}
