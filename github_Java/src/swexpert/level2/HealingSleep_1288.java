package swexpert.level2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class HealingSleep_1288 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\level2\\HealingSleep_1288.txt"));
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        int num=0;
        int digitCount[] = new int[10];
        int tempnum=0;
        int baesu=1;
        for (int test_case = 1; test_case <= TC; test_case++) {
            num = sc.nextInt();
      //      System.out.println(num);
            while(!checkAllDigit(digitCount)){
                tempnum = num * baesu; // 1배 2배 이렇게 올라감
          //      System.out.println(tempnum);
                while(tempnum > 0){
                    digitCount[tempnum % 10]++;
                    tempnum /= 10;
                }
                baesu++;
            }
            System.out.printf("#%d %d\n", test_case, num*(baesu-1));
            baesu =1;
            digitCount = new int[10];
        }


    }
    static boolean checkAllDigit(int [] digitCount){
    //    System.out.println(Arrays.toString(digitCount));
        for(int i=0; i<digitCount.length; i++){
            if(digitCount[i] == 0){
                return false;
            }
        }
        return true;
    }
}