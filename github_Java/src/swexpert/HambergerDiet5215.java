package swexpert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class HambergerDiet5215 {
    static int max = 0;
    static int tmaxCalories;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\berger.txt"));
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        int N;
        int reverseSum = 0;
        for (int test_case = 1; test_case <= TC; test_case++) {
            N = sc.nextInt();
            tmaxCalories = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt(); //0번째 인덱스에는 맛 저장
                arr[i][1] = sc.nextInt(); //1번?에는 칼로리 저장
            }
            //뒤에서부터 오면서 다음 인덱스들을 모두 포함 했을 때 맛을 저장함.
            //DFS중에 뒤에 맛을 다 더해도 맥스보다 작으면 DFS정지시키는 용도.
            for (int i = N-1; i >= 0; i--) {
                arr[i][2] = reverseSum;  //더한값 2번째 인덱스에 저장.
                reverseSum += arr[i][0]; //뒤에서부터 맛들의 합 더하는 것.
                //저장후 더하는 건 현재 인덱스의 맛까지 포함해서 저장하는게 아니라 순수하게 뒤에 인덱스들의 합을 현재 인덱스에 저장.
            }
            HambergerDietDFS(arr, 0, 0, 0);


            System.out.printf("#%d %d\n", test_case, max);
            max =0;
        }
    }
    static void HambergerDietDFS( int[][] berger,  int idx ,  int ntaste,  int ncal){
        //칼로리 최대치와 현재 칼로리 같아지면 최대맛과 비교후 종료.
   //     System.out.printf("-------idx//%d t/%d cal//%d max//%d\n", idx, ntaste, ncal, max);
        if(ncal == tmaxCalories){
            if(max < ntaste){
                max = ntaste;
            }
            return;
        }
        //칼로리가 맥스치를 넘을 떄도 좀료
        if(ncal > tmaxCalories){
            return;
        }
        //끝까지 탐색후 종료
        if(idx >= berger.length){
            if(max < ntaste){
                max = ntaste;
            }
            return;
        }
        //뒤쪽 인덱스들의 맛의 합과 현재까지 맛의 합이 현재 최대맛보다 작을 경우 종료
        //아직 현재 인덱스의 맛을 포함한것과 포함하지 않은것 나누지 않은 상태이므로 최소 2번째 부터 시행가능한 조건문
        //그래서 1이상의 idx부터 시행.
        //i-1로 한것은 그 전 인덱스에서 뒤쪽 맛의합을 얻어와야 조건이 제대로 작동하기 때문
        if( idx > 0 && ntaste + berger[idx-1][2] < max){
            return;
        }



        //종료조건들이 모두 끝나면 현재 인덱스를 포함한
        HambergerDietDFS(berger, idx+1, ntaste + berger[idx][0], ncal + berger[idx][1]);
        HambergerDietDFS(berger, idx+1, ntaste, ncal);
    }
}