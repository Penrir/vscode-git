package swexpert.level3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/*
※ SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

0 ~ 999999 사이의 수를 나열하여 만든 암호문이 있다. 암호문을 급히 수정해야 할 일이 발생했는데,

이 암호문은 특수 제작된 처리기로만 수정이 가능하다. 이 처리기는 다음과 같이 2개의 기능을 제공한다.

1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]

2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]

위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.

[입력]

첫 번째 줄 : 원본 암호문의 길이 N ( 100 ≤ N ≤ 200 의 정수)

두 번째 줄 : 원본 암호문

세 번째 줄 : 명령어의 개수 ( 10 ≤ N ≤ 20 의 정수)

네 번째 줄 : 명령어

위와 같은 네 줄이 한 개의 테스트 케이스이며, 총 10개의 테스트 케이스가 주어진다.

[출력]

#기호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 수정된 암호문의 처음 10개 항을 출력한다.
*/


class SwExpert_hw_20200204{

    public static void main(String[] args) throws FileNotFoundException {
        //파일에서 입력받음.
        System.setIn(new FileInputStream("src\\swexpert\\level3\\SwExpert_hw_20200204.txt"));
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            
        
            int N = sc.nextInt();
            //링크드리스트 사용해서 함.
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < N; i++){
                list.offer(sc.nextInt());
            }
            N = sc.nextInt();
            String s;
            for(int i = 0; i < N; i++){
                //명령
                s= sc.next();
                //위치
                int start = sc.nextInt();
                //갯수
                int cn = sc.nextInt();
                //추가하기
                if(s.equals("I")){
                  //  System.out.println("II");
                    for (int j = 0; j < cn; j++) {
                        //start에 추가
                        //순차적으로 추가하기 때문에 start++함
                        list.add(start++, sc.nextInt());
                    }
                }
                //지우기
                if(s.equals("D")){
                //    System.out.println("DD");
                    for (int j = 0; j < cn; j++) {
                        //한 인덱스만 계속 지움.
                        list.remove(start);
                    }
                }
            }
            //결과 출력
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.remove() + " ");
            }
            System.out.println();
        }
    }
}