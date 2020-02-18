package swexpert.level3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Swexpert9282 {
	static boolean V[]; // ?ˆ˜ì§ìœ¼ë¡? ?ë¥? ê³? ì²´í¬
	static boolean H[]; // ?ˆ˜?‰?œ¼ë¡? ?ë¥? ê³? ì²´í¬
	
	
	public static void main(String[] args) throws FileNotFoundException {
		int TC;
		System.setIn(new FileInputStream("src/com/swexpert/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(n + " " + m);
			//?ë¥´ëŠ”ê±? n-1 or m-1ë²ˆì”© ?ë¥´ëŠ”?° 0ë²ˆì¸?±?Š¤?—?Š” ?•©?“¤?´ ?“¤?–´?ˆ?œ¼ë¯?ë¡?
			//n,mê°œì”© ?• ?‹¹
			//ë¶„í• ?•´?„œ ?•˜?‹ˆ ?”±?ˆ ?•„?š”?—†?Œ.
//			V = new boolean[m]; //?ˆ˜ì§ìœ¼ë¡? ?ë¥¸ë?ë¶? ???¥?•´?‘?Š” ë³??ˆ˜
//			H = new boolean[n];
			long result = 0; //ì§?ë¶ˆí•´?•¼?•˜?Š” ê±´í¬?„ ?•© ???¥?•˜?Š” ë³??ˆ˜
			//0ë²ˆì§¸ ?¸?±?Š¤?“¤?—?Š” ?–‰ ?˜¹?? ?—´?˜ ?•©. 0,0?—?Š” ? „ì²´í•©
			int arr[][] = new int[n+1][m+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					arr[i][j]= sc.nextInt();
//					arr[0][0] += arr[i][j];
				}
			}
			System.out.println("---");
			for (int i = 0; i <= n; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}			
			System.out.println("---input check");
			
			//ë¶„í• ?•´?„œ ?•˜?‹ˆ ?”±?ˆ ?•„?š”?—†?Œ.
//			//?–‰?˜ ?•© êµ¬í•´?„£ê¸?
//			for (int i = 0; i < arr.length; i++) {
//				arr[i][0] = rowSum(i, 1, arr.length-1, arr);
//			}
//			//?—´?˜ ?•© êµ¬í•´?„£ê¸?
//			for (int i = 0; i < arr.length; i++) {
//				arr[0][i] = colSum(1, arr.length-1, i, arr);
//			}
//			//?–‰? ¬ ?™„?„±
			
			
			
			
			
			
			
			
			
			
			
			
			//?‹¤ë¥? ë°©ë²• ?‘?„±? „.
//			//ëª‡ë²ˆ ?ë¥´ëŠ”ì§? ê³„ì‚°
//			int cut = calculateCutting(n, m);
//			int v;
//			int h;
//			int idx;
//			//ì´? ?ë¥´ëŠ” ?šŸ?ˆ˜ë§Œí¼ ë°˜ë³µë¬?
//			for (int i = 0; i < cut; i++) {
//				//???´
//				//?˜ë¦°ê³³ ì²´í¬?•´?„œ x1, x2 ?• ?‹¹?•˜?Š”?° ì´ˆê¸°ê°’ì? ë°°ì—´ ? „ì²?
//				int x1 = 1, x2 = arr.length;
//				int y1 = 1, y2 = arr.length;
//				int temp[] = new int[2];
//				
//				
//			}
			
			
			
			
			System.out.printf("#%d %lld\n", test_case, 
					findResult(arr, 1, arr.length, 1, arr.length));
//			System.out.printf("%d %d %d\n", n, m, sum);
//			System.out.printf("#%d %d\n", test_case, calculateCutting(n,m,sum));
		}
	}
	//?¬ê·?ë¡? ??ê¸?. x1~x2, y1~y2 ë°°ì—´?„ ?˜ ?˜?¼ë¥´ê³  ?•©?‚˜?˜¤?Š”ê±? ë¦¬í„´
	static long findResult(int[][] arr, int x1, int x2, int y1, int y2) {
		//1x1?˜ë©? ë°°ì—´ ê°? ë¦¬í„´
		if(x1 == x2 && y1 == y2) {
			return arr[x1][y1];
		}
		System.out.printf("----%d %d %d %d\n",x1, x2, y1, y2);
		//?ë¥? ?œ„ì¹? ì°¾ê¸°
		long [] temp;
		temp = findLowSumPair(arr, x1, x2, y1, y2);
		System.out.println(Arrays.toString(temp));
		if(temp[0] == 1) { // ê°?ë¡œë¡œ ?ë¥? ê²?
			if(temp[3] == 1) { //?°ìª? ?ë¥¸ê²ƒ
				return findResult(arr, x1, (int) temp[1] , y1, y2)
						+ findResult(arr, (int) temp[1]+1, x2, y1, y2);
			}
			else {
				return findResult(arr, x1, (int) temp[1]-1 , y1, y2)
						+ findResult(arr, (int) temp[1], x2, y1, y2);
			}
		}
		else { // ?„¸ë¡œë¡œ ?ë¥¸ê²ƒ
			if(temp[3] == 1) { //?°ìª? ?ë¥¸ê²ƒ
				return findResult(arr,y1, y2, x1, (int) temp[1] )
						+ findResult(arr, y1, y2, (int) temp[1]+1, x2);
			}
			else {
				return findResult(arr,y1, y2, x1, (int) temp[1]-1 )
						+ findResult(arr, y1, y2, (int) temp[1], x2);
			}
		}
		
		//?ë¥´ê³  ?‚œ ?‹¤?Œ ê°ë?ë¶„ì—?„œ ?”°ë¡? ì°¾ê¸°.
	}

	static long[] findLowSumPair(int[][] arr, int x1, int x2, int y1, int y2) {
		System.out.println();
		long result[][] = new long[calculateCutting(x2,  y2)][4];
		System.out.println(calculateCutting(x2,  y2));
		//[][0] = ?–‰?¸ì§? ?—´?¸ì§? 1- ê°?ë¡? 0 - ?„¸ë¡?
		//[][1] = ëª‡ë²ˆì§? ?¸?±?Š¤?¸ì§?.
		//[][2] = ?ë¥´ê³  ?‚œ ?‹¤?Œ ?–‘ìª? ê°’ì¤‘ ?° ê°? ???¥
		//[][3] = 0 -> ?™¼ìª? 1 -> ?˜¤ë¥¸ìª½(?°ìª?)
		int idx =0;
		//ê°?ë¡œë¡œ ?ë¥´ë©´?„œ ê°’ë“¤ ???¥
		//0 = row		
		for (int i = 2; i < arr.length-1; i++) {
			result[idx][0] = 0;
			result[idx][1] = i;
			// max ê°? ?™¼ìª½ì´ë©? ?˜¤ë¥¸ìª½ ?ë¥? ê²? ?˜¤ë¥¸ìª½?´ë©? ?™¼ìª? ?ë¥? ê²?
			long leftcut= arrSum(arr, i, x2, y1, y2);
			long rightcut=arrSum(arr, x1, i, y1, y2);
			if(leftcut < rightcut) {
				result[idx][3] = 1;
				result[idx][2] = rightcut;
			}
			else {
				result[idx][2] = leftcut;
			}		
//			result[idx][2] = Math.max(arrSum(arr, x1, i, y1, y2), 
//					arrSum(arr, i, x2, y1, y2));
			idx++;
		}
		for (int i = 1; i < arr.length-1; i++) {
			result[idx][0] = 1;
			result[idx][1] = i;
			long leftcut =arrSum(arr, x1, x2, i, y2);
			long rightcut=arrSum(arr, x1, x2, y1, i);
			if(leftcut < rightcut) {
				result[idx][3] = 1;
				result[idx][2] = rightcut;
			}
			else {
				result[idx][2] = leftcut;
			}
//			result[idx][2] = Math.max(arrSum(arr, x1, x2, y1, i), 
//					arrSum(arr, x1, x2, i, y2));
			idx++;
		}	
		return result[findMin(result)];
	}
	
	static int findMin(long[][] arr) {
		System.out.println("In Find Min");
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			minIndex = (int) Math.min(arr[i][2], arr[minIndex][2]);
		}
		return minIndex;
	}
	
	static long arrSum(int[][] arr, int x1, int x2, int y1, int y2) {
		System.out.println("In ArrSum");
		long result = 0;		
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				result += arr[i][j];
			}
		}		
		System.out.printf("%d %d %d %d sum=%d\n", x1, x2, y1, y2, result);
		return result;
	}
	
	
