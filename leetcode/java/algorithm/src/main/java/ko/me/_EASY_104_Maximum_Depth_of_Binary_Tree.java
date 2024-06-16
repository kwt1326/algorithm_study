package ko.me;

// DFS, BFS
// https://leetcode.com/problems/maximum-depth-of-binary-tree
public class _EASY_104_Maximum_Depth_of_Binary_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int dfs(
            final int d,
            final TreeNode node
    ) {
        return node == null ? d : Math.max(dfs(d + 1, node.left), dfs(d + 1, node.right));
    }

    public static int maxDepth(final TreeNode root) {
        return dfs(0, root);
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        final TreeNode root = new TreeNode(
                3,
                new TreeNode(9, null, null),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        assert maxDepth(root) == 3;
    }
}
