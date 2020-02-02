package swexpert.level2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ThrowStone_1285 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\level2\\ThrowStone_1285.txt"));
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for (int test_case = 1; test_case <= TC; test_case++) {
            //던지는 횟수 받기
            int N = sc.nextInt();
            //최소거리 초기화
            int min=Integer.MAX_VALUE;
            //최소거리 횟수 초기화
            int result=0;
            int num =0;
            for (int i = 0; i < N; i++) {
                //인풋하나 입력받고 입력받은값을 절대값으로 변환
                num = Math.abs(sc.nextInt());
                //최소거리 보다 작다면 입력값을 최소거리로 바꾸고 최소거리 횟수도 1개로 초기화
                if(num < min){
                    min = num;
                    result = 1;
                }
                else if(num == min){ // 최소거리가 같은게 나오면 횟수 1증가
                    result++;
                }
            }
            System.out.println("#" + test_case + " " + min + " " + result);
        }





        sc.close();
    }
    

}