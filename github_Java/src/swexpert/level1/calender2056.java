package swexpert.level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class calender2056 {
    public static void main(String[] args) throws FileNotFoundException{
        System.setIn(new FileInputStream("src\\swexpert\\level1\\calender2056.txt"));
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
                        //   1   2   3   4   5   6   7   8   9   10  11  12
        int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        StringBuffer date = new StringBuffer();
        for (int test_case = 1; test_case <= TC; test_case++) {
            date.append(sc.next());
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);
      //      System.out.println(date);
       //     System.out.println(month);
        //    System.out.println(day);
            if(Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13){
          //      System.out.println("----" + month + "  " + monthDay[Integer.parseInt(month)]);
                if(Integer.parseInt(day) > 0 && Integer.parseInt(day) <= monthDay[Integer.parseInt(month)]){
                    System.out.printf("#%d %s/%s/%s\n", test_case, date.substring(0,4), month, day);
                    date.delete(0, date.length());
                    continue;
                }
            }
            System.out.printf("#%d %d\n", test_case, -1);

            date.delete(0, date.length());
        }
        sc.close();
    }


}