package jungol;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Jungol1828 {
	static LinkedList<Celsius> list = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int min, max;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			min = sc.nextInt();
			max = sc.nextInt();
//			System.out.printf("min max %d %d%n", min, max);
			list.add(new Celsius(min, max));
		}
//		list.sort(Comparator.comparing(Celsius::getMin).thenComparing(Celsius::getMax));
		
//		list.sort(new Comparator<Celsius>() {
//			@Override
//			public int compare(Celsius o1, Celsius o2) {
//				// TODO Auto-generated method stub
//				return o1.getMin() - o2.getMin();
//			}
//		});
//		list.sort(new Comparator<Celsius>() {
//			@Override
//			public int compare(Celsius o1, Celsius o2) {
//				// TODO Auto-generated method stub
//				return o1.getMax() - o2.getMax();
//			}
//		});
		
		Collections.sort(list);
		
		list.stream().forEach(x -> System.out.println(x));
		int answer = 1;
//		min = list.peekFirst().min;
		max = list.peekFirst().max;
		for (Celsius celsius : list) {
			//min이 같으면 넘어감
//			if(min == celsius.min) {
//				continue;
//			}
//			min = celsius.min;
//			if(celsius.max < max) {
//				max = celsius.max;
//				continue;
//			}
			if(celsius.min > max) {
				answer++;
//				min = celsius.min;
				max = celsius.max;
//				System.out.printf("%d %d change%n", min, max);
			}
		}
		System.out.println(answer);
			
			
			
			
			
			
//			for (int j = 0; j < list.size(); j++) {
//				Celsius temp = list.get(j);
//				//min max가 기존 것보다 다 범위가 클때
//				if(min <= temp.min && max >= temp.max) {
//					flag = 1;
//					System.out.println("cut- " + j);
//					break;
//				}
//				
//				//민 or 맥스가 기존 것안에 있을 떄
//				if((min >= temp.min && temp.max >= min) || (max <= temp.max && max  >= temp.min)) {
//					System.out.println("cut " + j);
//					//입력받은 min이 기존 것 범위안에 있을때 
////					if(min >= temp.min && temp.max >= min) {
////						temp.min = min;
////					}
////					//입력받은 max가 기존것 안에 있을 때
////					if(max <= temp.max && max  >= temp.min) {
////						temp.max = max;
////					}
//					temp.min = min;
//					temp.max = max;
//					flag = 1;
//					break;
//				}
//			}
//			if(flag == 0) {
//				list.add(new Celsius(min, max));
//				list.sort(Comparator.comparing(Celsius::getMin));
//				System.out.println("------------------------------");
//			}
//			list.stream().forEach(s -> System.out.printf("%d %d%n", s.min, s.max));
//			System.out.println();
//			flag = 0;
//		}
//		System.out.println(list.size());
		
		
		
	}
	
	static class Celsius implements Comparable<Celsius>{
		int min;
		int max;
		public Celsius(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		@Override
		public String toString() {
			return "Celsius [min=" + min + ", max=" + max + "]";
		}
		@Override
		public int compareTo(Celsius o) {
			// TODO Auto-generated method stub
			return max - o.max;
		}
	}
	
}
