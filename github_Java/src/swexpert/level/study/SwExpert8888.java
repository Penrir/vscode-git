package swexpert.level.study;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SwExpert8888 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			
			int N = sc.nextInt();
			int T = sc.nextInt();
			int P = sc.nextInt()-1;
			sc.nextLine();
			String [][] strings = new String[N][T];
			int cf[] = new int [T];
			for (int j = 0; j < N; j++) {
				strings[j] = sc.nextLine().split(" ");  
				for (int i = 0; i < T; i++) {
					if ( strings[j][i].equals("0") ) {
						cf[i]++; 
					}
				}
			}
//			for (int i = 0; i < strings.length; i++) {
//				System.out.println(Arrays.toString(strings[i]));
//			}
//			System.out.println(Arrays.toString(cf));
			Integer score[][] = new Integer[N][2];
			for (int i = 0; i < score.length; i++) {
				Arrays.fill(score[i], 0);
			}
			for (int i = 0; i < strings.length; i++) {
				score[i][0] = i;
				for (int j = 0; j < strings[i].length; j++) {
					if(strings[i][j].equals("1")){
						score[i][1] = score[i][1] + cf[j]; 
					}
				}
			}
//			System.out.println(Arrays.deepToString(score));
			
			int ans1 =0;
			int ans2 =0;
			Arrays.sort(score, new Comparator<Integer[]>() {
				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					// TODO Auto-generated method stub
					return o2[1] - o1[1];
				}
			});
			
			for (int i = 0; i < score.length; i++) {
				if(score[i][0] == P) {
					System.out.printf("#%d %d %d%n", test_case, score[i][1], i+1);
					break;
				}
			}
		}
		
		
		
	}
	
	
}
