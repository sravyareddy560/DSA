package leetcode.easy;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock

public class BuyandSellStock {
//    Optimized approach; Time: O(n), Space: O(1)
    public int maxProfit(int[] prices){
        int res=0;
        int buy=prices[0];

        for(int curr:prices){
            buy=Math.min(buy,curr);
            res=Math.max(res,curr-buy);
        }
        return res;
    }
//    Time: O(n^2), Space: O(1)
//    public int maxProfit(int[] prices){
//        int n= prices.length;
//        int res=0;
//        for(int i=0;i<n;i++){
//            int buy=prices[i];
//            for(int j=i+1;j<n;j++){
//                int sell=prices[j];
//                res=Math.max(res,sell-buy);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        BuyandSellStock buyandSellStock=new BuyandSellStock();
        System.out.println("Expected= 5, Actual= "+buyandSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Expected= 0, Actual= "+buyandSellStock.maxProfit(new int[]{7,6,4,3,1}));
    }
}
