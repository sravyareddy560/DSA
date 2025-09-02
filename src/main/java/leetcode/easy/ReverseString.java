package leetcode.easy;

//    https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void main(String[] args) {
        reverseString(new char[]{'h'});
        reverseString(new char[]{'h','e','l','l','o'});

        reverseString(null);
        reverseString(new char[0]);
//        reverseString(new char[]{});

    }
    public static void reverseString(char[] s) {
//        Time: O(n), Space: O(1)
        if(s==null || s.length==0)
            return;

        int i=0,j=s.length-1;

        while(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }

//        for(char c:s){
//            System.out.print(c+" ");
//        }
    }
}
