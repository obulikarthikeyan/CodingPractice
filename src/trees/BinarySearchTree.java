package trees;

/**
 * Binary Search Tree, is a node-based binary tree data structure which has the following properties:
 *
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 */
public class BinarySearchTree {

    //T: O(log N); Worst case: T: O(h) where h is the height of the BST
    public static TreeNode search(TreeNode root, int x) {
        if (root == null || root.data == x) {
            return root;
        }

        if(root.data < x) {
            return search(root.right, x);
        } else {
            return search(root.left, x);
        }
    }

    //Inorder Traversal of BST will always result in sorted order
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + ", ");
        printInorder(root.right);
    }

    public static TreeNode insert(TreeNode root, int x) {
        if (root == null) {
            return new TreeNode(x);
        }

        if(x < root.data) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }

        return root;
    }

    //Leftmost leaf node of a BST will always be minimum element
    //T: O(n) Worst case happens for left skewed trees.
    public static int minValue(TreeNode root) {
        TreeNode current = root;

        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public static int maxValue(TreeNode root) {
        TreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    public static TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        if(key < root.data) {
            root.left = delete(root.left, key);
        } else if(key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public static void findKthSmallestElement(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        findKthSmallestElement(root.left, k);
        if(k == 0) {
            System.out.println("K-th smallest element = " + root.data);
            return;
        }
        k--;
        findKthSmallestElement(root.right, k);
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(6);
        tree.root.right = new TreeNode(16);
        tree.root.left.left = new TreeNode(2);
        tree.root.right.left = new TreeNode(12);
        tree.root.right.right = new TreeNode(20);

        TreeNode node = search(tree.root, 2);
        System.out.println("Output: " + (node != null ? node.data : "Element Not found"));
        tree.root = insert(tree.root, 25);
        System.out.print("\nAfter Inserting 25: ");
        printInorder(tree.root);
        tree.root = insert(tree.root, 8);
        System.out.print("\nAfter Inserting 8: ");
        printInorder(tree.root);
        System.out.println("\nMinimum element = " + minValue(tree.root));
        tree.root = insert(tree.root, -1);
        System.out.print("\nAfter Inserting -1: ");
        printInorder(tree.root);
        System.out.println("\nMinimum element = " + minValue(tree.root));
        System.out.println("\nMaximum element = " + maxValue(tree.root));
        findKthSmallestElement(tree.root, 3);

    }
}
