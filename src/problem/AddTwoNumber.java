package problem;

/**
 * [2]add two numbers
 * 两个列表相加
 */
public class AddTwoNumber {
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode run = result;
        int sum = 0;
        boolean flag = false;
        while (l1 != null && l2 !=  null)  {
            if(flag){
                sum = l1.val + l2.val + 1;
                flag = false;
            }else{
                sum = l1.val + l2.val;
            }
            if(sum >= 10) {
                sum = sum % 10;
                flag = true;
            }
            ListNode node = new ListNode(sum);
            run.next = node;
            run = run.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if(flag) {
                sum = l1.val + 1;
                flag = false;
            }else{
                sum = l1.val;
            }
            if(sum >= 10) {
                sum = sum % 10;
                flag = true;
            }
            ListNode node = new ListNode(sum);
            run.next = node;
            run = run.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if(flag) {
                sum = l2.val + 1;
                flag = false;
            }else{
                sum = l2.val;
            }
            if(sum >= 10) {
                sum = sum % 10;
                flag = true;
            }
            ListNode node = new ListNode(sum);
            run.next = node;
            run = run.next;
            l2 = l2.next;
        }

        if(flag) {
            run.next = new ListNode(1);
        }
        return result.next;
    }
}
