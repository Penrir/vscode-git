package swexpert.level3;

import java.util.Scanner;

//오타
//틀렸다는데 뭐가 틀린지 모르겠음.
public class SwExpert7853_아직실패 {
	static int div = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			String s = sc.next();
			long answer = 1;
			for (int i = 0; i < s.length(); i++) {
				if(i==0) {
					if(s.charAt(i) != s.charAt(i+1)) {
//						answer *= 2;ㅜ
//						answer %= div;
						answer = ((answer % div) * (2%div)) % div;
					}
					continue;
				}
				if(i == s.length()-1) {
					if(s.charAt(i) != s.charAt(i-1)) {
						answer = ((answer % div) * (2%div)) % div;
//						answer *= 2;
//						answer %= div;
					}
					continue;
				}
				//앞뒤 같을때
				if(s.charAt(i-1) == s.charAt(i+1)) {
					if(s.charAt(i) != s.charAt(i-1)){
						//가운데랑은 다르면
						answer = ((answer % div) * (2%div)) % div;
//						answer *= 2;
//						answer %= div;
					}
				}
				else {
					//셋다0 다를때
					if(s.charAt(i) != s.charAt(i-1)){
						answer = ((answer % div) * (3%div)) % div;
					}
				}
			}
			System.out.printf("#%d %d%n", test_case, answer);
		}
		sc.close();
	}
	
}

/*
3
apa			2*2*2
abcde		2*3*3*3*2	4*27 = 108
aaaaa		


#1 8
#2 108
#3 1
*/
/*
 * 
방송사에서 생방송 자막 송출을 담당하고 있는 재경이는 한글 타자가 무려 1000에 육박한다.

누구보다 빠른 한글 타자를 보유하고 있지만 치명적인 단점이 있다. 영어 타자의 오타가 극심하게 발생한다.

재경이는 어떤 단어를 쓸 때에 오타를 특정한 방법으로 발생시킨다.

치고자 하는 단어와 길이는 동일한 단어를 쓰지만, i번째 문자에다가 원래 단어의 (i-1) 번째, i 번째, (i+1) 번째 문자 중 무엇이든 쳐버린다.

특히 제일 첫 문자는 첫 문자와 그 다음 문자 중 하나를 쓸 수 있고, 마지막 문자는 마지막과 그 앞의 문자를 쓸 수 있다.

예를 들어서, apa 라는 단어에서 재경이가 낼 수 있는 오타는 aaa, aap, apa, app, paa, pap, ppa, ppp 중 하나를 칠 수 있는 것이다.

단어가 주어졌을 때에 재경이가 칠 수 있는 서로 다른 단어의 개수를 구하여라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 재경이가 원래 치고자 하는 단어가 주어진다. 단어의 길이는 1,000 이하의 자연수이다. 단어는 모두 소문자 알파벳으로 구성되어 있다.


[출력]

각 테스트 케이스마다 재경이가 칠 수 있는 단어의 종류를 10억7(=109+7) 로 나눈 나머지를 출력하라.
 

내부 입력 복사 완료!!
입력입력 복사
3
apa
abcde
aaaaa	
// 테스트 케이스 개수

// 주어진 첫 번째 문자열

 

input.txt
내부 입력 복사
출력출력 복사
#1 8
#2 108
#3 1	
// 첫 번째 테스트 케이스 결과

// 두 번째 테스트 케이스 결과

// 세 번째 테스트 케이스 결과


 * 
 * *
 */