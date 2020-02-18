package swexpert.level.study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SwExpert8888_2 {
	
	static class Person{
		int idx;
		int score;
		int correct;
		public Person(int idx) {
			this.idx = idx;
		}
		public Person(int idx, int score, int correct) {
			this.idx = idx;
			this.score = score;
			this.correct = correct;
		}
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getCorrect() {
			return correct;
		}
		public void setCorrect(int correct) {
			this.correct = correct;
		}
		@Override
		public String toString() {
			return "Person [idx=" + idx + ", score=" + score + ", correct=" + correct + "]";
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int N;
		int T;
		int P;
		int[][] arr;
		int[] cf;
		Integer[][] score;
//		Integer score[][];
		for (int test_case = 1; test_case <= TC; test_case++) {
			//사람수
			N = sc.nextInt();
			//문제수
			T = sc.nextInt();
			//표적
			P = sc.nextInt()-1;
			sc.nextLine();
			String[] temp;
			arr = new int[N][T];
			cf = new int [T];
			for (int j = 0; j < N; j++) {
				temp = sc.nextLine().split(" ");
				for (int i = 0; i < T; i++) {
					arr[j][i] = Integer.parseInt(temp[i]);
					if ( arr[j][i] == 0 ) {
						cf[i]++; 
					}
				}
			}
//			System.out.println(Arrays.deepToString(arr));
			ArrayList<Person> list = new ArrayList<Person>(N);
			int ts =0;
			int tc = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < T; j++) {
					if(arr[i][j] == 1 ) {
						ts += cf[j];
						tc++;
					}
				}
				list.add(new Person(i, ts, tc));
				ts =0;
				tc =0;
			}

//			list.stream().forEach(System.out::println);
			
			list.sort(Comparator.comparing(Person::getScore).thenComparing(Person::getCorrect).reversed());
//			System.out.println();
//			list.stream().forEach(System.out::println);
			int idx = 1;
			for (Person a : list) {
				if(a.getIdx() == P) {
					System.out.printf("#%d %d %d%n", test_case, a.getScore(), idx);
					break;
				}
				idx++;
			}
			
			
		}
		
		
		
	}
	
	
}
