package leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args){
        charFrequency(null);
        charFrequency("");
        charFrequency("leetcode");

    }
    public static void charFrequency(String s) {
        if(s==null)
            return;

        //Approach 1-using hashmap
//        Map<Character, Integer> map=new HashMap<>();
//
//        for(char c: s.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//
//        for(Map.Entry<Character, Integer> entry:map.entrySet()){
//            System.out.println(entry.getKey()+"," +entry.getValue());
//        }

        //Approach 2-using array
//        int[] arr=new int[26];
//
//        for(char c:s.toCharArray()){
//            arr[c-'a']++;
//        }
//
//        for(int i=0;i<26;i++){
//            if(arr[i]>0)
//            System.out.println((char)(i+'a')+", "+arr[i]);
//        }

        //Approach 3-using linkedhashmap - maintain insertion order
        Map<Character, Integer> map=new LinkedHashMap<>();

        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+"," +entry.getValue());
        }


    }
}
