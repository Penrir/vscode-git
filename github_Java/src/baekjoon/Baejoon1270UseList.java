package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//전쟁 땅따먹기
public class Baejoon1270UseList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Team> list = new ArrayList<>();
		int n = sc.nextInt();
		int temp;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			int answer = 0;
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				temp = sc.nextInt();
				//arr에 팀번호와 병사수넣기
				idx = findNo(list, temp);
				//팀이 없는 상태에서 처음 들어오면 1명으로 추가함.
				//이미 존재하는 팀 병사면 병사수+1
				if(idx == -1) {
					list.add(new Team(temp, 1));
				}
				else {
					list.get(idx).count++;
				}
			}
			Team[] arr = list.stream().toArray(Team[]::new);
			for (int j = 0; j < arr.length; j++) {
//				System.out.println(arr[j]);
				if(arr[j].count > t/2) {
					answer = arr[j].no;
				}
			}
			//리스트 돌면서 병사수가 전체 병사수의 절반 넘는 팀 찾기.
//			for (int j = 0; j < list.size(); j++) {
//				if(list.get(j).count > t/2) {
//					answer = list.get(j).no;
//				}
//			}
//			list.stream().forEach(System.out::println);
			if(answer == 0) {
				System.out.println("SYJKGW");
			}else {
				System.out.println(answer);
			}
			answer = -1;
			list.clear();
		}
		sc.close();
	}
	static int findNo(List<Team> list , int no) {
		for (int i = 0; i < list.size(); i++) {
			Team temp = list.get(i);
			if(temp.no == no) {
				return i;
			}
		}
		return -1;
	}
	
	static class Team{
		int no;
		int count;
		Team(int n, int c){
			no = n;
			count = c;
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "Team [no=" + no + ", count=" + count + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + count;
			result = prime * result + no;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			Team other = (Team) obj;
			if (no != other.no)
				return false;
			return true;
		}
		public boolean euqalNo(int n) {
			return n == no ? true: false;
		}
	}
	
}
