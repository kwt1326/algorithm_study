package ko.me.dataStructure;

public class TreeNode {
    public enum TraversalType {
        PRE,
        IN,
        POST
    }

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(final int val) {
        this.val = val;
    }

    public TreeNode(
            final int val,
            final TreeNode left,
            final TreeNode right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print(final TraversalType order) {
        if (order == TraversalType.PRE) {
            System.out.print(this.val + " ");
        }
        printInorderTraversal(this.left, order);
        if (order == TraversalType.IN) {
            System.out.print(this.val + " ");
        }
        printInorderTraversal(this.right, order);
        if (order == TraversalType.POST) {
            System.out.print(this.val + " ");
        }
    }

    // 배열을 BST로 변환하는 메서드
    public static TreeNode sortedArrayToBST(final Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return insertLevelOrder(nums, 0);
    }

    // 트리를 중위 순회하며 출력하는 메서드 (테스트용)
    public static void printInorderTraversal(final TreeNode root, final TraversalType order) {
        if (root != null) {
            if (order == TraversalType.PRE) {
                System.out.print(root.val + " ");
            }
            printInorderTraversal(root.left, order);
            if (order == TraversalType.IN) {
                System.out.print(root.val + " ");
            }
            printInorderTraversal(root.right, order);
            if (order == TraversalType.POST) {
                System.out.print(root.val + " ");
            }
        }
    }

    //region Private Methods
    // 재귀적으로 노드를 삽입하는 메서드
    private static TreeNode insertLevelOrder(final Integer[] arr, final int i) {
        TreeNode root = null;
        if (i < arr.length) {
            if (arr[i] == null) return null;

            root = new TreeNode(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
    //endregion
}
