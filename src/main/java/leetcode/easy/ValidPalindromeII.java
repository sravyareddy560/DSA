package leetcode.easy;

//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("a"));
        System.out.println(validPalindrome("ab"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("bba"));
        System.out.println(validPalindrome("abb"));
        System.out.println(validPalindrome("abba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abcdba"));

        System.out.println();


        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("abbadd"));
    }
    public static boolean validPalindrome(String s) {
        //Time: O(n), Space: O(1)
        if(s==null)
            return false;
        if(s.length()<=2)
            return true;

        int i=0,j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return (isPalindrome(s, i+1, j) || isPalindrome(s,i,j-1));
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right){
        while (left < right) {
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

