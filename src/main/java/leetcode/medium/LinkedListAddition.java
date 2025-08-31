package leetcode.medium;

import leetcode.common.ListNode;

public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        https://leetcode.com/problems/add-two-numbers/description/
//        Time: O(max(m, n)),Space: O(max(m, n))
        ListNode t1=l1,t2=l2;
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        int rem=0;

        while(t1!=null || t2!=null || rem!=0){
            int val=0;
            if(t1!=null){
                val+=t1.val;
                t1=t1.next;
            }
            if(t2!=null){
                val+=t2.val;
                t2=t2.next;
            }
            val+=rem;
            rem=val/10;
            cur.next=new ListNode(val%10);
            cur=cur.next;

        }
        return res.next;
    }
    public static void main(String[] args){
        LinkedListAddition obj = new LinkedListAddition();

        // ---- Test Case 1: Normal case (342 + 465 = 807) ----
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = obj.addTwoNumbers(l1, l2);
        System.out.print("Test1 Output: ");
        while(result != null){ System.out.print(result.val + " "); result = result.next; }
        System.out.println(); // Expected: 7 0 8

        // ---- Test Case 2: Different lengths (99 + 1 = 100) ----
        l1 = new ListNode(9, new ListNode(9));
        l2 = new ListNode(1);
        result = obj.addTwoNumbers(l1, l2);
        System.out.print("Test2 Output: ");
        while(result != null){ System.out.print(result.val + " "); result = result.next; }
        System.out.println(); // Expected: 0 0 1

        // ---- Test Case 3: Carry all the way (999 + 1 = 1000) ----
        l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        l2 = new ListNode(1);
        result = obj.addTwoNumbers(l1, l2);
        System.out.print("Test3 Output: ");
        while(result != null){ System.out.print(result.val + " "); result = result.next; }
        System.out.println(); // Expected: 0 0 0 1

        // ---- Test Case 4: One list is zero (0 + 73 = 73) ----
        l1 = new ListNode(0);
        l2 = new ListNode(7, new ListNode(3));
        result = obj.addTwoNumbers(l1, l2);
        System.out.print("Test4 Output: ");
        while(result != null){ System.out.print(result.val + " "); result = result.next; }
        System.out.println(); // Expected: 7 3

        // ---- Test Case 5: Single digit each (5 + 5 = 10) ----
        l1 = new ListNode(5);
        l2 = new ListNode(5);
        result = obj.addTwoNumbers(l1, l2);
        System.out.print("Test5 Output: ");
        while(result != null){ System.out.print(result.val + " "); result = result.next; }
        System.out.println(); // Expected: 0 1

        // ---- Test Case 6: Stress test (100 digits of 9 + 100 digits of 9) ----
        ListNode big1 = new ListNode(9);
        ListNode cur = big1;
        for(int i=1;i<100;i++){ cur.next = new ListNode(9); cur = cur.next; }

        ListNode big2 = new ListNode(9);
        cur = big2;
        for(int i=1;i<100;i++){ cur.next = new ListNode(9); cur = cur.next; }

        result = obj.addTwoNumbers(big1, big2);
        System.out.print("Test6 Output (first few digits): ");
        int count=0;
        while(result != null && count<15){ // only print first 15 digits
            System.out.print(result.val + " ");
            result = result.next;
            count++;
        }
        System.out.println("..."); // Expected total length = 101
    }
}

