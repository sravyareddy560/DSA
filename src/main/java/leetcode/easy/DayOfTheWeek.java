package leetcode.easy;


import java.time.DayOfWeek;
import java.time.LocalDate;

//https://leetcode.com/problems/day-of-the-week/
public class DayOfTheWeek {
    private static final String[] days=new String[]{"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final String[] DAYS=new String[]{"Saturday", "Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    public String dayOfTheWeek(int day, int month, int year) {

//        Zellers Congruence Approach; Time Complexity: O(1), Space Complexity: O(1)
        int y = year;
        int m = month;
        if (m < 3) { // treat Jan/Feb as months 13/14 of previous year
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int f = day + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j;
        return DAYS[f % 7];

//        Time Complexity: O(1), Space Complexity: O(1)
//        DayOfWeek dayOfWeek = LocalDate.of(year,month,day).getDayOfWeek();
//        return days[dayOfWeek.getValue()];

//        Time Complexity: O(1), Space Complexity: O(1)
//        String result= LocalDate.of(year,month,day).getDayOfWeek().name();
//        return result.substring(0,1)+result.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        DayOfTheWeek dotw=new DayOfTheWeek();
        System.out.println("Expected= Saturday, Actual= "+dotw.dayOfTheWeek(31,8,2019));
    }
}


