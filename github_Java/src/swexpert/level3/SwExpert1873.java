package swexpert.level3;
import java.util.Arrays;
import java.util.Scanner;

public class SwExpert1873 {
	public static void main(String[] args) {
		//map 저장하는 배열 만든다.
		//평지는 0		46
		//벽돌벽은 1	42
		//강철벽은 2	35
		//물은 3		45
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			int n2 = sc.nextInt();
			int[][] arr = new int[n][n2];
			String temp;
			int x = 0, y=0, dir=0;
			for (int i = 0; i < n; i++) {
				temp = sc.next();
				for (int j = 0; j < arr[i].length; j++) {
					switch(temp.charAt(j)) {
					//map 저장하는 배열 만든다.
					//평지는 0 .		46
					//벽돌벽은 1 *	42
					//강철벽은 2 #	35
					//물은 3	-	45
					case '-': 
						arr[i][j] = 3;
						break;
					case '*':
						arr[i][j] = 1;
						break;
					case '#':	
						arr[i][j] = 2;
						break;
					case '.':
						arr[i][j] = 0;
						break;
						// 상 1 하2 좌3 우4
					case '>':
						dir = 4;
						x = i;
						y = j;
						break;
					case '<':
						dir = 3;
						x = i;
						y = j;
						break;
					case '^':
						dir = 1;
						x = i;
						y = j;
						break;
					case 'v':
						dir = 2;
						x = i;
						y = j;
						break;
					}
					
					
					
				}
			}
			int c = sc.nextInt();
			String co = sc.next();
			//입력확인
//			System.out.println(Arrays.toString(srr));
//			System.out.printf("%d %d %s", n, c, co);
//			System.out.println(Arrays.deepToString(arr));
//			for (int[] ks : arr) {
//				System.out.println(Arrays.toString(ks));
//			}
//			System.out.printf("%d %d %d%n", x, y, dir);
//			
			
			
			for (int k = 0; k < co.length(); k++) {
				// 상 1 하2 좌3 우4
				switch (co.charAt(k)) {
				case 'S':
					shoot(arr, x, y, dir);
					break;
				case 'U':
					dir = 1;
					//갈수 있을때
					if(x-1 >=0 && arr[x-1][y] == 0 )
						x--;
					break;
				case 'D':
					if(x+1 < n && arr[x+1][y]== 0 )
						x++;
					dir = 2;
					break;
				case 'L':
					dir = 3;
					if(y -1 >= 0 && arr[x][y-1] == 0) {
						y--;
					}
					break;
				case 'R':
					if(y+1 < n2 && arr[x][y+1] == 0) {
						y++;
					}
					dir = 4;
					break;
				default:
					break;
				}
			}
			// 상 1 하2 좌3 우4
//			for (int[] ks : arr) {
//				System.out.println(Arrays.toString(ks));
//			}
//			System.out.printf("%d %d %d%n", x, y, dir);
			
			System.out.print("#" + test_case + " ");
			
			printResult(arr, x, y, dir);
			
		}
	}
	
	
	static void printResult(int[][]arr, int x, int y, int dir) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i == x && j == y) {
					switch (dir) {
					case 1:
						System.out.print('^');
						continue;
					case 2:
						System.out.print('v');
						continue;
					case 3:
						System.out.print('<');
						continue;
					case 4:
						System.out.print('>');
						continue;
					}
				}
				//map 저장하는 배열 만든다.
				//평지는 0 .		46
				//벽돌벽은 1 *	42
				//강철벽은 2 #	35
				//물은 3	-	45
				switch (arr[i][j]) {
				case 0:
					System.out.print(".");
					break;
				case 1:
					System.out.print("*");
					break;
				case 2:
					System.out.print("#");
					break;
				case 3:
					System.out.print("-");
					break;
				}
			}
			System.out.println();
		}
		
		
	}
	
	//map 저장하는 배열 만든다.
	//평지는 0 .		46
	//벽돌벽은 1 *	42
	//강철벽은 2 #	35
	//물은 3	-	45
	// 상 1 하2 좌3 우4
	static void shoot(int[][] arr, int x, int y, int dir) {
		switch(dir) {
		case 1:
			for (int i = x; i >= 0; i--) {
				switch (arr[i][y]) {
				case 1:
					arr[i][y]= 0;
					return;
				case 2:
					return;
				case 3:
					continue;
				default:
					arr[i][y] = 0;
					break;
				}
			}
			break;
		case 2:
			for (int i = x; i < arr.length; i++) {
				switch (arr[i][y]) {
				case 1:
					arr[i][y]= 0;
					return;
				case 2:
					return;
				case 3:
					continue;
				default:
					arr[i][y] = 0;
					break;
				}
			}
			break;
		case 3:
			for (int i = y; i >= 0; i--) {
				switch (arr[x][i]) {
				case 1:
					arr[x][i]= 0;
					return;
				case 2:
					return;
				case 3:
					continue;
				default:
					arr[x][i] = 0;
					break;
				}
			}
			break;
		case 4:
			for (int i = y; i < arr[x].length; i++) {
				switch (arr[x][i]) {
				case 1:
					arr[x][i]= 0;
					return;
				case 2:
					return;
				case 3:
					continue;
				default:
					arr[x][i] = 0;
					break;
				}
			}
			break;
		}
	}
}
