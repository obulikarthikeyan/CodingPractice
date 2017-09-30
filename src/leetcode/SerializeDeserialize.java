package leetcode;

import trees.BinaryTree;
import trees.RecursiveBinaryTreeTraversal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by osampath on 8/20/17.
 */
public class SerializeDeserialize {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public static String serialize(trees.TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(trees.TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.data).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public static trees.TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private static trees.TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            trees.TreeNode node = new trees.TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String ...args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new trees.TreeNode(1);
        tree.root.left = new trees.TreeNode(2);
        //tree.root.right = new trees.TreeNode(3);
        tree.root.left.left = new trees.TreeNode(3);
        //tree.root.left.right = new trees.TreeNode(5);
        tree.root.left.left.left = new trees.TreeNode(4);
        tree.root.left.left.left.left = new trees.TreeNode(5);
        //tree.root.right.left = new trees.TreeNode(6);
        //tree.root.right.right = new trees.TreeNode(7);

        String s = serialize(tree.root);

        System.out.println("Output: " + s);

        trees.TreeNode root = deserialize(s);

        RecursiveBinaryTreeTraversal.levelOrderTraversal(root);
    }
}
