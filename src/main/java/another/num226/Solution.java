package another.num226;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        orderByPreOrder(root);
        return root;
    }
    public void orderByPreOrder(TreeNode node) {
        /**
         * 这里用先序，中序，后序都一样
         */
        if(null != node) {
            orderByPreOrder(node.left);
            orderByPreOrder(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    /**
     * 层序遍历
     */
    public void orderByQueue(TreeNode node) {
        //LinkedList是Queue的实现类
        Queue<TreeNode> queue = new LinkedList<>();
        //往LinkedList中加入元素，若队列已经满了，则返回false
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }
}
