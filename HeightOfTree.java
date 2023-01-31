public class HeightOfTree {
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int finalHeight = Math.max(leftHeight, rightHeight) + 1;
        return finalHeight;
    }

    static int max_diameter = 0;
    public static int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        max_diameter = Math.max(1 + leftHeight + rightHeight, max_diameter);

        int finalHeight = Math.max(leftHeight, rightHeight) + 1;
        return finalHeight;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println(getHeight(root));
        System.out.println(getDiameter(root));
    }
}
