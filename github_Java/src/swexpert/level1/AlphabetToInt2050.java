package swexpert.level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class AlphaberToInt2050 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src\\swexpert\\level1\\AlphabetToInt2050.txt"));
        Scanner sc = new Scanner(System.in);
        String alphabetString = sc.next();
        for (int i = 0; i < alphabetString.length(); i++) {
            System.out.print(alphabetString.charAt(i) - 64 +  " ");
        } 
        sc.close();
    }
}