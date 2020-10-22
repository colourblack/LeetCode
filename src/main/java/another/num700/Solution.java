package another.num700;

class Solution {
    TreeNode result = null;
    int value = 0;
    public TreeNode searchBST(TreeNode root, int val) {
        value = val;
        orderByMid(root);
        return result;
    }

    public void orderByMid(TreeNode node){
        if(node != null){
            orderByMid(node.left);
            if(node.val == value){
                result = node;
                return ;
            }
            orderByMid(node.right);
        }
    }
}
