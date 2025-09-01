package leetcode.easy;

import leetcode.common.ListNode;
import leetcode.medium.LinkedListAddition;

public class PalindromeLinkedList {
    public static void main(String[] args) {

        //Expected: true
        ListNode l1 = new ListNode(1);
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(1,new ListNode(1));
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(2, new ListNode(4, new ListNode(2)));
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(1, new ListNode(2, new ListNode(2,new ListNode(1))));
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(2,new ListNode(1)))));
        System.out.println(isPalindrome(l1));

        System.out.println();

        //Expected: false
        l1 = new ListNode(1,new ListNode(7));
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(1))));
        System.out.println(isPalindrome(l1));
        l1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(2,new ListNode(9)))));
        System.out.println(isPalindrome(l1));
    }
    public static boolean isPalindrome(ListNode head) {
        //Approach 2: optimized; Time: O(n) ,Space: O(1)
        ListNode slow=head,fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow.next,prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        curr=head;
        while(prev!=null){
            if(prev.val!=curr.val){
                return false;
            }
            prev=prev.next;
            curr=curr.next;
        }
        return true;

        //Approach 1: using array; Time: O(n) ,Space: O(n)
//        if(head.next==null)
//            return true;
//        int[] arr=new int[100000];
//        int size=0;
//        ListNode temp=head;
//
//        while(temp!=null){
//            arr[size++]=temp.val;
//            temp=temp.next;
//        }
//        int i=0;
//        while(i<size){
//            if(arr[i]!=arr[--size]){
//                return false;
//            }
//            i++;
//        }
//        return true;
    }
}
