package swexpert.level2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Base64Decoder_1928 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\level2\\Base64Decoder_1928.txt"));
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        //3���ڸ� �ϳ��� ������ ó���ؾ���
        //2������ ���ڸ� ���� 6��Ʈ�� �ɰ��� �ٲٱ�.
        for (int test_case = 1; test_case <= TC; test_case++) {
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                System.out.println(Integer.toBinaryString(s.charAt(i)) + " " + s.charAt(i)
                + (int)s.charAt(i));
            } 
            //shift�� ����Ʈ�ϴ°� Ƚ�� ����. 0~5��, 6~11, 12~17, 18~23
            //���� 3���� 4���� ���ڵ��Ѱ� �Է���.
            //�Է°� 4���� �ϳ��� ��� 2������ �� �����ϰ� 8���� ��� ���ڵ�.
            /*
            ���� : Lif������

01001100 01101001 01100110
//6���� �ڸ���
010011 000110 100101 100110
19	6	37       38

��ǲ �����͸� 4���ھ� ��� ����ؾߵ�.
�ѱ��ھ� 2������ �ٲ۴��� 6��Ʈ���� �ٿ� 24��Ʈ�� �����.
24��Ʈ�� 8��Ʈ�� �ɰ��� �۷� ��ȯ�ϸ� ������ ����.
            */
        //    int shift = 0;
            
            System.out.println();
        }
        

    }
}