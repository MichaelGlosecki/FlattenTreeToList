public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(3);
        two.right = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        five.right = new TreeNode(6);
        root.left = two;
        root.right = five;

        solution.flatten(root);
    }

    public void flatten(TreeNode root) {
        subTreeFlatten(root);
        //edit
    }

    private TreeNode subTreeFlatten(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = root;

        //Flatten the right side first.
        TreeNode right = subTreeFlatten(node.right);
        //Flatten the left side to the right.
        node.right = subTreeFlatten(node.left);

        //Flatten the left to the right.
        node.left = null;
        while (node.right != null) {
            node = node.right;
        }
        //Move the root of the flattened right subtree to the current bottom right node.
        node.right = right;

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}