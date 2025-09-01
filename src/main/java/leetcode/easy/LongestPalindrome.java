package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd")); //Expected: 7
        System.out.println(longestPalindrome("a")); //Expected: 1

        System.out.println(longestPalindrome("abcc9ccdd")); //Expected: 7
        System.out.println(longestPalindrome("a1bccccd1d")); //Expected: 9
    }
    public static int longestPalindrome(String s) {

        //Approach 2-using array; Time: O(n),Space:O(1)
//        int[] arr=new int[52];
//
//        for(char c:s.toCharArray()){
//            if(c>='a' && c<='z'){
//                arr[c-'a']++;
//            }
//            else if(c>='A' && c<='Z'){
//                arr[c-'A'+26]++;
//            }
//        }
//        int res=0;
//        boolean hasOdd=false;
//        for(int i=0;i<52;i++){
//            if(arr[i]%2==0){
//                res+=arr[i];
//            }
//            else{
//                hasOdd=true;
//                res+=arr[i]-1;
//            }
//        }
//        return res+(hasOdd?1:0);

        //Approach 3-using array, accepts digits; Time: O(n),Space:O(1)
        int[] arr=new int[62];

        for(char c:s.toCharArray()){
            if(c>='a' && c<='z'){
                arr[c-'a'+10]++;
            }
            else if(c>='A' && c<='Z'){
                arr[c-'A'+36]++;
            }
            else if(c>='0' &&c<='9'){
                arr[c-'0']++;
            }
        }
        int res=0;
        boolean hasOdd=false;
        for(int i=0;i<62;i++){
            if(arr[i]%2==0){
                res+=arr[i];
            }
            else{
                hasOdd=true;
                res+=arr[i]-1;
            }
        }
        return res+(hasOdd?1:0);


        //Approach 1-using hashmap; Time: O(n),Space:O(k) K=unique characters
//        Map<Character,Integer> map=new HashMap<>();
//        for(char c:s.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        int res=0;
//        boolean hasOdd=false;
//        for(int val:map.values()){
//            if(val%2==0){
//                res+= val;
//            }
//            else{
//                hasOdd=true;
//                res+=val-1;
//            }
//        }
//        return hasOdd?res+1:res;
    }
}
