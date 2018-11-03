package linkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 链表相加，非常基础。 dummy Node
 * 但是用的方法要考虑好。
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int carry = 0 ;

        while(l1!=null && l2 != null){
            int digit = (l1.val+l2.val+carry)%10;
            carry = (l1.val+l2.val+carry)/10;
            pre.next = new ListNode(digit);
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }

        while (l1!=null){
            int digit = (l1.val+carry)%10;
            carry = (l1.val+carry)/10;
            pre.next = new ListNode(digit);
            l1 = l1.next;
            pre = pre.next;
        }

        while (l2!=null){
            int digit = (l2.val+carry)%10;
            carry = (l2.val+carry)/10;
            pre.next = new ListNode(digit);
            l2 = l2.next;
            pre = pre.next;
        }

        if(carry!=0){
            pre.next = new ListNode(carry);
        }
        return dummy.next;
    }

    // Better way!
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
