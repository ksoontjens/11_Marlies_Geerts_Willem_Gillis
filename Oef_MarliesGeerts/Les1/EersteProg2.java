import java.lang.*;

public class EersteProg2 {

	public static void main(String args[]) {
	
		for( int i = 55; i > 34;i--) {
		System.out.println(i);
		}
		
		int b = 55;
		while (b > 34) {
		System.out.println(b);
		b--;
		}
		
		System.out.println(~10);
		// 0000 1010   = 10
		// 1111 0101   = -11   (negatief want 2's complement)
	}
}