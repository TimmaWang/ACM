/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sizeA = listSize(headA);
        int sizeB = listSize(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        if(sizeA > sizeB) {
            
            int intervA = sizeA-sizeB;
            while(intervA > 0) {
                curA = curA.next;
                intervA--;
            }
        } else {

            int intervB = sizeB-sizeA;
            while(intervB > 0) {
                curB = curB.next;
                intervB--;
            }
        }

        while(!(null == curA || null == curB)) {

            if(curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
        
    }

    public int listSize(ListNode node) {
        int size = 0;
        ListNode cur = node;
        while(null != cur) {
            size++;
            cur = cur.next;
        }

        return size;
    }
}