class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            head = temp;
            prev = head;
        }
        return 
    }
}
