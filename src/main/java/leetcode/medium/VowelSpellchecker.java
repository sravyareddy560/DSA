package leetcode.medium;

//https://leetcode.com/problems/vowel-spellchecker/description/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {
    //Time: O(1), Space O(1); C is the total content of wordlist and queries.
    public String[] spellChecker(String[] wordlist, String[] queries){

        String[] res=new String[queries.length];
        Set<String> orig=new HashSet<>();
        Map<String,String> cap=new HashMap<>();
        Map<String,String> vow=new HashMap<>();


        for(String word:wordlist){
            orig.add(word);
            cap.putIfAbsent(word.toLowerCase(),word);
            vow.putIfAbsent(deVowel(word.toLowerCase()),word);
        }
        int k=0;
        for(String qWord:queries){
            String currWord="";
            if(orig.contains(qWord)){
                currWord=qWord;
            }
            else if(cap.containsKey(qWord.toLowerCase())){
                currWord=cap.get(qWord.toLowerCase());
            }
            else if(vow.containsKey(deVowel(qWord.toLowerCase()))){
                currWord=vow.get(deVowel(qWord.toLowerCase()));
            }
            res[k]=currWord;
            k++;
        }


        return res;
    }

    public String deVowel(String word){
        VowelsGame vg=new VowelsGame();
        StringBuilder res=new StringBuilder();
        for(char c:word.toCharArray()){
            res.append(vg.isVowel(c)?'*':c);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        VowelSpellchecker vsc=new VowelSpellchecker();
        String[] res= vsc.spellChecker(new String[]{"KiTe","kite","hare","Hare"},new String[]{"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"});
        System.out.println("Expected Output: kite,KiTe,KiTe,Hare,hare,,,KiTe,,KiTe");
        System.out.print("Actual Output: ");
        for(String s:res){
            System.out.print(s+",");
        }
    }

}


