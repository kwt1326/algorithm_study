package ko.me;

import ko.me.dataStructure.TreeNode;

// Recursive
// https://leetcode.com/problems/merge-two-binary-trees
public class _EASY_617_Merge_Two_Binary_Trees {
    public static void merge(TreeNode m, TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return;
        }

        int v1 = n1 == null ? 0 : n1.val;
        int v2 = n2 == null ? 0 : n2.val;
        m.val = v1 + v2;

        TreeNode left1 = n1 != null ? n1.left : null;
        TreeNode right1 = n1 != null ? n1.right : null;
        TreeNode left2 = n2 != null ? n2.left : null;
        TreeNode right2 = n2 != null ? n2.right : null;

        // 트리 탐색을 left, right 따로 수행해야 한다.
        if (left1 != null || left2 != null) {
            m.left = new TreeNode();
            merge(m.left, left1, left2);
        }
        if (right1 != null || right2 != null) {
            m.right = new TreeNode();
            merge(m.right, right1, right2);
        }
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        final TreeNode m = new TreeNode();
        merge(m, root1, root2);
        return m;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1,2,null,3};
        Integer[] array2 = {1,null,2,null,3};
        TreeNode root1 = TreeNode.sortedArrayToBST(array1);
        TreeNode root2 = TreeNode.sortedArrayToBST(array2);
        mergeTrees(root1, root2).print(TreeNode.TraversalType.POST);
    }
}
