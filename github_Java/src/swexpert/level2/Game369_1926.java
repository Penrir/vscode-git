package swexpert.level2;

import java.util.Scanner;

class Gmae369_1926{
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int N;
        N = Integer.parseInt(s);
        String temp;
        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            temp = Integer.toString(i);
       //     System.out.println(temp);
            for (int j = 0; j < temp.length(); j++) {
                //���ڿ� 369�ִ��� �˻��ϰ� 369���Ë����� -���, �׸��� �÷��׸� Ʈ��� �ٲ㼭 ���ڸ� ����ϴ� �κ� ����.
                if (temp.charAt(j) == '3' || temp.charAt(j) == '6'|| temp.charAt(j) == '9'){
                    System.out.print("-");
                    flag = true;
                }
            }
            if(!flag){
                System.out.printf("%d",i);
            }
            System.out.print(" ");
            temp = "";
            flag = false;
        }

        sc.close();;
   }
}