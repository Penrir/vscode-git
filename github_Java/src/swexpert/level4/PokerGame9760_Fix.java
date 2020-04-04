package swexpert.level4;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InvalidClassException;

public class PokerGame9760_Fix {
	private static int result = 0;
	public static String[] handCard;
	private static Integer[] counting = new Integer[13];
	private static Integer[] figure = new Integer[4];
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T;
		T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			Arrays.fill(counting, 0);
			Arrays.fill(figure, 0);
			handCard = new String[5];
			handCard = sc.nextLine().split(" ");
			fillArray(handCard);
			
			
			System.out.printf("#%d %s%n", test_case, findResult());
		}
	}
	public static String findResult() {
		int value = straightFlush();
		if(value == 2) {
			return "Royal Straight Flush";
		}
		else if( value == 1) {
			return "Straight Flush";
		}	//if straight flush
		if(fourOfAKind()) {
			return "Four of a Kind";
		}
		if(fullHouse()) {
			return "Full House";
		}
		if(flush()) {
			return "Flush ";
		}
		if(straight() != 0) {
			return "Straight ";
		}
		if(triple()) {
			return "Three of a kind";
		}
		if(twoPair()) {
			return "Two pair";
		}
		if(onePair()) {
			return "One pair";
		}
		return "High card";
	}
	
	public static void fillArray(String[] srr) {
		for (String s : srr) {
			switch (s.charAt(0)) {
			case 'S':
				figure[0]++;
				break;
			case 'D':
				figure[1]++;
				break;
			case 'H':
				figure[2]++;
				break;
			case 'C':
				figure[3]++;
				break;
			}
			switch (s.charAt(1)) {
			case 'A':
				counting[0]++;
				break;
			case '2':
				counting[1]++;
				break;
			case '3':
				counting[2]++;
				break;
			case '4':
				counting[3]++;
				break;
			case '5':
				counting[4]++;
				break;
			case '6':
				counting[5]++;
				break;
			case '7':
				counting[6]++;
				break;
			case '8':
				counting[7]++;
				break;
			case '9':
				counting[8]++;
				break;
			case 'T':
				counting[9]++;
				break;
			case 'J':
				counting[10]++;
				break;
			case 'Q':
				counting[11]++;
				break;
			case 'K':
				counting[12]++;
				break;
			}
		}
	}
		
	/**
	 * 
	 * @return 0 = false, 1=true, 2=로티플
	 */
	public static int straightFlush() {
		int idx = 0;
		if(!flush()) return 0;
		idx = straight();
		if(idx == 0) return 0;
		if(idx == 10) {	//10부터 시작
			//로티플
			return 2;
		}
		return 1;
	}
	public static boolean fourOfAKind() {
		//4card
		for (int i = 0; i < counting.length; i++) {
			if(counting[i] == 4) return true;
		}
		return false;
	}
	public static boolean fullHouse() {
		boolean two = false;
		boolean three = false;
		for (int i = 0; i < counting.length; i++) {
			if(counting[i]== 2 ) two = true;
			if(counting[i]== 3 ) three = true;
		}
		if(two && three) return true;
		return false;
	}
	public static boolean flush() {
		for (int i = 0; i < figure.length; i++) {
			if(figure[i] == 5 ) return true;
		}
		return false;
	}
	/**
	 * 
	 * @return	0 = false, i = startidx
	 */
	public static int straight() {
		int idx = 0;
		for (int i = 0; i < counting.length; i++) {
			if(counting[i] ==1 &&
					counting[(i+1) % counting.length] == 1 &&
					counting[(i+2) % counting.length] == 1 &&
					counting[(i+3) % counting.length] == 1 &&
					counting[(i+4) % counting.length] == 1) {
//				return i+1;
				idx = i + 1;
			}
		}
		if(idx != 0 && idx < 11) {
			return idx;
		}
		return 0;
	}
	public static boolean triple() {
		for (int i = 0; i < counting.length; i++) {
			if(counting[i] == 3) return true;
		}
		return false;
	}
	public static boolean twoPair() {
		int cnt =0;
		for (int i = 0; i < counting.length; i++) {
			if(counting[i] == 2) ++cnt;
		}
		if(cnt == 2) return true;
		return false;
	}
	public static boolean onePair() {
		int cnt =0;
		for (int i = 0; i < counting.length; i++) {
			if(counting[i] == 2) ++cnt;
		}
		if(cnt == 1) return true;
		return false;
	}
	
}

