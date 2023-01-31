import java.util.*;

public class ZigZagTraversal {
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.addFirst(root);

        boolean leftToRight = true;
        List<Integer> currentLevelDatalist = null;

        while (!dq.isEmpty()) {
            currentLevelDatalist = new ArrayList<>();
            int size = dq.size();
            while (size > 0) {
                if (leftToRight) {
                    TreeNode currentNode = dq.removeFirst();
                    currentLevelDatalist.add(currentNode.data);

                    if (currentNode.left != null) {
                        dq.addFirst(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        dq.addFirst(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = dq.removeLast();
                    currentLevelDatalist.add(currentNode.data);


                    if (currentNode.right != null) {
                        dq.addLast(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        dq.addLast(currentNode.left);
                    }
                }
                size--;
            }
            leftToRight = !leftToRight;
            resultList.add(currentLevelDatalist);
        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);

        List<List<Integer>> ls = levelOrderTraversal(root);
        System.out.println(ls);
    }
}
