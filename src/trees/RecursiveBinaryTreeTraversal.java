package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Inorder = Left, Root, Right
 */

public class RecursiveBinaryTreeTraversal {

    public static void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        int height = MaxHeightOfABinaryTree.maxDepth(root);

        for(int i=1; i<=height; i++) {
            printElementsAtLevel(root, i);
        }
    }

    public static void printElementsAtLevel(TreeNode root, int i) {
        if(root == null) {
            return;
        }

        if(i == 1) {
            System.out.print(root.data + " ");
        } else if(i > 1){
            printElementsAtLevel(root.left, i-1);
            printElementsAtLevel(root.right, i-1);
        }
    }

    public static void levelOrderTraversalUsingQueue(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");

            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void reverseLevelOrderTraversalUsingStack(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        queue.add(root);

        TreeNode node = root;
        while (!queue.isEmpty()) {
            node = queue.poll();
            stack.push(node);

            if(node.right != null) {
                queue.offer(node.right);
            }

            if(node.left != null) {
                queue.offer(node.left);
            }
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + " ");
        }
    }

    public static void reverseLevelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        int height = MaxHeightOfABinaryTree.maxDepth(root);

        for(int i=height; i>=1; i--) {
            printElementsAtLevel(root, i);
        }
    }

    public static void main(String ...args) {
        /**
         *  Tree Structure:
         *
         *          1
         *        /  \
         *       2   3
         *      / \ / \
         *     4  5 6 7
         *
         */

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println("Preorder traversal of binary tree is ");
        preOrderTraversal(tree.root);

        System.out.println("\n\nInorder traversal of binary tree is ");
        inorderTraversal(tree.root);

        System.out.println("\n\nPostorder traversal of binary tree is ");
        postOrderTraversal(tree.root);

        System.out.println("\n\nLevel Order (BFS) traversal of binary tree is ");
        levelOrderTraversal(tree.root);

        System.out.println("\n\nLevel Order (BFS) traversal of binary tree is ");
        levelOrderTraversalUsingQueue(tree.root);

        System.out.println("\n\nReverse Level Order (BFS) recursive traversal of binary tree is ");
        reverseLevelOrderTraversal(tree.root);

        System.out.println("\n\nReverse Level Order (BFS) iterative traversal of binary tree is ");
        reverseLevelOrderTraversalUsingStack(tree.root);
    }
}
