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
            //������ Ƚ�� �ޱ�
            int N = sc.nextInt();
            //�ּҰŸ� �ʱ�ȭ
            int min=Integer.MAX_VALUE;
            //�ּҰŸ� Ƚ�� �ʱ�ȭ
            int result=0;
            int num =0;
            for (int i = 0; i < N; i++) {
                //��ǲ�ϳ� �Է¹ް� �Է¹������� ���밪���� ��ȯ
                num = Math.abs(sc.nextInt());
                //�ּҰŸ� ���� �۴ٸ� �Է°��� �ּҰŸ��� �ٲٰ� �ּҰŸ� Ƚ���� 1���� �ʱ�ȭ
                if(num < min){
                    min = num;
                    result = 1;
                }
                else if(num == min){ // �ּҰŸ��� ������ ������ Ƚ�� 1����
                    result++;
                }
            }
            System.out.println("#" + test_case + " " + min + " " + result);
        }





        sc.close();
    }
    

}