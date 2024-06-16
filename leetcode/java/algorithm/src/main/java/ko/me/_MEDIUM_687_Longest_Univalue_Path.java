package ko.me;

// DFS
// https://leetcode.com/problems/longest-univalue-path
public class _MEDIUM_687_Longest_Univalue_Path {
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

    private static class Solution {
        // 전역 최대값으로 갱신한다.
        private int max = 0;

        public int dfs(
                final int d, // 깊이 상태
                final int t, // 부모 타겟 넘버
                final TreeNode node
        ) {
            if (node == null) return d;

            // 탐색할 노드의 값이 타겟과 다르면 새로 탐색을 시작한다.
            if (node.val != t) {
                int ld = dfs(0, node.val, node.left);
                int rd = dfs(0, node.val, node.right);
                max = Math.max(max, ld + rd);

                return 0;
            }

            // 부모 타겟과 같으면 depth 를 유지하고 이어서 탐색한다.
            int ld = dfs(d, t, node.left);
            int rd = dfs(d, t, node.right);
            max = Math.max(max, ld + rd);

            // 자식이 새로 시작하면 자식의 depth 는 무효가 되므로 후위로 계산한다.
            return Math.max(ld, rd) + 1;
        }

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            dfs(0, root.val, root);
            return max;
        }
    }

    public static void main(String[] args) {
        // [1,4,5,4,4,null,5]
        final TreeNode root = new TreeNode(
                1,
                new TreeNode(4,
                        new TreeNode(4),
                        new TreeNode(4)
                ),
                new TreeNode(5,
                        null,
                        new TreeNode(5)
                )
        );

        assert new Solution().longestUnivaluePath(root) == 2;
    }
}
