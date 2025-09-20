package leetcode.medium;

//https://leetcode.com/problems/design-spreadsheet/description/

import java.util.HashMap;
import java.util.Map;

//Time Complexity: setCell: O(1), resetCell: O(1), getValue: O(1), getOperandValue: O(1)
//Space Complexity: O(1)
public class Spreadsheet {
    private final int[][] arr;

    public Spreadsheet(int rows) {
        this.arr=new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int[] index=parseCell(cell);
        arr[index[0]][index[1]]=value;
    }

    public void resetCell(String cell) {
        setCell(cell,0);
    }

    public int[] parseCell(String cell){
        int i=Integer.parseInt(cell.substring(1))-1;
        int j=cell.charAt(0)-'A';
        return new int[]{i,j};
    }

    public int getValue(String formula) {

        for(int i=0;i<formula.length();i++){
            if(formula.charAt(i)=='+'){
                String a=formula.substring(1,i);
                String b=formula.substring(i+1);
                return getOperandValue(a)+getOperandValue(b);
            }
        }
        return 0;
    }
    public int getOperandValue(String s) {
        if(Character.isDigit(s.charAt(0))){
            return Integer.parseInt(s);
        }
        else{
            int[] index=parseCell(s);
            return arr[index[0]][index[1]];
        }
    }

//    Time Complexity: setCell: O(1) average, resetCell: O(1) average, getValue: O(1) (formula always two terms)
//    Space Complexity: O(k), where k = number of explicitly set cells (at most 10^4 by constraints)
//public class Spreadsheet {
//    private static Map<String,Integer> map;
//
//    public Spreadsheet(int rows) {
//        map=new HashMap<>();
//    }
//
//    public void setCell(String cell, int value) {
//        map.put(cell,value);
//    }
//
//    public void resetCell(String cell) {
//        map.remove(cell);
//    }
//
//    public int getValue(String formula) {
//        formula=formula.substring(1);
//        int res=0;
//        for(String s: formula.split("\\+")){
//            if(s.charAt(0)>='A' && s.charAt(0)<='Z'){
//                res+=map.getOrDefault(s,0);
//            }
//            else{
//                res+=Integer.parseInt(s);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet=new Spreadsheet(3);
        System.out.println("Expected= 12, Actual= "+spreadsheet.getValue("=5+7"));
        spreadsheet.setCell("A1", 10);
        System.out.println("Expected= 16, Actual= "+spreadsheet.getValue("=A1+6"));
        spreadsheet.setCell("B2", 15);
        System.out.println("Expected= 25, Actual= "+spreadsheet.getValue("=A1+B2"));
        spreadsheet.resetCell("A1");
        System.out.println("Expected= 15, Actual= "+spreadsheet.getValue("=A1+B2"));
    }

}
