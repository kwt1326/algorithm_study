package ko.me;

import ko.me.dataStructure.TreeNode;

import java.util.*;

// Tree Traverse
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class _HARD_297_Serialize_and_Deserialize_Binary_Tree {

    public static class Codec {
        private TreeNode traverse(LinkedList<String> spl) {
            String next = spl.pollFirst();
            if (next == null) {
                return null;
            }

            int val = 0;
            try {
                val = Integer.parseInt(next);
            } catch (NumberFormatException e) {
                return null;
            }

            TreeNode newNode = new TreeNode(val);
            newNode.left = traverse(spl);
            newNode.right = traverse(spl);

            return newNode;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }

            String left = serialize(root.left);
            String right = serialize(root.right);
            return String.join(",", String.valueOf(root.val), left, right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] sp = data.split(",");
            LinkedList<String> spl = new LinkedList<>(Arrays.asList(sp));

            return traverse(spl);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(); // mock [1,2,3,null,null,4,5]
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
    }
}
