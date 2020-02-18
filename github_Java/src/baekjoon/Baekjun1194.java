package baekjoon;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjun1194 {
	static char[][] arr;
	static int answer = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = 0, y = 0 ;
		arr = new char[n][m];
		boolean[][] V = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String string= sc.next();
			for (int j = 0; j < m; j++) {
				arr[i][j]= string.charAt(j); 
				if(arr[i][j]== '0' ) {
					x = i;
					y = j;
				}
			}
		}
		LinkedList<Character> k = new LinkedList<>();
		LinkedList<Character> use = new LinkedList<>();
		
		System.out.println(arr.length);
		dfs(x, y, k, 0, V, use);
		System.out.println(answer);
		
	}
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static void dfs(int x, int y, LinkedList<Character> k, int distance, boolean[][] v, LinkedList<Character> use) {
		v[x][y] = true; 
		System.out.printf("x-%d y-%d%n", x, y);
		int nx =0, ny =0;
		for (int i = 0; i < dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || ny < 0|| nx >= arr.length || ny >=arr.length) {
				System.out.println("outBound");
				continue;
			}
			//출구찾음
			if(arr[nx][ny]== '1' ) {
				if(answer == -1) {
					answer = distance+1;
				}
				else {
					answer = answer < distance+1 ? answer : distance+1;
//					answer = Math.min(answer, distance);
				}
				return;
			}
			//벽이면 넘어감
			if(arr[nx][ny]== '#' ) {
				System.out.println("wall");
				continue;
			}
			//방문한적 있으면 넘어감
			if(v[nx][ny]) {
				continue;
			}
			//소문자 만났을 떄
			if(Character.isLowerCase(arr[nx][ny])) {
				k.add(arr[nx][ny]);
				System.out.println("eat " + arr[nx][ny]);
				//열쇠 찾으면 돌아가야 하니깐 방문 배열 초기화
				for (int j = 0; j < v.length; j++) {
					Arrays.fill(v[j], false);
				}
				dfs(nx, ny, k, distance+1, v, use);
			}
			//대문자 만났을 때
			else if(Character.isUpperCase(arr[nx][ny])) {
				//열쇠 있으면
				if(k.contains(Character.toLowerCase(arr[nx][ny]))) {
					//사용한적 있으면
					if(use.contains(arr[nx][ny])) {
						continue;
					}
					use.add(arr[nx][ny]);
					dfs(nx, ny, k, distance+1, v, use);
				}
				System.out.println("UpperLetter");
			}
			else {
				dfs(nx, ny, k, distance+1, v, use);
			}
		}
	}
	
}
