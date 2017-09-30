package leetcode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Binary tree [2,1,3], return true. [root, left, right]
 *
 * Binary tree [1,2,3], return false. [root, left, right]
 */

public class ValidateBinarySearchTree {

    /*public static boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.val < min || root.val > max) {
            return false;
        }

        return (isValidBST(root.left, min, root.val-1) && isValidBST(root.right, root.val+1, max));
    }

    public boolean static isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }*/
}
