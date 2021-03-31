package list;

/**
 * @author fang
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode head = this;
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val).append(" ");
            head = head.next;
        }
        return builder.toString();
    }
}
