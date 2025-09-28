package leetcode.easy;

import java.sql.Time;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/

//Time Complexity: O(n),Space Complexity: O(n)
//    public boolean isValid(String s) {
//        char[] carr=new char[s.length()];
//        int i=0;
//        for(char c:s.toCharArray()){
//            if(c=='(' || c=='{' || c=='[')
//                carr[i++]=c;
//            else if(i>0 && ((c==')' && carr[i-1]=='(')||(c==']' && carr[i-1]=='[')||(c=='}' && carr[i-1]=='{')))
//                i--;
//            else
//                return false;
//        }
//        return i==0;
//    }


//Optimized Approach; Time Complexity: O(n),Space Complexity: O(n)
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        st.push('a');

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else if(c==')' && st.peek()=='('){
                st.pop();
            }
            else if(c=='}' && st.peek()=='{'){
                st.pop();
            }
            else if(c==']' && st.peek()=='['){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.pop()=='a';
    }

//    Time Complexity: O(n^2),Space Complexity: O(n)
//    public boolean isValid(String s) {
//        while (true) {
//            if (s.contains("()")) {
//                s = s.replace("()", "");
//            } else if (s.contains("{}")) {
//                s = s.replace("{}", "");
//            } else if (s.contains("[]")) {
//                s = s.replace("[]", "");
//            } else {
//                return s.isEmpty();
//            }
//        }
//    }

    public static void main(String[] args) {
        ValidParentheses vp=new ValidParentheses();
        System.out.println("Expected= true, Actual= "+vp.isValid("()"));
        System.out.println("Expected= true, Actual= "+vp.isValid("()[]{}"));
        System.out.println("Expected= false, Actual= "+vp.isValid("(]"));
    }
}
