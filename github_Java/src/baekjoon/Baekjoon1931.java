package baekjoon;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.security.auth.x500.X500Principal;
import javax.swing.table.TableModel;

public class Baekjoon1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		LinkedList<ghldml> list = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			list.add(new ghldml(sc.nextInt(), sc.nextInt()));
		}
//		list.stream().forEach(System.out::println);
		list.sort(Comparator.comparing(ghldml::getEnd).thenComparing(ghldml::getStart));
//		list.stream().forEach(System.out::println);
		int answer=0;
		int end=0;
		for (ghldml temp : list) {
			if(temp.getStart() >= end) {
				end = temp.getEnd();
				answer++;
			}
		}
		System.out.println(answer);
		
	}
	
	static class ghldml{
		int start;
		int end;
		ghldml(int s, int e){
			start = s;
			end = e;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		@Override
		public String toString() {
			return "ghldml [start=" + start + ", end=" + end + "]";
		}
		
	}
	
}
