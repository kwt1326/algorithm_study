package ko.me;

import ko.me.dataStructure.TreeNode;

// Tree Traverse
// https://leetcode.com/problems/balanced-binary-tree/description/
public class _EASY_110_Balanced_Binary_Tree {
    private static boolean isBalanced = true;

    private static int traversal(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int increaseDepth = depth + 1;
        int leftD = traversal(node.left, increaseDepth);
        int rightD = traversal(node.right, increaseDepth);
        if (Math.abs(leftD - rightD) > 1) {
            isBalanced = false;
        }
        return Math.max(leftD, rightD);
    }

    public static boolean isBalanced(TreeNode root) {
        traversal(root, 0);
        return isBalanced;
    }

    public static void main(String[] args) {
        isBalanced(new TreeNode(0));
    }
}
