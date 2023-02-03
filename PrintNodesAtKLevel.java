public class PrintNodesAtKLevel {
    public static void printNodesAtLevelK(TreeNode root, int k) {
        if (root == null) return;

        if (k == 1) {
            System.out.print(root.data + " ");
            return;
        }

        printNodesAtLevelK(root.left, k - 1);
        printNodesAtLevelK(root.right, k - 1);
    }

    public static void main(String[] args) {
        // tree goes here
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printNodesAtLevelK(root, 3);
    }
}
