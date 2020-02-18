package swexpert.level3;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class SwExpert1258 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int[][]arr;
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j]= sc.nextInt(); 
				}
			}
			//방문체크
			boolean[][] check = new boolean[n][n];
			
			// 그룹을 찾는다.
			//그룹 찾는 방법
			// 배열 쭉 검사하는데 배열요소가 0이 아니고 방문 한적 없다면 해당 그룹 찾기를 시작한다. 
			// 검색할때 왼쪽 위에서 오른쪽아래방향으로 검사하기 때문에 오른쪽과 아래쪽만 검사하면 된다.
			// 오른쪽 검색할 때  오른쪽칸이 방문한적있는지 검사하고 0이 아닌지검사한다. 
			// 아래쪽으로도 동일하게 검사한다.
			// 그룹하나 찾으면 리스트에 추가한다.
			//point x = row y = col count
			LinkedList<Point> list = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(arr[i][j] == 0 )
						continue;
					if(check[i][j])
						continue;
//					System.out.printf("xy %d %d%n", i, j);
					list.add(findGroup(arr, i, j, check));
					
				}
			}
			list.sort(Comparator.comparing(Point::getArea).thenComparing(Point::getX));
			System.out.printf("#%d %d ", test_case, list.size());
			list.stream().forEach(x -> System.out.printf("%d %d ", x.x, x.y));
			System.out.println();
			list.clear();
		}
	}
	
	static Point findGroup(int[][]arr, int x, int y, boolean[][] V) {
		int n = V.length;
		int tx=0, ty=0;
		//아래쪽 검사
		for (int i = x; i < n-1; i++) {
			if( arr[i+1][y] == 0) {
				tx = i;
				break;
			}
		}
		//오른쪽으로 검사
		for (int j = y; j < n-1; j++) {
			if(arr[x][j+1] == 0) {
				ty = j;
				break;
			}
		}
		
		for (int i = x; i <= tx; i++) {
			for (int j = y; j <= ty; j++) {
				V[i][j]= true; 
			}
		}
		
		return new Point(tx - x + 1, ty - y + 1);
	}
	
	static class Point{
		int x;
		int y;
		int area;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			area = x * y;
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
		public int getArea() {
			return area;
		}
		public void setArea(int area) {
			this.area = area;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", area=" + area + "]";
		}
		
	}
	
}
