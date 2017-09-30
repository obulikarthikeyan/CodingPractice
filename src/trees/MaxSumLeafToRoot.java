package trees;

/**
 * Find the maximum sum leaf to root path in a Binary Tree
 * Given a Binary Tree, find the maximum sum path from a leaf to root.
 * For example, in the following tree, there are three leaf to root paths 8->-2->10, -4->-2->10 and 7->10.
 * The sums of these three paths are 16, 4 and 17 respectively.
 * The maximum of them is 17 and the path for maximum is 7->10.
 *          10
 *       /      \
 *     -2        7
 *    /   \
 *   8    -4
 */
public class MaxSumLeafToRoot {

    static int maxSum = Integer.MIN_VALUE;
    //static TreeNode targetNode;

    public static TreeNode findMaxSumPathLeafNode(TreeNode node,TreeNode targetNode,  int currentSum) {
        if (node == null) {
            return null;
        }

        currentSum = currentSum + node.data;
        if(node.left == null && node.right == null && currentSum > maxSum) {
            maxSum = currentSum;
            return node;
        }

        targetNode = findMaxSumPathLeafNode(node.left, targetNode, currentSum);
        targetNode = findMaxSumPathLeafNode(node.right,targetNode, currentSum);
        return targetNode;
    }

    public static boolean printMaxSumLeafToRootPath(TreeNode root, TreeNode leafNode) {
        if(root == null) {
            return false;
        }

        if(root == leafNode || printMaxSumLeafToRootPath(root.left, leafNode) || printMaxSumLeafToRootPath(root.right, leafNode)) {
            System.out.println(root.data);
            return true;
        }
        return false;
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(-2);
        tree.root.left.left = new TreeNode(8);
        tree.root.left.right = new TreeNode(-4);
        tree.root.right = new TreeNode(7);

        TreeNode targetNode = null;
        targetNode = findMaxSumPathLeafNode(tree.root, targetNode, 0);
        System.out.println("MaxSum = " + maxSum);
        printMaxSumLeafToRootPath(tree.root, targetNode);
    }
}
