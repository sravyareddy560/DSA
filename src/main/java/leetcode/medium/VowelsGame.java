package leetcode.medium;
//https://leetcode.com/problems/vowels-game-in-a-string/description/
public class VowelsGame {
    public static void main(String[] args) {
        VowelsGame vg = new VowelsGame();
        System.out.println(vg.doesAliceWin("leetcoder"));
        System.out.println(vg.doesAliceWin("a"));
        System.out.println(vg.doesAliceWin("leetcodr"));

        System.out.println(vg.doesAliceWin("b"));
        System.out.println(vg.doesAliceWin("bbbb"));
    }
    public boolean doesAliceWin(String s) {
//        Time: O(n), Space: O(1)

//        return s.chars().anyMatch(c -> {return "aeiou".indexOf(c)!=-1;});

        for(char c:s.toCharArray()){
            if(isVowel(c)){
                return true;
            }
        }
        return false;
    }

    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ;
    }
}
