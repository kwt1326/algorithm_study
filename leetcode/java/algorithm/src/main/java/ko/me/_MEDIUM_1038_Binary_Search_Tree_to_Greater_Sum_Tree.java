package ko.me;

import ko.me.dataStructure.TreeNode;

// Binary Search Tree
public class _MEDIUM_1038_Binary_Search_Tree_to_Greater_Sum_Tree {
    private int sum = 0;

    // 자신보다 큰 노드의 합을 구하려면, 중위 탐색을 사용해서 우측 노드의 탐색 결과를 더해서 반영한다.
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return root;

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);

        return root;
    }
}