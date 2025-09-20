package leetcode.easy;

//https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/
public class MinimumDistanceBetweenOnes {
    public boolean kLengthApart(int[] nums, int k) {
//        Time Complexity: O(n), Space Complexity: O(1)
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(prev!=-1 && i-prev<=k){
                    return false;
                }
                prev=i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenOnes mdbo=new MinimumDistanceBetweenOnes();
        System.out.println("Expected= true, Actual= "+mdbo.kLengthApart(new int[]{1,0,0,0,1,0,0,1},2));
        System.out.println("Expected= false, Actual= "+mdbo.kLengthApart(new int[]{1,0,0,1,0,1},2));

    }
}
