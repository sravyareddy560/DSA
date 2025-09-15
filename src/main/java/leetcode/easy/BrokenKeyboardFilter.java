package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class BrokenKeyboardFilter {
    //Approach 2-using hashset; Time: O(n), Space: O(n)
    public int canBeTypedWords(String text, String brokenLetters){
        int result=0;

        Set<Character> brokenLettersSet=new HashSet<>();

        for(char c:brokenLetters.toCharArray()){
            brokenLettersSet.add(c);
        }

        for(String s:text.split(" ")){
            result++;
            for(char c:s.toCharArray()){
                if(brokenLettersSet.contains(c)){
                    result--;
                    break;
                }
            }
        }

        return result;
    }

    //Approach 1-using array; Time: O(n), Space: O(n)
//    public int canBeTypedWords(String text, String brokenLetters){
//        int result=0;
//
//        int[] brokenLettersArray=new int[26];
//
//        for(char c:brokenLetters.toCharArray()){
//            brokenLettersArray[c-'a']=1;
//        }
//
//        for(String s:text.split(" ")){
//            for(char c:s.toCharArray()){
//                if(brokenLettersArray[c-'a']==1){
//                    result++;
//                    break;
//                }
//            }
//        }
//
//        return text.split(" ").length-result;
//    }

    public static void main(String[] args) {
        BrokenKeyboardFilter bkf=new BrokenKeyboardFilter();
        //Expected output: 0
        System.out.println(bkf.canBeTypedWords("leet code","e"));

        //Expected output: 1
        System.out.println(bkf.canBeTypedWords("hello world","ad"));
        System.out.println(bkf.canBeTypedWords("leet code","lt"));
        System.out.println(bkf.canBeTypedWords("leett code","tz"));
        System.out.println(bkf.canBeTypedWords("leet","zabd"));

        //Expected output: 2
        System.out.println(bkf.canBeTypedWords("leet code",""));
    }
}

