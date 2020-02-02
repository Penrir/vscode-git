/*
 패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.


[제약 사항]

각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.


[입력]

가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 길이가 30인 문자열이 주어진다.


[출력]

출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.

(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
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
        //글자 하나 단위부터 바로 뒤랑 비교해서 같다면 패턴으로 판단하고 그 뒤에도 전부다 같게 나오는지 판3단.
        //다 같다면 결과 출력
        //다르다면 글자 하나 늘려서 다시 시도.
        //답 나올때까지 혹은 글자길이/2까지 반복.
        int TC = sc.nextInt();
        String s = new String();
        int sublen;
        for (int test_case = 1; test_case <= TC; test_case++) {
            s = sc.next();
            for (int i = 1; i <= s.length()/2; i++) {
                flag = true;
                sublen = 1; // i뒤에 곱할 변수
                //0~1 == 1~2라면 쭉 검사 0~1 == 2~3
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