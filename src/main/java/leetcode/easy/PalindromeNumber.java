package leetcode.easy;
//https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(3223));
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(0));

        System.out.println(isPalindrome(-3223));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x){
//        Time: O(log₁₀(n)),Space: O(1)
        if(x<0)
            return false;

        int reversedX=0, tempX=x;

        while(tempX!=0){
            reversedX=reversedX*10+tempX%10;
            tempX/=10;
        }
        return reversedX==x;
    }
}
