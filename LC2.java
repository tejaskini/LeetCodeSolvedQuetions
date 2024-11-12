/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/
//------------------------ Solution -------------------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1 == null ){
            return l2 ;
        }else if ( l2 == null){
            return l1 ;
        }

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy ;
        ListNode ptr1 = l1 ;
        ListNode ptr2 = l2 ;

        int carry = 0 ;

        while(ptr1!=null || ptr2!=null){
            int val1 = ptr1!=null? ptr1.val : 0;
            int val2 = ptr2!=null? ptr2.val : 0 ;
            int sum = val1 + val2 + carry ;
            int d = sum%10 ;
            carry = sum/10 ;

            ListNode temp = new ListNode(d);

            dummy.next = temp ;
            dummy = dummy.next ;

            ptr1 = ptr1!=null ? ptr1.next : null;
            ptr2 = ptr2!=null ? ptr2.next : null;
        }

        if(carry>0){
             ListNode temp = new ListNode(carry);
            dummy.next = temp ;
            dummy = dummy.next ;
        }
        return ans.next;
    }
}
