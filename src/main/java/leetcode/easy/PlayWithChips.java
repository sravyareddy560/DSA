package leetcode.easy;

//https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
public class PlayWithChips {
//    Time: O(n), Space: O(1)
    public int minCostToMoveChips(int[] position) {
        int oddCount=0,evenCount=0;

        for(int n:position){
            if(n%2==0){
                evenCount++;
            }
            else{
                oddCount++;
            }
        }
        return Math.min(evenCount,oddCount);
    }

    public static void main(String[] args) {
        PlayWithChips pwc=new PlayWithChips();
        System.out.println("Expected= 1, Actual= "+pwc.minCostToMoveChips(new int[]{1,2,3}));
        System.out.println("Expected= 2, Actual= "+pwc.minCostToMoveChips(new int[]{2,2,2,3,3}));
        System.out.println("Expected= 1, Actual= "+pwc.minCostToMoveChips(new int[]{1,1000000000}));
    }
}
