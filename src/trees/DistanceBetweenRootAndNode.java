package trees;

/**
 * Given root of a binary tree and a key x in it, find distance of the given key from root.
 * Distance means number of edges between two nodes.
 *
 * Examples:
 * Input : x = 45,
 * Root of below tree
 *          5
 *       /    \
 *     10      15
 *    / \    /  \
 *  20  25  30   35
 *       \
 *       45
 *
 * Output : Distance = 3
 *
 * There are three edges on path from root to 45.
 *
 * For more understanding of question, in above tree distance of 35 is two and distance of 10 is 1.
 */

public class DistanceBetweenRootAndNode {

    public static int findDistance(TreeNode root, int n) {

        if (root == null)
            return -1;

        if (root.data == n)
            return 0;
        int left = findDistance(root.left, n);
        int right = findDistance(root.right, n);

        if(left==-1 && right==-1)
            return -1;
        return (left >= 0) ? left+1 : right+1;
    }

    public static int findDistanceSimple(TreeNode root, int n) {
        if(root == null) {
            return -1;
        }

        int dist = -1;

        if(root.data == n || (dist = findDistance(root.left, n)) >= 0 || (dist = findDistance(root.right, n)) >= 0) {
            return dist+1;
        }
        return dist;
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(10);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(25);
        tree.root.left.right.right = new TreeNode(45);
        tree.root.right.left = new TreeNode(30);
        tree.root.right.right = new TreeNode(35);

        System.out.println("Distance between " + tree.root.data + " and " + tree.root.left.right.right.data + " is " +
                findDistance(tree.root, 45)
        );

        System.out.println("Distance between " + tree.root.data + " and " + tree.root.left.right.right.data + " is " +
                findDistanceSimple(tree.root, 45)
        );

    }
}
