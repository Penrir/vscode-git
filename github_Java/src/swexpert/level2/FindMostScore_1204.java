package swexpert.level2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class FindMostScore_1204{
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\level2\\FindMostScore_1204.txt"));
        Scanner sc = new Scanner(System.in);

        int[] score = new int[101];

        int TC = sc.nextInt();
        int most;
        for (int test_case = 1; test_case <= TC; test_case++) {
            most = sc.nextInt();
        //    score = new int[101];
            //array initialize
            Arrays.fill(score, 0);
            //fill array
            for (int i = 0; i < 1000; i++) {
                score[sc.nextInt()]++;
            }
            most =0;
            //fill score count
            for (int i = 0; i < 101; i++) {
                if(score[i] >= score[most]){
                    most = i;
                }
            }
            System.out.printf("#%d %d\n", test_case, most);
        }
        
        sc.close();;
    }
}