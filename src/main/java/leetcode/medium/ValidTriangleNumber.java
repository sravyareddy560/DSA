package leetcode.medium;

//https://leetcode.com/problems/valid-triangle-number/
import java.util.Arrays;

public class ValidTriangleNumber {
//    Time: O(n^2), Space: O(1)
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                continue;
            }
            for(int j=i+1;j<n-1;j++){
                int k=j+1;
                while(k<n && nums[i]+nums[j]>nums[k]){
                    k++;
                }
                res+=k-j-1;
            }
        }
        return res;
    }
//    Time: O(n^3), Space: O(1)
//    public int triangleNumber(int[] nums) {
//        int n=nums.length;
//        int res=0;
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                for(int k=j+1;k<n;k++){
//                    if((nums[i]+nums[j]>nums[k]) && nums[i]+nums[k]>nums[j] && nums[k]+nums[j]>nums[i]){
//                        res++;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        ValidTriangleNumber vtn=new ValidTriangleNumber();
        System.out.println("Expected= 3, Actual= "+vtn.triangleNumber(new int[]{2,2,3,4}));
        System.out.println("Expected= 4, Actual= "+vtn.triangleNumber(new int[]{4,2,3,4}));
        System.out.println("Expected= 19, Actual= "+vtn.triangleNumber(new int[]{48,66,61,46,94,75}));
    }
}
