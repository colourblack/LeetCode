package another.num110;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return -1 != depth(root);
    }

    int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        if (left == -1) {
            return -1;
        }
        int right =  depth(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

//    方法二：
//    boolean flag = true;
//    public boolean isBalanced(TreeNode root) {
//        return -1 != depth(root);
//    }
//    int postSearch(TreeNode root) {
//        if (root == null || flag == false) {
//            return 0;
//        }
//        int left = postSearch(root.left);
//        int right = postSearch(root.right);
//        if (Math.abs(left-right) > 1) {
//            flag = false;
//        }
//        return Math.max(left, right) +1;
//    }
}
