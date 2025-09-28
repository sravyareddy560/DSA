package leetcode.medium;
//https://leetcode.com/problems/min-stack
import java.util.Stack;

//Time Complexity: O(1), for every method
//Space Complexity: O(n), including stack else O(1)
public class MinStack {
    private static Stack<Long> st=new Stack<>();
    private static Long min;

    public MinStack(){
        min= Long.MAX_VALUE;
    }

    public void push(int val){
        Long value=Long.valueOf(val);
        if(st.isEmpty()){
            min=value;
            st.push(value);
        }
        else {
            if (min<value) {
                st.push(value);
            }
            else{
                st.push(2*value-min);
                min=value;
            }
        }
    }

    public void pop(){
        Long top=st.pop();
        if(top<min){
            min=2*min-top;
        }
    }

    public int top(){
        Long top=st.peek();
        if(top<min){
            top=min;
        }
        return top.intValue();
    }

    public int getMin(){
        return min.intValue();
    }

    public static void main(String[] args) {
        MinStack ms=new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("Expected= -3, Actual= "+ms.getMin());
        ms.pop();
        System.out.println("Expected= 0, Actual= "+ms.top());
        System.out.println("Expected= -2, Actual= "+ms.getMin());

    }
}
