package baekjoon;

import java.util.Scanner;

public class BaekJoon11723 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] temp;
		int check = 0;
		int shift = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			temp = sc.nextLine().split(" ");
//			System.out.print("           "+ temp[0] + " ");
//			if( temp.length > 1) {
//				System.out.println(temp[1]);
//			}
			switch(temp[0].charAt(1)) {
			case 'd':
//				System.out.print(temp[0] + " ");
				shift = Integer.parseInt(temp[1]);
				check = (check | (1 << shift)) ;
				break;
			case 'h':
//				System.out.print(temp[0] + " ");
				shift = Integer.parseInt(temp[1]);
//				System.out.print("            ");
//				System.out.println( (check & (1 << shift)) != 0 ? "1" : "0" );
				sb.append((check & (1 << shift)) != 0 ? "1" : "0" );
				sb.append("\n");
				break;
			case 'e':
//				System.out.print(temp[0] + " ");
//				System.out.print(temp[0] + " ");
				shift = Integer.parseInt(temp[1]);
				check = (check & (~(1 << shift))) ;
				break;
				//아직 토글 미완성
			case 'o':
//				System.out.print(temp[0] + " ");
				shift = Integer.parseInt(temp[1]);
				//한방에 하는건 모르겠고 그냥 삼항연산자 써서 바꾸기
//				check = check^(check) ;
//				System.out.println("---" + (check & (1<<shift)));
				if((check & (1<<shift)) != 0)
					check = (check & (~(1 << shift))) ;
				else {
					check = (check | (1 << shift)) ;
				}
			
				break;
			case 'l':
//				System.out.print(temp[0] + " ");
				check = (0xffffff | check);
				break;
			case 'm':
//				System.out.print(temp[0] + " ");
				check = 0;
				break;
			}
//			switch(temp[0]) {
//			case "add":
////				System.out.print(temp[0] + " ");
//				shift = Integer.parseInt(temp[1]);
//				check = (check | (1 << shift)) ;
//				break;
//			case "check":
////				System.out.print(temp[0] + " ");
//				shift = Integer.parseInt(temp[1]);
////				System.out.print("            ");
////				System.out.println( (check & (1 << shift)) != 0 ? "1" : "0" );
//				sb.append((check & (1 << shift)) != 0 ? "1" : "0" );
//				sb.append("\n");
//				break;
//			case "remove":
////				System.out.print(temp[0] + " ");
////				System.out.print(temp[0] + " ");
//				shift = Integer.parseInt(temp[1]);
//				check = (check & (~(1 << shift))) ;
//				break;
//				//아직 토글 미완성
//			case "toggle":
////				System.out.print(temp[0] + " ");
//				shift = Integer.parseInt(temp[1]);
//				//한방에 하는건 모르겠고 그냥 삼항연산자 써서 바꾸기
////				check = check^(check) ;
////				System.out.println("---" + (check & (1<<shift)));
//				if((check & (1<<shift)) != 0)
//					check = (check & (~(1 << shift))) ;
//				else {
//					check = (check | (1 << shift)) ;
//				}
//				
//				break;
//			case "all":
////				System.out.print(temp[0] + " ");
//				check = (0xffffff | check);
//				break;
//			case "empty":
////				System.out.print(temp[0] + " ");
//				check = 0;
//				break;
//			}
			
//			System.out.println("binarynum  " + Integer.toBinaryString(check));
		}
		System.out.println(sb);
		
	}
}
