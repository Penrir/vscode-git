package swexpert.level.study;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwExpert9280 {
	static Integer[] price;
	static int[] weight;
	static 	int[] deck ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int n = sc.nextInt(); // 단위무게당 요금 들어올갯수
			int m = sc.nextInt(); // 차량의 무게 들어올 갯수
			int answer = 0;
			price = new Integer[n];
			weight = new int[m];
			for (int i = 0; i < price.length; i++) {
				price[i]= sc.nextInt(); 
			}
			for (int i = 0; i < weight.length; i++) {
				weight[i]= sc.nextInt(); 
			}
//			Arrays.sort(price, new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					// TODO Auto-generated method stub
//					return o2-o1;
//				}
//			});
			System.out.println(Arrays.toString(price));
			System.out.println(Arrays.toString(weight));
			
			deck = new int[price.length];
			Queue<Integer> queue = new LinkedList<Integer>(); 
			int operation;
			loop:
			for (int i = 0; i < m*2; i++) {
				operation = sc.nextInt();
			//	System.out.println(operation);
				//차량 나갈때
				if(operation < 0) {
					for (int j = 0; j < deck.length; j++) {
						if(deck[j] == Math.abs(operation) ) {
							deck[j] = 0;
							//차량 빠졌을때 대기중이니 차량이 있다면
							if(queue.size() > 0) {
								deck[j] = queue.poll(); 
								answer += price[j] * weight[deck[j]-1];
								System.out.println(answer + " " + j + " " + operation);
							}
							continue loop;
						}
					}
				}
				//차량 들어올때
				//주차장 꽉차면
				if(checkDeck() < 0) {
					queue.offer(operation);
					continue;
				}
				//주차장에 자리 있다면
				for (int j = 0; j < deck.length; j++) {
					//자리 찾음
					if(deck[j]== 0 ) {
						deck[j]= operation; 
						answer += price[j] * weight[deck[j]-1];
						System.out.println(answer + " " + j + " " + operation);
						break;
					}
				}
			}
			// 차량 들어올 때는 deck검사해서 비어있는 곳 있으면 거기다 넣음.
			// 덱에 차량이 있으면 1 없으면 0;
			// 만약에 deck가 가득 찼다면 큐에 넣어서 대기
			// 차량이 나가는 입력이 들어올 시 큐에 차량이 대기하고 있는지 체크하고 대기중이라면 빠진 곳으로 차량 넣기
			//차량을 넣으면서 요금 계산하기.
			
			System.out.printf("#%d %d%n", test_case, answer);
			
			
			
			
		}
		
		
	}
	//꽉차면 -1리턴 아니면 인덱스값리턴
	static int checkDeck() {
		for (int i = 0; i < deck.length; i++) {
			if(deck[i]== 0 ) {
				return i;
			}
		}
		return -1;
	}
	
}
