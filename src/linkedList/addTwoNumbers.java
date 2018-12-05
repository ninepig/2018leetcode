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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int digit = 0;
            if(l1!=null){
                digit = digit+l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                digit = digit+l2.val;
                l2 = l2.next;
            }
            int reminder = (digit+carry)%10;
            carry = (digit+carry)/10;
            head.next = new ListNode(reminder);
            head = head.next;
        }
        if(carry!=0){
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
