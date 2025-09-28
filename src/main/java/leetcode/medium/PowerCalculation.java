package leetcode.medium;

import java.sql.Time;

//https://leetcode.com/problems/powx-n/description/
public class PowerCalculation {
//    Time Complexity: O(log n), Space Complexity: O(1)
    public double myPow(double x, int n) {
        long num=n;
        if(num<0){
            num*=-1;
        }
        double res=1;
        while(num>0){
            if(num%2==0){
                x*=x;
                num/=2;
            }
            else{
                res*=x;
                num-=1;
            }
        }
        if(n<0){
            res=1/res;
        }
        return res;
    }

    public static void main(String[] args) {
        PowerCalculation pc=new PowerCalculation();
        System.out.println("Expected = 1024.00000, Actual= "+pc.myPow(2.00000,10));
        System.out.println("Expected = 9.26100, Actual= "+pc.myPow(2.10000,3));
        System.out.println("Expected = 0.25000, Actual= "+pc.myPow(2.00000,-2));
    }
}
