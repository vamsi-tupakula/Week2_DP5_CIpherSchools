public class FullBinaryTree {
    public static boolean isFullBinaryTree(TreeNode root) {
        if (root == null) 
            return true;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
            return false;

        boolean isLeftFullBinaryTree = isFullBinaryTree(root.left);
        boolean isRightFullBinaryTree = isFullBinaryTree(root.right);

        return (isLeftFullBinaryTree && isRightFullBinaryTree);
    }

    public static boolean isCompleteBinaryTree(TreeNode root, int index, int numberOfNodes) {
        if (root == null)
            return true;

        if (index >= numberOfNodes)
            return false;

        boolean isLeftCompleteBinaryTree = isCompleteBinaryTree(root.left, 2*index + 1, numberOfNodes);
        boolean isRightCompleteBinaryTree = isCompleteBinaryTree(root.right, 2*index + 2, numberOfNodes);

        return isLeftCompleteBinaryTree && isRightCompleteBinaryTree;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(8);
        // root.right.right.right = new TreeNode(9); // uncommenting will make it full binary tree

        System.out.println(isFullBinaryTree(root));
        System.out.println(isCompleteBinaryTree(root, 0, countNodes(root)));
    }
}