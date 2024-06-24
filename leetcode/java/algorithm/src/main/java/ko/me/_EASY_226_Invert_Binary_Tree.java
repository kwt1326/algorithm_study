package ko.me;

import ko.me.dataStructure.TreeNode;

// Recursive
// https://leetcode.com/problems/invert-binary-tree/
public class _EASY_226_Invert_Binary_Tree {

    public static void invert(TreeNode node) {
        if (node == null) return;

        TreeNode temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);
    }

    public static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.sortedArrayToBST(array);
        invertTree(root);
    }
}
