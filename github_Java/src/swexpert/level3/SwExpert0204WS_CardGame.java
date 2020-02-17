package swexpert.level3;

class SwExpert0204WS_CardGame{
	public static void main(String[] args) {
		int n = 0x00111111;
		if((n&0xff) != 0) {
			System.out.println("little");
		}else {
			System.out.println("big");
		}
	}
}