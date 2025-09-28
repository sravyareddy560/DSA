package leetcode.easy;
//https://leetcode.com/problems/largest-perimeter-triangle/description/

import java.util.Arrays;

public class LargestPerimeterTriangle {
//    Time: O(nlogn), Space: O(1)
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-3;i>=0;i--){
            if(nums[i]+nums[i+1]>nums[i+2]){
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LargestPerimeterTriangle lpt=new LargestPerimeterTriangle();
        System.out.println("Expected= 0, Actual= "+lpt.largestPerimeter(new int[]{1,2,1,10}));
        System.out.println("Expected= 5, Actual= "+lpt.largestPerimeter(new int[]{1,2,2}));
        System.out.println("Expected= 0, Actual= "+lpt.largestPerimeter(new int[]{1}));
    }
}
