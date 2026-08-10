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
        ListNode res = new ListNode(0);
        ListNode p = res;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = 0 + carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;// ex 18 hai toh 1 mil jayega carry ko 
            sum = sum % 10; // isse 8 mil jayega sum ko
            p.next = new ListNode(sum);// 8 ko next node m store krwalenge
            p = p.next;//p ko next pr point krwa denge 
        }
        if(carry == 1) p.next = new ListNode(1);//agar last m ek carry bach rha h toh usse ek aur node bana kr add krlo 
        return res.next;//res . next isiliye kyuki 1st node hamari 0 se initialised hai shuru m krd thi 
    }
}