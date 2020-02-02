package swexpert.level2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Base64Decoder_1928 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\level2\\Base64Decoder_1928.txt"));
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        //3글자를 하나의 단위로 처리해야함
        //2진수로 글자를 보고 6비트씩 쪼개서 바꾸기.
        for (int test_case = 1; test_case <= TC; test_case++) {
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                System.out.println(Integer.toBinaryString(s.charAt(i)) + " " + s.charAt(i)
                + (int)s.charAt(i));
            } 
            //shift로 시프트하는거 횟수 조절. 0~5번, 6~11, 12~17, 18~23
            //글자 3개를 4개로 인코딩한게 입력임.
            //입력값 4개를 하나로 묶어서 2진수로 쭉 나열하고 8개씩 끊어서 디코딩.
            /*
            원문 : Lif넣으면

01001100 01101001 01100110
//6개씩 자르면
010011 000110 100101 100110
19	6	37       38

인풋 데이터를 4글자씩 끊어서 사용해야됨.
한글자씩 2진수로 바꾼다음 6비트씩만 붙여 24비트로 만들기.
24비트를 8비트씩 쪼개서 글로 변환하면 원문이 나옴.
            */
        //    int shift = 0;
            
            System.out.println();
        }
        

    }
}