package ko.me;

import ko.me.dataStructure.TreeNode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class _EASY_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    private static TreeNode createNodes(int[] nums, int s, int e) {
        if (nums.length == 0 || s > e) {
            return null;
        }

        final int mid = s + (e - s) / 2;
        final TreeNode subRoot = new TreeNode(nums[mid]);
        subRoot.left = createNodes(nums, s, mid - 1);
        subRoot.right = createNodes(nums, mid + 1, e);

        return subRoot;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return createNodes(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        // int[] nums = new int[]{-10,-3,0,5,9};
        // int[] expect = new int[]{0,-10,5,null,-3,null,9};
        // assert sortedArrayToBST(nums).equals(expect);
    }
}
