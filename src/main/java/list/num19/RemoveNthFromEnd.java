package list.num19;

import list.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 * 给定的 n 保证是有效的。
 * 示例：
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {

    /** 典型的快慢指针遍历问题，让快指针和慢指针的node差为n即可解决问题，注意null的处理*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        // 保证 fast - slow = n
        while (i < n) {
            fast = fast.next;
            i++;
        }
        // if：n == length of list
        // return head.next
        if (fast == null) {
            return head.next;
        }
        // 因为需要做remove，所以记录一个pre指针便于进行remove操作
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (fast != null) {
            prev = prev.next;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