//----------------------------------------------------------------------------	
	//0ë²ˆì¸?±?Š¤ë¥? ì°¸ì¡°?•˜ë©´ì„œ y1~y2?‚¬?´?— ê°??¥ ?° ?•©?´ ?ˆ?Š” ?¸?±?Š¤ ë¦¬í„´
	static int rowSumMaxIndex(int y1, int y2, int[][]arr) {
		int mIndex = y1;
		int max = arr[0][y1];
		for (int i = y1+1; i <= y2; i++) {
			if( max <arr[0][i] ) {
				mIndex = i;
				max = arr[0][i];
			}
		}
		return mIndex;
	}	
	static int colSumMaxIndex(int x1, int x2, int[][]arr) {
		int mIndex = x1;
		int max = arr[x1][0];
		for (int i = x1+1; i <= x2; i++) {
			if( max <arr[i][0] ) {
				mIndex = i;
				max = arr[i][0];
			}
		}
		return mIndex;
	}
	
	//?–‰?˜ ?•© êµ¬í•˜ê¸?
	//x?–‰?˜ y1 ë¶??„° y2ê¹Œì? ?•© êµ¬í•˜ê¸?.
	static int rowSum(int x, int y1, int y2, int[][]arr) {
		int sum=0;
		for (int i = y1; i <= y2; i++) {
			sum+= arr[x][i];
		}
		return sum;
	}
	//?—´?˜ ?•© êµ¬í•˜ê¸?
	static int colSum(int x1, int x2, int y, int[][]arr) {
		int sum=0;
		for (int i = x1; i <= x2; i++) {
			sum+= arr[i][y];
		}
		return sum;
	}
	
	//?ë¥´ëŠ” ?šŸ?ˆ˜ ê³„ì‚°
	static int calculateCutting(int n, int m) {
//		return (((n-1) * grape) + (((m-1)*n) * grape));
		System.out.printf("nm - %d %d\n", n, m);
		if(n==1)
			return m-1;
		if(m==1)
			return n-1;
		return ((n-1) + (m-1)*n);
	}
	
}
