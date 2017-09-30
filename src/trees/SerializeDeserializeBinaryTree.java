package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *             1
 *            / \
 *           2   3
 *          / \
 *         4   5
 *
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * */

public class SerializeDeserializeBinaryTree {

    public static String serializePreOrder(TreeNode root) {
        if(root == null) {
            return "null";
        }

        int height = MaxHeightOfABinaryTree.maxDepth(root);
        List<String> result = new ArrayList<>();

        //for(int i=1; i<=height; i++) {
            serializePreOrder(root, result);
        //}

        return result.stream().collect(Collectors.joining(","));
    }

    private static void serializePreOrder(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("null");
            return;
        } else {

            //if(level == 1) {
            result.add(String.valueOf(root.data));
            //} else {
            serializePreOrder(root.left, result);
            serializePreOrder(root.right, result);
            //}
        }
    }

    public static TreeNode deserializePreOrder(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }

        String[] str = data.split(",");
        Queue<Integer> list = new LinkedList<>();
        for (String t : str) {
            if(t.equals("null")) {
                list.offer(null);
            } else {
                list.offer(Integer.parseInt(t));
            }
        }
        return deserializePreOrder(list);
    }

    private static TreeNode deserializePreOrder(Queue<Integer> list) {
        Integer val = list.poll();
        if(val == null) {
            return null;
        } else {
            TreeNode root = new TreeNode(val);
            root.left = deserializePreOrder(list);
            root.right = deserializePreOrder(list);
            return root;
        }
    }

    public static String serializeBFS(TreeNode root) {
        String result = "";

        if(root == null) {
           return "null";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) {
                result += "null,";
            } else {
                result += node.data + ",";
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result;
    }

    public static TreeNode deserializeBFS(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }

        String[] str = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String t : str) {
            if(t.equals("null")) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(t));
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(0));
        queue.offer(root);

        for(int i=1; i<list.size()-1; i++) {
            TreeNode node = queue.poll();
            Integer val = list.get(i++);

            if (val != null) {
                    node.left = new TreeNode(val);
                    queue.offer(node.left);
            }

            val = list.get(i);
            if (val != null) {
                node.right = new TreeNode(val);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        //tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(3);
        //tree.root.left.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(4);
        tree.root.left.left.left.left = new TreeNode(5);
        //tree.root.right.left = new TreeNode(6);
        //tree.root.right.right = new TreeNode(7);

        String s = serializePreOrder(tree.root);

        System.out.println("Output: " + s);

        TreeNode root = deserializePreOrder(s);

        RecursiveBinaryTreeTraversal.levelOrderTraversal(root);

        s = serializeBFS(tree.root);

        System.out.println("\n\nBFS Serialize: " + s);

        root = deserializeBFS(s);

        RecursiveBinaryTreeTraversal.levelOrderTraversal(root);
    }

}
