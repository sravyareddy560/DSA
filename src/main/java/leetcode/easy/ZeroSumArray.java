package leetcode.easy;

//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
public class ZeroSumArray {

    public static void main(String[] args) {
        int[] res=sumZero(5);
        for(int r:res){
            System.out.print(r+", ");
        }

        res=sumZero(0);
        for(int r:res){
            System.out.print(r+", ");
        }

        res=sumZero(8);
        for(int r:res){
            System.out.print(r+", ");
        }
    }
    public static int[] sumZero(int n) {
        int[] res=new int[n];
        int k=0;
        for(int i=1;i<=n/2;i++){
            res[k++]=i;
            res[k++]=-i;
        }
        if(n%2==1)
            res[k]=0;
        return res;
    }
}
