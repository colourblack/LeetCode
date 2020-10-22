package another.num173;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator {

    private List<Integer> list;
    private Iterator<Integer> iterator;
    private int index = -1;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        iterator = list.iterator();
    }

    /** @return the next smallest number */
    public int next() {
//        if (hasNext()) {
//            index++;
//            return list.get(index);
//        } else {
//            return 0;
//        }
        return iterator.next();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
//        if (list.size() == 0) {
//            return false;
//        }
//
//        if (index < list.size() - 1) {
//            return true;
//        } else {
//            return false;
//        }
        return iterator.hasNext();
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }

}
