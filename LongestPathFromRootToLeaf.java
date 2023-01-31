import java.util.*;

public class LongestPathFromRootToLeaf {
    public static ArrayList<Integer> getLongestPath(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.data);

        ArrayList<Integer> leftPath = getLongestPath(root.left);
        ArrayList<Integer> rightPath = getLongestPath(root.right);

        ArrayList<Integer> result = getMax(leftPath, rightPath);

        if (result != null) {
            path.addAll(result);
        }

        return path;
    }

    private static ArrayList<Integer> getMax(ArrayList<Integer> leftPath, ArrayList<Integer> rightPath) {
        if (leftPath == null) {
            return rightPath;
        }
        if (leftPath.size() == 0 && rightPath.size() == 0) {
            return null;
        }

        if (rightPath == null) {
            return leftPath;
        }

        return (leftPath.size() > rightPath.size()) ? leftPath : rightPath;
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
        root.right.right.right = new TreeNode(9);


        ArrayList<Integer> longestPath = getLongestPath(root);
        System.out.println(longestPath.toString());
    }
}