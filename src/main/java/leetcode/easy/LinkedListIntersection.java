package leetcode.easy;
import leetcode.common.ListNode;
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;

        ListNode hA=headA;
        ListNode hB=headB;

        while(hA!=hB){
            hA=hA.next==null?headB:hA.next;
            hB=hB.next==null?headA:hB.next;
        }
        return hA;
    }

    public static void main(String[] args) {
        ListNode listA = buildList(new int[]{1, 9, 1});
        ListNode listB = buildList(new int[]{3});

        // Shared part
        ListNode shared = buildList(new int[]{2, 4});

        // Attach shared part
        ListNode temp = listA;
        while (temp.next != null) temp = temp.next;
        temp.next = shared;

        listB.next = shared;

        LinkedListIntersection lli = new LinkedListIntersection();
        ListNode intersection = lli.getIntersectionNode(listA, listB);
        System.out.println(intersection != null ? intersection.val : "No intersection");
    }

    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
