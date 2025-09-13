package leetcode.medium;

//https://leetcode.com/problems/sort-vowels-in-a-string/description/
public class SortVowelsInString {

//    Approach 2 - Counting sort; Time: O(N), Space: O(1)
    public String sortVowels(String s) {
        int[] count=new int[57];

        for(char c:s.toCharArray()){
            if(isVowel(c)){
                count[c-'A']++;
            }
        }

        String vowels="AEIOUaeiou";
        StringBuilder res= new StringBuilder();
        int n=s.length(), j=0;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(isVowel(c)){
                while(count[vowels.charAt(j)-'A']==0){
                    j++;
                }
                c=vowels.charAt(j);
                count[vowels.charAt(j)-'A']--;
            }
            res.append(c);
        }
        return new String(res);
    }


//    Approach 1 - Sorting; Time: O(NlogN), Space: O(N)
//    public static String svs.sortVowels(String s) {
//        List<Character> vowels=new ArrayList<>();
//
//        for(char c:s.toCharArray()){
//            if(isVowel(c)){
//                vowels.add(c);
//            }
//        }
//
//        Collections.sort(vowels);
//
//        StringBuilder res=new StringBuilder();
//        int n=s.length();
//        for(int i=0;i<n;i++){
//            char c=s.charAt(i);
//            if(isVowel(c)){
//                c=vowels.get(0);
//                vowels.remove(0);
//            }
//            res.append(c);
//        }
//        return new String(res);
//
//    }
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }

    public static void main(String[] args) {
        SortVowelsInString svs = new SortVowelsInString();
        System.out.println(svs.sortVowels("uZcPmqAd"));
        System.out.println(svs.sortVowels("lEetcOde"));
        System.out.println(svs.sortVowels("lYmpH"));
        System.out.println(svs.sortVowels("a"));
        System.out.println(svs.sortVowels("aA"));
        System.out.println(svs.sortVowels("abA"));
    }
}
