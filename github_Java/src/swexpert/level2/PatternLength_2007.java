/*
 ���Ͽ��� �ݺ��Ǵ� �κ��� ������ �θ���. ���ڿ��� �Է� �޾� ������ ���̸� ����ϴ� ���α׷��� �ۼ��϶�.


[���� ����]

�� ���ڿ��� ���̴� 30�̴�. ������ �ִ� ���̴� 10�̴�.


[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���̰� 30�� ���ڿ��� �־�����.


[���]

����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
 */

package swexpert.level2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PatternLength_2007 {
    public static void main(String[] args) throws FileNotFoundException {
        
        boolean flag = false;
        System.setIn(new FileInputStream("src\\swexpert\\level2\\PatternLength_2007.txt"));
        Scanner sc = new Scanner(System.in);
        //���� �ϳ� �������� �ٷ� �ڶ� ���ؼ� ���ٸ� �������� �Ǵ��ϰ� �� �ڿ��� ���δ� ���� �������� ��3��.
        //�� ���ٸ� ��� ���
        //�ٸ��ٸ� ���� �ϳ� �÷��� �ٽ� �õ�.
        //�� ���ö����� Ȥ�� ���ڱ���/2���� �ݺ�.
        int TC = sc.nextInt();
        String s = new String();
        int sublen;
        for (int test_case = 1; test_case <= TC; test_case++) {
            s = sc.next();
            for (int i = 1; i <= s.length()/2; i++) {
                flag = true;
                sublen = 1; // i�ڿ� ���� ����
                //0~1 == 1~2��� �� �˻� 0~1 == 2~3
                //0~2 == 2~4 , 0~2 == 4~6, 0~2 == 6~8
                while( i * sublen < s.length() / 2 + 1){
                    if(!s.substring(i*sublen, i*(sublen+1)).equals(s.substring(0, i))){
                        flag = false;
                        break;
                    }
                    sublen++;
                }
                if(flag){
                    System.out.printf("#%d %d\n", test_case, i);
                    break;
                }
            }
        }
        sc.close();

    }
}