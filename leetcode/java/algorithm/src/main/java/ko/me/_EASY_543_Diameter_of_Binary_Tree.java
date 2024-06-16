package ko.me;

// DFS
// https://leetcode.com/problems/diameter-of-binary-tree
public class _EASY_543_Diameter_of_Binary_Tree {
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

    // 답안 안보고 스스로 풀었을 때 통과한 답안 (Runtime 192ms, Memory 44.8 mb)
    private static class Solution {
        private int max = 0;

        // 어떤 노드에서 시작한 최대 깊이 재귀적 도출
        public int findMaxDepth(
                final int d,
                final TreeNode node
        ) {
            if (node == null) return d;
            return Math.max(
                    findMaxDepth(d + 1, node.left),
                    findMaxDepth(d + 1, node.right)
            );
        }

        // 차수가 증가할 때마다, 더 깊은 노드에서 길이 계산을 새로 시작해서 최대 길이를 비교해서 갱신하는 작업을 한다.
        public void dfs(final TreeNode node) {
            if (node == null) return;

            int ll = findMaxDepth(0, node.left);
            int rl = findMaxDepth(0, node.right);

            max = Math.max(max, ll + rl);

            // 더 깊지 않은 노드는 연산 생략
            if (ll > rl) {
                dfs(node.left);
            } else {
                dfs(node.right);
            }
        }

        public int diameterOfBinaryTree(final TreeNode root) {
            dfs(root);
            return max;
        }
    }

    // Runtime 1ms 짜리 최적의 답안
    private static class Solution2 {
        private int max;

        public int getHeightDfs(TreeNode root) {
            if (root == null) return 0;

            // 깊이 탐색을 하는 중 구한 left, right 높이의 중간값을 더해서
            // 최대값을 갱신하는 로직을 추가해 탐색을 최소화 한다.
            int ll = getHeightDfs(root.left);
            int lr = getHeightDfs(root.right);

            max = Math.max(max, ll + lr);

            return 1 + Math.max(ll, lr);
        }

        public int diameterOfBinaryTree(TreeNode root) {
            getHeightDfs(root);
            return max;
        }
    }

    public static void main(String[] args) {
        // [1,2,3,4,5]
        final TreeNode root = new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3, null, null)
        );

        assert new Solution().diameterOfBinaryTree(root) == 3;
        assert new Solution2().diameterOfBinaryTree(root) == 3;
    }
}
