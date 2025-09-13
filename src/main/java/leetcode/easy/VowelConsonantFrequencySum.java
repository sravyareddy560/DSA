package leetcode.easy;
//https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/
public class VowelConsonantFrequencySum {
    public int maxFreqSum(String s) {
        //Time: O(n), Space: O(1)

        int[] count=new int[26];

        for(char c:s.toCharArray()){
            count[c-'a']++;
        }

        int vowel=0,conso=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                if(isVowel(i)){
                    vowel=Math.max(vowel,count[i]);
                }
                else{
                    conso=Math.max(conso,count[i]);
                }
            }
        }
        return conso+vowel;

    }

    public boolean isVowel(int n){
        return n==0 || n==4 || n==8 || n==14 || n==20;
    }

    public static void main(String[] args) {
        VowelConsonantFrequencySum vcfs=new VowelConsonantFrequencySum();
        System.out.println("Input=successes; Expected output=6; Actual output="+vcfs.maxFreqSum("successes"));
        System.out.println("Input=aeiaeia; Expected output=3; Actual output="+vcfs.maxFreqSum("aeiaeia"));
        System.out.println("Input=a; Expected output=1; Actual output="+vcfs.maxFreqSum("a"));
        System.out.println("Input=b; Expected output=1; Actual output="+vcfs.maxFreqSum("b"));
        System.out.println("Input=ab; Expected output=2; Actual output="+vcfs.maxFreqSum("ab"));
    }
}
