package swexpert.level3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Swexpert9282 {
	static boolean V[]; // ?μ§μΌλ‘? ?λ₯? κ³? μ²΄ν¬
	static boolean H[]; // ???Όλ‘? ?λ₯? κ³? μ²΄ν¬
	
	
	public static void main(String[] args) throws FileNotFoundException {
		int TC;
		System.setIn(new FileInputStream("src/com/swexpert/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(n + " " + m);
			//?λ₯΄λκ±? n-1 or m-1λ²μ© ?λ₯΄λ?° 0λ²μΈ?±?€?? ?©?€?΄ ?€?΄??Όλ―?λ‘?
			//n,mκ°μ© ? ?Ή
			//λΆν ?΄? ?? ?±? ????.
//			V = new boolean[m]; //?μ§μΌλ‘? ?λ₯Έλ?λΆ? ???₯?΄?? λ³??
//			H = new boolean[n];
			long result = 0; //μ§?λΆν΄?Ό?? κ±΄ν¬? ?© ???₯?? λ³??
			//0λ²μ§Έ ?Έ?±?€?€?? ? ?Ή?? ?΄? ?©. 0,0?? ? μ²΄ν©
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
			
			//λΆν ?΄? ?? ?±? ????.
//			//?? ?© κ΅¬ν΄?£κΈ?
//			for (int i = 0; i < arr.length; i++) {
//				arr[i][0] = rowSum(i, 1, arr.length-1, arr);
//			}
//			//?΄? ?© κ΅¬ν΄?£κΈ?
//			for (int i = 0; i < arr.length; i++) {
//				arr[0][i] = colSum(1, arr.length-1, i, arr);
//			}
//			//?? ¬ ??±
			
			
			
			
			
			
			
			
			
			
			
			
			//?€λ₯? λ°©λ² ??±? .
//			//λͺλ² ?λ₯΄λμ§? κ³μ°
//			int cut = calculateCutting(n, m);
//			int v;
//			int h;
//			int idx;
//			//μ΄? ?λ₯΄λ ??λ§νΌ λ°λ³΅λ¬?
//			for (int i = 0; i < cut; i++) {
//				//???΄
//				//?λ¦°κ³³ μ²΄ν¬?΄? x1, x2 ? ?Ή???° μ΄κΈ°κ°μ? λ°°μ΄ ? μ²?
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
	//?¬κ·?λ‘? ??κΈ?. x1~x2, y1~y2 λ°°μ΄? ? ??Όλ₯΄κ³  ?©??€?κ±? λ¦¬ν΄
	static long findResult(int[][] arr, int x1, int x2, int y1, int y2) {
		//1x1?λ©? λ°°μ΄ κ°? λ¦¬ν΄
		if(x1 == x2 && y1 == y2) {
			return arr[x1][y1];
		}
		System.out.printf("----%d %d %d %d\n",x1, x2, y1, y2);
		//?λ₯? ?μΉ? μ°ΎκΈ°
		long [] temp;
		temp = findLowSumPair(arr, x1, x2, y1, y2);
		System.out.println(Arrays.toString(temp));
		if(temp[0] == 1) { // κ°?λ‘λ‘ ?λ₯? κ²?
			if(temp[3] == 1) { //?°μͺ? ?λ₯Έκ²
				return findResult(arr, x1, (int) temp[1] , y1, y2)
						+ findResult(arr, (int) temp[1]+1, x2, y1, y2);
			}
			else {
				return findResult(arr, x1, (int) temp[1]-1 , y1, y2)
						+ findResult(arr, (int) temp[1], x2, y1, y2);
			}
		}
		else { // ?Έλ‘λ‘ ?λ₯Έκ²
			if(temp[3] == 1) { //?°μͺ? ?λ₯Έκ²
				return findResult(arr,y1, y2, x1, (int) temp[1] )
						+ findResult(arr, y1, y2, (int) temp[1]+1, x2);
			}
			else {
				return findResult(arr,y1, y2, x1, (int) temp[1]-1 )
						+ findResult(arr, y1, y2, (int) temp[1], x2);
			}
		}
		
		//?λ₯΄κ³  ? ?€? κ°λ?λΆμ? ?°λ‘? μ°ΎκΈ°.
	}

	static long[] findLowSumPair(int[][] arr, int x1, int x2, int y1, int y2) {
		System.out.println();
		long result[][] = new long[calculateCutting(x2,  y2)][4];
		System.out.println(calculateCutting(x2,  y2));
		//[][0] = ??Έμ§? ?΄?Έμ§? 1- κ°?λ‘? 0 - ?Έλ‘?
		//[][1] = λͺλ²μ§? ?Έ?±?€?Έμ§?.
		//[][2] = ?λ₯΄κ³  ? ?€? ?μͺ? κ°μ€ ?° κ°? ???₯
		//[][3] = 0 -> ?Όμͺ? 1 -> ?€λ₯Έμͺ½(?°μͺ?)
		int idx =0;
		//κ°?λ‘λ‘ ?λ₯΄λ©΄? κ°λ€ ???₯
		//0 = row		
		for (int i = 2; i < arr.length-1; i++) {
			result[idx][0] = 0;
			result[idx][1] = i;
			// max κ°? ?Όμͺ½μ΄λ©? ?€λ₯Έμͺ½ ?λ₯? κ²? ?€λ₯Έμͺ½?΄λ©? ?Όμͺ? ?λ₯? κ²?
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
	//0λ²μΈ?±?€λ₯? μ°Έμ‘°?λ©΄μ y1~y2?¬?΄? κ°??₯ ?° ?©?΄ ?? ?Έ?±?€ λ¦¬ν΄
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
	
	//?? ?© κ΅¬νκΈ?
	//x?? y1 λΆ??° y2κΉμ? ?© κ΅¬νκΈ?.
	static int rowSum(int x, int y1, int y2, int[][]arr) {
		int sum=0;
		for (int i = y1; i <= y2; i++) {
			sum+= arr[x][i];
		}
		return sum;
	}
	//?΄? ?© κ΅¬νκΈ?
	static int colSum(int x1, int x2, int y, int[][]arr) {
		int sum=0;
		for (int i = x1; i <= x2; i++) {
			sum+= arr[i][y];
		}
		return sum;
	}
	
	//?λ₯΄λ ?? κ³μ°
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
