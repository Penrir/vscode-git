package swexpert.level4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파핑파핑지뢰찾기1868 {
	private static int result = 0;
	private static int[][] arr;
	private static int cnt;
	private static boolean[][] visited;
	private static int N;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			//  N(1 ≤ N ≤ 300)
			//"*’이면 지뢰가 있다는 뜻이고, ‘.’이면 지뢰가 없다는 뜻이다. 
			//‘*’와 ‘.’외의 다른 문자는 입력으로 주어지지 않는다.
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			visited = new boolean[N][N];
			String s;
			//input
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < s.length(); j++) {
					if(s.charAt(j) == '.') {
						arr[i][j] = -2; //
						cnt++;
					}
					else { //지뢰
						visited[i][j] = true; 
						arr[i][j] = -1;
					}
				}
			}
			//end input
			//arr 에는 . = -2, 지뢰는 -1
			//지뢰는 방문 체크 되어있음.
			
			//주위에 별이 0개인 곳은 bfs로 다 넣어서 근처에 다 방문체크함.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && star(i, j) == 0  ) {
						bfs(i, j);
						result++;
					}
				}
			}
			//남은 것은 0아닌 것들임.
			//-1갯수만 세서 (방문 안한곳) 더하면 답.
//			printArr();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						result++;
						visited[i][j] = true; 
						arr[i][j] = star(i, j); 
					}
				}
			}
//			printArr();

			//최소 몇 번의 클릭을 해야 지뢰가 없는 모든 칸에 숫자가 표시될 것인지 출력한다
			System.out.printf("#%d %d%n", test_case, result);
			result = 0;
		}
	}
	
	private static void printArr() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Position> queue = new LinkedList<Position>();
		queue.offer(new Position(x, y));
		--cnt;
		visited[x][y] = true; 
		arr[x][y] = 0; 
		Position temp;
		int nx, ny;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			for (int k = 0; k < dx.length; k++) {
				nx = temp.x + dx[k];
				ny = temp.y + dy[k];
				if(isIn(nx, ny) && !visited[nx][ny] ) {
					if(star(nx, ny) == 0) {
						queue.offer(new Position(nx, ny));
						arr[nx][ny] = 0; 
						--cnt;
					}
					visited[nx][ny] = true; 
					arr[nx][ny]  = star(nx, ny); 
				}
			}
		}
	}
	
	private static int star(int x, int y) {
		int ans = 0;
		int nx, ny;
		for (int i = 0; i < dx.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(isIn(nx, ny)) {
				if(arr[nx][ny] == -1) {
					++ans;
				}
			}
		}
		return ans;
	}
	
	private static boolean isIn(int x, int y) {
		if(x>=0 && y>= 0) {
			if(x < N && y < N ) {
				return true;
			}
		}
		return false;
	}
	
	public static class Position {
		int x;
		int y;
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Position [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
	
	
}


/*
#1 1990
#2 1574
#3 1252
#4 1080
#5 7645
#6 6378
#7 5073
#8 4093
#9 17111
#10 14683
#11 11693
#12 9135
#13 30616
#14 26184
#15 20124
#16 15225
#17 48378
#18 39769
#19 31522
#20 24196
 */
 
