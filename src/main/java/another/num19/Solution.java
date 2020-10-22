package another.num19;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index = head;
        ListNode node = head;
        int i = 0;
        while (i < n) {
            index = index.next;
            i++;
        }
        if (index == null) {
            return head.next;
        }
        while (index.next != null) {
            node = node.next;
            index = index.next;
        }
        node.next = node.next.next;
        return head;
    }
}
