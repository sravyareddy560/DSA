package leetcode.easy;

//https://leetcode.com/problems/valid-anagram/description/
import java.sql.Time;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
//    Optimized Approach; Time Complexity: O(n); Space Complexity: O(1)
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int value:count){
            if(value!=0)
                return false;
        }
        return true;
    }

    //    Time Complexity: O(n); Space Complexity: O(1)
//    public boolean isAnagram(String s, String t) {
//        Map<Character,Integer> map = new HashMap<>();
//
//
//        for(char c:s.toCharArray()){
//            map.put(c, map.getOrDefault(c,0)+1);
//        }
//
//        for(char c:t.toCharArray()){
//            map.put(c, map.getOrDefault(c,0)-1);
//
//        }
//
//        for(int value:map.values()){
//            if(value!=0)
//                return false;
//        }
//        return true;
//    }

//    Time Complexity: O(nlogn), Space Complexity: O(n)
//    public boolean isAnagram(String s, String t) {
//        char[] sChar = s.toCharArray();
//        char[] tChar = t.toCharArray();
//        Arrays.sort(sChar);
//        Arrays.sort(tChar);
//        return Arrays.equals(sChar,tChar);
//    }

    public static void main(String[] args) {
        ValidAnagram va=new ValidAnagram();
        System.out.println("Expected= true, Actual= "+va.isAnagram("anagram", "nagaram"));
        System.out.println("Expected= false, Actual= "+va.isAnagram("rat", "car"));
    }
}
