public class Fatorial {
	public static void main(String args[]) {
        	int i = 0, fatorial = 1;
		do{ 
			fatorial *=  i + 1;
			System.out.printf("Fatorial de %d: %d\n", i+1, fatorial);
			i++;
			 
		}while(i < 10);
	}
}
