package list.num876;

import list.ListNode;


/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleNode {

    /** 快指针的行走速度时慢指针的二倍，当快指针到末尾时，慢指针正好到中间，依旧需要注意null */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            // fast 指针每进行一次前进时，都需要执行空判断
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
