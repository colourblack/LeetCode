package another.num617;



/**
 * @author FANG
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /**
         * 当节点t1或者t2为空时，直接返回另一颗书的节点即可（该节点的所有子节点同时保留不变）
         */
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
