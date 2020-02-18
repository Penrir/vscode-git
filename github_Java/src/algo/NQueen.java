package algo;

public class NQueen {
	static int cnt =0;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		int n = 1;
//		List<Integer> list = new LinkedList<Integer>();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[0] = i;
			nQueen(arr, 1);
		}
		System.out.println(cnt);
	}
	
	static void printNQueenArray(int[] result) {
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i]; j++) {
				sb.append("* ");
			}
			sb.append("N ");
			for (int j = result[i]+1; j < result.length; j++) {
				sb.append("* ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void nQueen(int[] result, int idx ) {
		if(idx == result.length) {
//			System.out.println(Arrays.toString(result));
			cnt++;
			printNQueenArray(result);
			return;
		}
		for (int i = 0; i < result.length; i++) {
			result[idx]= i; 
			if(isPromming(result, idx)) {
				nQueen(result, idx+1);
			}
		}
	}
	
	private static boolean isPromming(int[] result, int idx) {
		for (int i = 0; i < idx; i++) {
			//같은 열이면 유망하지 않음.
			if(result[i] == result[idx])
				return false;
			//대각선 검사
			if(Math.abs(idx-i) == Math.abs(result[i]- result[idx]) ) {
				return false;
			}
		}
		return true;
	}
	
}
