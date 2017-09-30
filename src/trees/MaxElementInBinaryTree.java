package trees;

/**
 * If this was a Binary Search Tree (BST), traversing through the right subtrees until we reach the rightmost leaf would return max element
 * Since this is not a BST, we need to Traverse each and every node and find the Max of 3 items
 *
 * 1. Current Node's element
 * 2. Max element of left subtree
 * 3. Max element of right subtree
 */
public class MaxElementInBinaryTree {

    public static int getMin(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(getMin(root.left), getMin(root.right)));
    }

    public static int getMax(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Max element in tree is : " +
                getMax(tree.root));

        System.out.println("\nMin element in tree is : " +
                getMin(tree.root));
    }
}
