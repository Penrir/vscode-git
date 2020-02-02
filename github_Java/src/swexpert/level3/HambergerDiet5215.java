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
                arr[i][0] = sc.nextInt(); //0��° �ε������� �� ����
                arr[i][1] = sc.nextInt(); //1��?���� Į�θ� ����
            }
            //�ڿ������� ���鼭 ���� �ε������� ��� ���� ���� �� ���� ������.
            //DFS�߿� �ڿ� ���� �� ���ص� �ƽ����� ������ DFS������Ű�� �뵵.
            for (int i = N-1; i >= 0; i--) {
                arr[i][2] = reverseSum;  //���Ѱ� 2��° �ε����� ����.
                reverseSum += arr[i][0]; //�ڿ������� ������ �� ���ϴ� ��.
                //������ ���ϴ� �� ���� �ε����� ������ �����ؼ� �����ϴ°� �ƴ϶� �����ϰ� �ڿ� �ε������� ���� ���� �ε����� ����.
            }
            HambergerDietDFS(arr, 0, 0, 0);


            System.out.printf("#%d %d\n", test_case, max);
            max =0;
        }
        sc.close();
    }
    static void HambergerDietDFS( int[][] berger,  int idx ,  int ntaste,  int ncal){
        //Į�θ� �ִ�ġ�� ���� Į�θ� �������� �ִ���� ���� ����.
   //     System.out.printf("-------idx//%d t/%d cal//%d max//%d\n", idx, ntaste, ncal, max);
        if(ncal == tmaxCalories){
            if(max < ntaste){
                max = ntaste;
            }
            return;
        }
        //Į�θ��� �ƽ�ġ�� ���� ??�� ����
        if(ncal > tmaxCalories){
            return;
        }
        //������ Ž���� ����
        if(idx >= berger.length){
            if(max < ntaste){
                max = ntaste;
            }
            return;
        }
        //���� �ε������� ���� �հ� ������� ���� ���� ���� �ִ������ ���� ��� ����
        //���� ���� �ε����� ���� �����ѰͰ� �������� ������ ������ ���� �����̹Ƿ� �ּ� 2��° ���� ���డ���� ���ǹ�
        //�׷��� 1�̻��� idx���� ����.
        //i-1�� �Ѱ��� �� �� �ε������� ���� �������� ���;� ������ ����� �۵��ϱ� ����
        if( idx > 0 && ntaste + berger[idx-1][2] < max){
            return;
        }



        //�������ǵ��� ��� ������ ���� �ε����� ������
        HambergerDietDFS(berger, idx+1, ntaste + berger[idx][0], ncal + berger[idx][1]);
        HambergerDietDFS(berger, idx+1, ntaste, ncal);
    }
}