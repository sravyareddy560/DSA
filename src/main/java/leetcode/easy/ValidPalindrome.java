package leetcode.easy;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public static void main(String[] args) {
        //Expected-true
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome(" "));

        //Expected-False
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s){
//        Approach 1-using string builder; Time: O(n), Space: O(1)
        int i=0,j=s.length()-1;
        while(i<j){
            while(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;


//        Approach 2-using string methods; Time: O(n), Space: O(n)
//        String str="";
//        for(char c:s.toCharArray()){
//            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
//                str+=c;
//            }
//        }
//        String reversedStr="";
//        for(int i=str.length()-1;i>=0;i--){
//            reversedStr+=str.charAt(i);
//        }
//        return str.equalsIgnoreCase(reversedStr);
    }
}

