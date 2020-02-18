package app;

import java.util.Random;

public class App2 {
    public static void main(String[] args) throws Exception {
    	Random r = new Random();
    	int n = 15;
    	System.out.println(n);
    	for (int i = 0; i < n; i++) {
    		int t = r.nextInt(97)+3;
    		System.out.println(t);
    		for (int j = 0; j < t; j++) {
//				System.out.print(r.nextInt((int)Math.pow(2, 31)) + " ");
    			System.out.print(r.nextInt(2) + " ");
			}
    		System.out.println();
		}
    	
       
    }
}