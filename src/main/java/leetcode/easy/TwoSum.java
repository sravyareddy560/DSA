package leetcode.easy;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    //    Optimized Approach; Time: O(n), Space: O(n)
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(!map.isEmpty() && map.containsKey(curr)){
                return new int[]{map.get(curr),i};
            }
            map.putIfAbsent(target-curr,i);
        }

        return new int[]{};
    }

//    Time: O(n^2), Space: O(1)
//    public int[] twoSum(int[] nums,int target){
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//
//        return new int[]{};
//    }

    public static void main(String[] args) {
        TwoSum ts=new TwoSum();
        int res[]=ts.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("Expected= [0,1], Actual= ["+res[0]+","+res[1]+"]");

        res=ts.twoSum(new int[]{3,2,4}, 6);
        System.out.println("Expected= [1,2], Actual= ["+res[0]+","+res[1]+"]");
    }
}
