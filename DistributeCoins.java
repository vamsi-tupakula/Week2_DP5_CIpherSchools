public class DistributeCoins {
    static int numberOfMoves = 0;

    public static int distributeCoins(TreeNode root) {
        helper(root);

        return numberOfMoves;
    }

    private static int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int coinsAvailable = left + right + root.data - 1;;

        numberOfMoves += Math.abs(left) + Math.abs(right);

        return coinsAvailable;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        System.out.println(distributeCoins(root));
    }
}
