package list.num206;


import list.ListNode;

/**
 * Reverse a singly linked list.
 * Example:
 *      Input: 1->2->3->4->5->NULL
 *      Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively.
 *
 */
public class ReverseList {

    /**
     * recursive 递归
     * 链表中，最为关键的一个点在于，最后一个next才是表达式所指
     * 例如： 1->2->3->4->5->null
     * 对于4号节点，node.next.next = node
     * 实际上是 5->4
     * 也就是说，这行代码的作用在于改变了 第5个节点的下一个指向
     * 而此时 4依旧指向5，所以这出现了两个节点循环指向的现象
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    /** iterative 迭代 */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
