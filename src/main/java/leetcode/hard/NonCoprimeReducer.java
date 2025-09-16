package leetcode.hard;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/
public class NonCoprimeReducer {

//    Approach 2-Stack; Time: O(nlogM), Space: O(n); n is the number of elements in the list and M is the largest number.
    public List<Integer> replaceNonCoprimes(int[] nums){
        List<Integer> res=new ArrayList<>();

        for(int num:nums){
            int a=num;
            while(!res.isEmpty()){
                int b=res.getLast();
                int gcd=GCDCalculator(a,b);
                if(gcd>1){
                    a=(a/gcd)*b;
                    res.removeLast();
                }
                else{
                    break;
                }
            }
            res.add(a);
        }

        return res;
    }

//    Approach 1; Time: O(n² · log(max(nums))), Space: O(n)
//    public List<Integer> replaceNonCoprimes(int[] nums){
//
//        List<Integer> res =new ArrayList<>();
//
//        for(int num:nums){
//            res.add(num);
//        }
//
//        int i=0;
//
//        while(i< res.size()-1){
//            int a=res.get(i), b=res.get(i+1);
//            int gcd=GCDCalculator(a,b);
//            if(gcd>1){
//                res.remove(i+1);
//                res.set(i, ((a)/gcd)*b);
//                if(i!=0){
//                    i--;
//                }
//            }
//            else{
//                i++;
//            }
//        }
//
//        return res;
//    }

    public int GCDCalculator(int a,int b){
        if(b==0) {
            return a;
        }
        return GCDCalculator(b,a%b );
    }

    public static void main(String[] args) {
        NonCoprimeReducer ncr=new NonCoprimeReducer();
        System.out.println("Expected Output= [1,2,3,4,5], Actual Output= "+ncr.replaceNonCoprimes(new int[]{1,2,3,4,5}));
        System.out.println("Expected Output= [12,7,6], Actual Output= "+ncr.replaceNonCoprimes(new int[]{6,4,3,2,7,6,2}));
        System.out.println("Expected Output= [2,1,1,3], Actual Output= "+ncr.replaceNonCoprimes(new int[]{2,2,1,1,3,3,3}));
        System.out.println("Expected Output= [31,97561], Actual Output= "+ncr.replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561}));
        System.out.println("Expected Output= [2009,20677,825], Actual Output= "+ncr.replaceNonCoprimes(new int[]{287,41,49,287,899,23,23,20677,5,825}));
    }
}

