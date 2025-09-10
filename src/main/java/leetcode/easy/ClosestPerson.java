package leetcode.easy;
//https://leetcode.com/problems/find-closest-person/
public class ClosestPerson {
    public static void main(String[] args) {
        System.out.println(findClosest(1,5,3));
        System.out.println(findClosest(1,5,8));
        System.out.println(findClosest(1,6,5));
        System.out.println(findClosest(6,3,7));
    }
    public static int findClosest(int x, int y, int z) {
//        Time: O(1), Space: O(1)
        int a=Math.abs(x-z);
        int b=Math.abs(y-z);
        if(a==b)
            return 0;
        return a>b?2:1;
    }
}
