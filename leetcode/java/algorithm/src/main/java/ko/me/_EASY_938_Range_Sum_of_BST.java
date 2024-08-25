package ko.me;

import ko.me.dataStructure.TreeNode;

// Tree
public class _EASY_938_Range_Sum_of_BST {
    private int sum = 0;

    public void recursive(TreeNode root, int low, int high) {
        if (root == null) return;

        // 값 범위에 맞으면 합계에 반영
        if (low <= root.val && high >= root.val) {
            sum += root.val;
        }
        // 값 범위에 들어가지 않으면 더 이상 탐색할 필요가 없다.
        if (low <= root.val) {
            recursive(root.left, low, high);
        }
        if (high >= root.val) {
            recursive(root.right, low, high);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        recursive(root, low, high);
        return sum;
    }
}