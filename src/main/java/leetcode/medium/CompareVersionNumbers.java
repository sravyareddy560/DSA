package leetcode.medium;
//https://leetcode.com/problems/compare-version-numbers/

import java.sql.Time;

public class CompareVersionNumbers {
//    Time: O(n), Space: O(n)
    public int compareVersion(String version1, String version2) {
        String[] v1= version1.split("\\.");
        String[] v2= version2.split("\\.");

        int maxLen=Math.max(v1.length,v2.length);

        for(int i=0;i<maxLen;i++){
            int num1=i>=v1.length?0:Integer.parseInt(v1[i]);
            int num2=i>=v2.length?0:Integer.parseInt(v2[i]);
            if(num1<num2){
                return -1;
            }
            if(num1>num2){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers cvn=new CompareVersionNumbers();
        System.out.println("Expected= -1, Actual= "+cvn.compareVersion("1.2","1.10"));
        System.out.println("Expected= 0, Actual= "+cvn.compareVersion("1.01","1.001"));
        System.out.println("Expected= 0, Actual= "+cvn.compareVersion("1.0","1.0.0.0"));
    }
}
