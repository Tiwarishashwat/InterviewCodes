class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev = null;
        while(cur!=null)
        {
            ListNode newNext = cur.next;
            cur.next = prev;
            prev=cur;
            cur=newNext;
        }
        head = prev;
        return head;
    }
}
