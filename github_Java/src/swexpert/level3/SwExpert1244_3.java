package swexpert.level3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//최대상금 문제
//누더기처럼 하드코딩으로 기워서 만듦......
public class SwExpert1244_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			
			
			
		}
		
		
		
		
	}
}
/*
최대 6자리수
바꾸는 방법은 15가지 5+4+3+2+1
최대 10번 바꿈. 그럼 15의 10승만큼의 경우의 수가 나옴.

1이 바뀌는 경우는 1 23456
2는 2 13455

맥스값이 가장 앞인 경우들만 다시 검사함. 

1. 6개중에 2개뽑기한 것을 배열로 저장해둠.

2. 저장한 배열 돌아가면서 가장 앞줄이 가장 큰값 된것들만 큐에 넣는다.

3. 조합한것중에 1들어간거 다 제거.

4.시작 인덱스를 하나 올린다.

5. 배열 돌면서 바꿔본다.
6. 가장 앞줄 큰값들만 저장한다.
7. 조합한것중에 시작인덱스 들어간거 지운다.
8. 교환횟수 0될때까지 5~7반복.
*/