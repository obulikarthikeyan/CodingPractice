package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15  7
 *
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> group = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node != null) {
                group.add(node.val);
            }

            if(queue.size() > 0 && node == null) {
                result.add(group);
                group  = new ArrayList<>();
                queue.offer(null);
            }

            if(node != null && node.left != null) {
                queue.offer(node.left);
            }

            if(node != null && node.right != null) {
                queue.offer(node.right);
            }
        }
        result.add(group);
        return result;
    }

    public static void helper(List<List<Integer>> result, TreeNode root, int length) {
        if(root == null) return;

        if(length == result.size()) {
            List<Integer> newList = new ArrayList<>();
            result.add(newList);
        }

        System.out.println(result.toString());
        result.get(length).add(root.val);
        helper(result, root.left, length + 1);
        helper(result, root.right, length + 1);
    }

    public static List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 0);
        return result;
    }


    public static void main(String ...args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.left.left = new TreeNode(12);
        node.left.right = new TreeNode(13);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(node);
        System.out.println("Output\n" + result.toString());
        System.out.println("\nOutput using Recursion\n" + levelOrderRecursive(node).toString());

    }
}
