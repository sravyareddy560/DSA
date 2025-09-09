package leetcode.easy;

public class PrintUpperCase {
    public static void main(String[] args) {
        System.out.println(toUpperCase("Hi How Do You Do!"));
    }
    public static String toUpperCase(String s){
        StringBuilder sb=new StringBuilder();

        for(char c:s.toCharArray()){
            if(Character.isLowerCase(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
