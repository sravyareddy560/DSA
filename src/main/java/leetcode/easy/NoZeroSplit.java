package leetcode.easy;


//https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
public class NoZeroSplit {

    public static void main(String[] args) {
        int[] res=getNoZeroIntegers(1109);
        for(int r:res) {
            System.out.print(r+", ");
        }

    }

    //        Approach 2; Time: O(log n),Space: O(1)
    public static int[] getNoZeroIntegers(int n) {

        int a = 0, b = 0, digitIndex = 1;

        while (n > 0) {
            int d = n % 10;
            n = n / 10;

            if ((d == 0 || d == 1) && n > 0) {
                d = d + 10;
                n = n - 1;
            }

            int da = d / 2;
            int db = d - da;
            a = a + (da * digitIndex);
            b = b + (db * digitIndex);

            digitIndex *= 10;
        }
        return new int[]{a, b};
    }


    //        Approach 1; Time: O(n × d), Space: O(1); Where d is the number of digits in n.
//    public static int[] getNoZeroIntegers(int n) {
//        int i=1;
//        while(i<=n/2){
//            if(!hasZero(i) && !hasZero(n-i)){
//                return new int[]{i,n-i};
//            }
//            i++;
//        }
//        return new int[]{};
//    }
//    public static boolean hasZero(int n){
//        while(n>0){
//            if(n%10==0){
//                return true;
//            }
//            n/=10;
//        }
//        return false;
//    }


}
