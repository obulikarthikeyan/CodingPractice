package trees;


import java.util.Stack;

/**
 * Using Stack in place of recursive call stack
 */


public class IterativeBinaryTreeTraversal {

    static Stack<TreeNode> stack = new Stack<>();

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                node = node.right;

                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public static void preOrderTraversal(TreeNode root) {
        if(root == null) return;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if(node.left!= null) {
                stack.push(node.left);
            }
        }

    }

    /**
     * 1.1 Create an empty stack
     * 2.1 Do following while root is not NULL
     *      a) Push root's right child and then root to stack.
     *      b) Set root as root's left child.
     * 2.2 Pop an item from stack and set it as root.
     *      a) If the popped item has a right child and the right child
     *         is at top of stack, then remove the right child from stack,
     *         push the root back and set root as root's right child.
     *      b) Else print root's data and set root as NULL.
     * 2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
     *
     */
    public static void postOrderTraversal(TreeNode root) {
        if(root == null) return;

        TreeNode node = root;
        do {
            while (node != null) {
                if(node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if(node.right != null && !stack.isEmpty() && node.right == stack.peek()) {
                stack.pop();
                stack.push(node);
                node = node.right;
            } else {
                System.out.print(node.data + " ");
                node = null;
            }
        } while (!stack.isEmpty());

    }

    /**
     *
     * Use 1st stack to traverse preorder
     * Use 2nd stack to construct reverse post order (Root, Right, Left) and print the contents
     *
     * Push root to 1st stack
     * while 1st stack is not empty
     *   1. Pop node from 1st stack and push it to 2nd stack.
     *   2. Push the node's left and right to 1st stack.
     *   3. Repeat.
     * Print content of 2nd stack.
     *
     */
    public static void postOrderTraversalUsing2Stacks(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode node = root;
        s1.push(node);

        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node);

            if(node.left != null) {
                s1.push(node.left);
            }

            if(node.right != null) {
                s1.push(node.right);
            }
        }

        while (!s2.isEmpty()) {
            node = s2.pop();
            System.out.print(node.data + " ");
        }
    }

    /**
     * Inorder traversal without iterative and without using Stack
     *
     * Morris Tree Traversal using Threaded Binary Tree
     *
     * In this traversal, we first create links to Inorder successor and print the data using these links, and finally revert the changes to restore original tree.
     *
     *  1. Initialize current as root
     *  2. While current is not NULL
     *      If current does not have left child
     *          a) Print current’s data
     *          b) Go to the right, i.e., current = current->right
     *      Else
     *          a) Make current as right child of the rightmost node in current's left subtree
     *          b) Go to this left child, i.e., current = current->left
     *
     */
    public static void inorderTraversalWithoutStack(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode current = root, prev = null;
        while (current != null) {
            if(current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                prev = current.left;

                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    /**
     * PreOrder traversal without iterative and without using Stack
     *
     * Morris Tree Traversal using Threaded Binary Tree similar to InOrder
     *
     * In this traversal, we first create links to PreOrder successor and print the data using these links, and finally revert the changes to restore original tree.
     *
     *  1. If left child is null, print the current node data. Move to right child.
     *     Else, Make the right child of the inorder predecessor point to the current node.
     *     Two cases arise:
     *       a) The right child of the inorder predecessor already points to the current node. Set right child to NULL. Move to right child of current node.
     *       b) The right child is NULL. Set it to current node. Print current node’s data and move to left child of current node.
     *  2. Iterate until current node is not NULL.
     *
     */
    public static void preOrderTraversalWithoutStack(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode current = root, prev = null;
        while (current != null) {
            if(current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                prev = current.left;

                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if(prev.right == current) {
                    prev.right = null;
                    current = current.right;
                } else {
                    prev.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                }
            }
        }
    }

    public static void main(String ...args) {
        /**
         *  Tree Structure:
         *
         *         1
         *        / \
         *       2  3
         *      / \
         *     4  5
         *
         */

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(6);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Preorder traversal of binary tree is ");
        preOrderTraversal(tree.root);

        System.out.println("\n\nPreorder traversal of binary tree without stack ");
        preOrderTraversalWithoutStack(tree.root);

        System.out.println("\n\nInorder traversal of binary tree is ");
        inorderTraversal(tree.root);

        System.out.println("\n\nInorder traversal without Stack of binary tree is ");
        inorderTraversalWithoutStack(tree.root);

        System.out.println("\n\nPostorder traversal of binary tree is ");
        postOrderTraversal(tree.root);

        System.out.println("\n\nPostorder traversal of binary tree is ");
        postOrderTraversalUsing2Stacks(tree.root);
    }
    
}
