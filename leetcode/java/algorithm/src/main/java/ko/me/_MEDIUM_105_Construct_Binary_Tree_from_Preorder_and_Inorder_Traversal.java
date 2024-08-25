package ko.me;

import ko.me.dataStructure.TreeNode;

import java.util.Arrays;
import java.util.List;

// Tree, DFS, Divide And Conquer (분할 정복)
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class _MEDIUM_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    /*
    * 전위 탐색 배열의 첫번째 인덱스 값이 중위 탐색 배열의 좌-우를 가르는 기준이 된다.
    * 따라서, 전위 탐색시 첫 인덱스를 기준으로 중위 탐색 배열을 분할-정복 하여 트리의 크기를 확인하고 구성한다.
    * */
    public TreeNode recursive(
            List<Integer> preorder,
            List<Integer> inorder
    ) {
        if (inorder.isEmpty()) {
            return null;
        }

        int startIdx = inorder.indexOf(preorder.get(0));
        TreeNode node = new TreeNode(inorder.get(startIdx));

        /*
        * 전위 배열의 첫 인덱스를 제외하고 좌측 트리 구성을 위한 배열을 잘라 넘긴다.
        * preorder 는 첫 인덱스를 사용했으니 첫 인덱스만 제외하고, 나머지는 inorder 와 같은 인덱스를 보면서 자른다.
        * */
        node.left = recursive(
                preorder.subList(1, startIdx + 1),
                inorder.subList(0, startIdx)
        );
        node.right = recursive(
                preorder.subList(startIdx + 1, preorder.size()),
                inorder.subList(startIdx + 1, inorder.size())
        );
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = Arrays.stream(preorder).boxed().toList();
        List<Integer> inorderList = Arrays.stream(inorder).boxed().toList();
        return recursive(preorderList, inorderList);
    }
}
