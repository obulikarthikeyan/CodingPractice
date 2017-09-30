package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *          _______3______
 *         /              \
 *     ___5__           ___1__
 *    /      \         /      \
 *   6       _2       0       8
 *          /  \
 *         7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 * Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */

public class LowestCommonAncestorInBinaryTree {

    static boolean left = false, right = false;

    //T: O(N) S: O(M) M is max height of tree
    public static TreeNode lowestCommonAncestorSpaceN(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        if(!findPath(root, p, path1) || !findPath(root, q, path2)) {
            return null;
        }

        int i;
        for(i=0; i < path1.size() && i < path2.size(); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        return path1.get(i-1);
    }

    //T: O(N) S: O(1)

    /**
     *
     * The idea is to traverse the tree starting from root.
     * If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present).
     * If root doesn’t match with any of the keys, we recur for left and right subtree.
     * The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
     * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
     *
     * Note: The above method assumes that keys are present in Binary Tree.
     * If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
     */
    public static TreeNode lowestCommonAncestorSpace1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestorSpace1(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestorSpace1(root.right, p, q);

        if(leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static TreeNode lowestCommonAncestorSpace1AcceptedSolution(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestorSpace1Optimized(root, p, q);
        if(left && right) {
            return lca;
        }

        return null;
    }

    public static TreeNode lowestCommonAncestorSpace1Optimized(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p) {
            left = true;

            if(root.left != null) {
                lowestCommonAncestorSpace1Optimized(root.left, p, q);
            }

            if(root.right != null) {
                lowestCommonAncestorSpace1Optimized(root.right, p, q);
            }

            return root;
        }

        if(root == q) {
            right = true;

            if(root.left != null) {
                lowestCommonAncestorSpace1Optimized(root.left, p, q);
            }

            if(root.right != null) {
                lowestCommonAncestorSpace1Optimized(root.right, p, q);
            }
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestorSpace1Optimized(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestorSpace1Optimized(root.right, p, q);

        if(leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public static boolean findPath(TreeNode root, TreeNode n, List<TreeNode> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.equals(n)) {
            return true;
        }

        if(root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if(root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(4);
        //tree.root.right.left = new TreeNode(6);
        //tree.root.right.right = new TreeNode(7);

        System.out.println("Input:");
        RecursiveBinaryTreeTraversal.levelOrderTraversal(tree.root);

        TreeNode p = tree.root.left;
        TreeNode q = tree.root.right;
        System.out.println("\n\n(Space N) Lowest Common Ancestor of " + p.data + " and " + q.data + " is " + lowestCommonAncestorSpaceN(tree.root, p, q).data);

        p = tree.root.left;
        q = new TreeNode(19);
        TreeNode r = lowestCommonAncestorSpaceN(tree.root, p, q);
        System.out.println("\n\n(Space N) Lowest Common Ancestor of " + p.data + " and " + q.data + " is " + ((r != null) ? r.data : null));

        System.out.println("\n\n(Space 1) Lowest Common Ancestor of " + p.data + " and " + q.data + " is " + lowestCommonAncestorSpace1(tree.root, p, q).data);

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);

        p = tree1.root;
        q = tree1.root.left;
        r = lowestCommonAncestorSpace1AcceptedSolution(tree1.root, p, q);
        System.out.println("\n\n(Space 1 Accepted) Lowest Common Ancestor of " + p.data + " and " + q.data + " is " + (r != null ? r.data : null));
    }
}
