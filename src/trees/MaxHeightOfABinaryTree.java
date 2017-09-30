package trees;

/**
 * Max height or depth of a Binary Tree = Maximum(Max height of left subtree, Max height of right subtree) + 1
 */

public class MaxHeightOfABinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int max_left_depth = maxDepth(root.left);
        int max_right_depth = maxDepth(root.right);

        return Math.max(max_left_depth, max_right_depth) + 1;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Height of tree is : " +
                maxDepth(tree.root));
    }

}
