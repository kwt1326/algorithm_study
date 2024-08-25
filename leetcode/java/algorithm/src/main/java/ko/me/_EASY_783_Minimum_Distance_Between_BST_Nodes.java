package ko.me;

import ko.me.dataStructure.TreeNode;

// Tree
public class _EASY_783_Minimum_Distance_Between_BST_Nodes {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prevValue = null;

    public void inorderTraversal(TreeNode root) {
        if (root == null) return;

        // 왼쪽 서브트리 탐색
        inorderTraversal(root.left);

        // 현재 노드 처리 (중위 처리)
        if (prevValue != null) {
            minDiff = Math.min(minDiff, root.val - prevValue);
        }
        prevValue = root.val;

        // 오른쪽 서브트리 탐색
        inorderTraversal(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }
}