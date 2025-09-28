package leetcode.easy;
public class MaxFrequencyElements {
//    Time: O(n), Space: O(1)
    public int maxFrequencyElements(int[] nums) {
        int maxFreq=0, res=0;
        int[] count=new int[100];

        for(int num:nums){
            count[num-1]++;
            int currFreq=count[num-1];

            if(currFreq>maxFreq){
                maxFreq=currFreq;
                res=currFreq;
            }
            else if(currFreq==maxFreq){
                res+=currFreq;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxFrequencyElements mfe=new MaxFrequencyElements();
        System.out.println("Expected= 4, Actual ="+mfe.maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        System.out.println("Expected= 5, Actual ="+mfe.maxFrequencyElements(new int[]{1,2,3,4,5}));
    }
}
