public class CoisasComX {
	public static void main(String args[]) {
		int x = Integer.parseInt(args[0]);
		do {
			// par
			if(x%2 == 0){
				x /= 2;	
			} else {
				x = 3 *x + 1;
			}
			System.out.print(x + " > ");
		} while (x  != 1);
		System.out.print("\b\b");
	}
}
