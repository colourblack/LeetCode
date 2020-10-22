package another.num445;


import java.util.Stack;

public class test {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode m1 = new ListNode(6);
        ListNode m2 = new ListNode(4);

        l1.next = n1;
        n1.next = n2;
        n2.next = n3;

        l2.next = m1;
        m1.next = m2;

        ListNode ls = l1;
        while (ls != null) {
            System.out.print(ls.val + " ");
            ls = ls.next;
        }
        System.out.println();
        ls = l2;
        while (ls != null) {
            System.out.print(ls.val + " ");
            ls = ls.next;
        }


    }

}
