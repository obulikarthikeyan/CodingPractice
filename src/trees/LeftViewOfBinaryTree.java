package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, print left view of it.
 * Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
 * Left view of following tree is 12, 10, 25.
 *
 *       12
 *     /    \
 *   10      30
 *           /  \
 *          25  40
 *
 * The left view contains all nodes that are first nodes in their levels.
 * A simple solution is to do level order traversal and print the first node in every level.
 * The problem can also be solved using simple recursive traversal.
 * We can keep track of level of a node by passing a parameter to all recursive calls.
 * The idea is to keep track of maximum level also.
 * Whenever we see a node whose level is more than maximum level so far, we print the node because this is the first node in its level
 * (Note that we traverse the left subtree before right subtree).
 */

public class LeftViewOfBinaryTree {

    static int max_level;

    public static void printLeftView(TreeNode root) {
        printLeftView(root, 1);
    }

    public static void printLeftView(TreeNode root, int level) {
        if(root == null) return;

        if(max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }

        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    public static void printRightView(TreeNode root) {
        printRightView(root, 1);
    }

    public static void printRightView(TreeNode root, int level) {
        if(root == null) return;

        if(max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }

        printRightView(root.right, level + 1);
        printRightView(root.left, level + 1);
    }

    /**
     * Use Level order and print the first element in each level
     * Push left child before right child into the queue
     */
    public static void printLeftViewIteratively(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (level > 0) {
            System.out.print(queue.peek().data + " ");
            while (level > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                level--;
            }
            level = queue.size();
        }
    }

    /**
     * Use Level order and print the first element in each level
     * Push right child before left child into the queue
     */
    public static void printRightViewIteratively(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (level > 0) {
            System.out.print(queue.peek().data + " ");
            while (level > 0) {
                TreeNode node = queue.poll();

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                level--;
            }
            level = queue.size();
        }
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(12);
        tree.root.left = new TreeNode(10);
        tree.root.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(25);
        tree.root.right.right = new TreeNode(40);
        tree.root.right.right.right = new TreeNode(50);

        System.out.println("Left View (Recursive)");
        printLeftView(tree.root);
        max_level = 0;
        System.out.println("\n\nLeft View (Iterative)");
        printLeftViewIteratively(tree.root);

        System.out.println("\n\nRight View (Recursive)");
        printRightView(tree.root);
        System.out.println("\n\nRight View (Iterative)");
        printRightViewIteratively(tree.root);
    }
}
