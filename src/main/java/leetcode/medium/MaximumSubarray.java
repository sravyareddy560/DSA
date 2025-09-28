package leetcode.medium;

//https://leetcode.com/problems/maximum-subarray/description/

public class MaximumSubarray {
//    Time Complexity: O(n), Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        int totalSum=Integer.MIN_VALUE,sum=0;
        for(int n:nums){
            sum+=n;
            totalSum=Math.max(totalSum,sum);
            sum=Math.max(sum,0);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        MaximumSubarray ms=new MaximumSubarray();
        System.out.println("Expected= 6,Actual= "+ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println("Expected= 1,Actual= "+ms.maxSubArray(new int[]{1}));
        System.out.println("Expected= 23,Actual= "+ms.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
