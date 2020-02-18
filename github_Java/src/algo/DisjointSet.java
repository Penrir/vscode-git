package algo;
import java.util.Arrays;

public class DisjointSet {
	static int size = 10;
	static int [] parent = new int[size+1];
	public static void main(String[] args) {
//10개 정도의 접점이 있어서 그 집합을 서로소 집합으로 관리하라
		makeSet();
		int idx = findSet(2);
		System.out.println(findSet(2));
		union(3, 2);
		System.out.println(findSet(2));
		union(3, 5);
		union(4, 3);
		System.out.println(findSet(2));
		System.out.println(findSet(5));
		System.out.println(Arrays.toString(parent));
	}
	

	private static void union(int x, int y) {
		parent[findSet(y)] = findSet(x);
	}
	//parent 값 다 바꾸는거(제일 꼭대기값으로)
//	private static int findSet(int idx) {
//		if(idx != parent[idx]) {
//			parent[idx] = findSet(parent[idx]); 
//		}
//		return parent[idx];
//	}
	private static int findSet(int idx) {
		if(idx == parent[idx]) {
			 return idx;
		}
		return parent[idx] = findSet(parent[idx]);
	}
	//그냥 쭉 따라 올라가서 제일 부모값 반환
//	private static int findSet(int idx) {
//		if(idx == parent[idx]) {
//			return idx;
//		}
//		return findSet(parent[idx]);
//	}

	private static void makeSet() {
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i; 
		}
	}
}
