package leetcode.medium;


//https://leetcode.com/problems/gas-station/description/
public class GasStation {
//    Approach 2;Time: O(n),Space: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost){
        int curr=0,total=0,res=0;

        for(int i=0;i<gas.length;i++){
            int currDiff=gas[i]-cost[i];
            total+=currDiff;
            curr+=currDiff;
            if(curr<0){
                curr=0;
                res=i+1;
            }
        }
        return total<0?-1:res;
    }

//    Approach 1; Time: O(n^2); Space: O(n)
//    public int canCompleteCircuit(int[] gas, int[] cost){
//        int n=gas.length;
//        int[] sumArr=new int[n];
//        int i=0;
//
//        while(i<n){
//            sumArr[i]=gas[i]-cost[i];
//            i++;
//        }
//        i=0;
//
//        while(i<n){
//            int j=i;
//            int rem=0;
//            while(j<n && rem>=0){
//                rem+=sumArr[j];
//                j++;
//            }
//            j=0;
//            while(j<i && rem>=0){
//                rem+=sumArr[j];
//                j++;
//            }
//            if(rem>=0){
//                return i;
//            }
//            i++;
//        }
//        return -1;
//
//    }

    public static void main(String[] args) {
        GasStation gs=new GasStation();
        System.out.println("Expected output=0; Actual output="+gs.canCompleteCircuit(new int[]{5},new int[]{4}));
        System.out.println("Expected output=3; Actual output="+gs.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        System.out.println("Expected output=4; Actual output="+gs.canCompleteCircuit(new int[]{5,1,2,3,4},new int[]{4,4,1,5,1}));
        System.out.println("Expected output=3; Actual output="+gs.canCompleteCircuit(new int[]{0,0,0,10},new int[]{1,2,3,4}));
        System.out.println("Expected output=0; Actual output="+gs.canCompleteCircuit(new int[]{9,1,1,1,1},new int[]{5,4,1,1,1}));

        System.out.println("Expected output=-1; Actual output="+gs.canCompleteCircuit(new int[]{2,3,4},new int[]{3,4,3}));
    }
}
