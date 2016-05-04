import java.lang.*;

public class Oef1_17 {

	public static void main(String args[]) {

	
	//////Oef 1 Tafels
	System.out.println("Oef 1");
	int k;
	for (int i = 1; i < 10 ; i++) {
		for (int j = 1; j < 10; j++) {
			k = i * j;
			System.out.println(i + " x " + j + " = " + k );
		}
	}
	
	//////Oef 2 Dagen van de maand februari
	System.out.println("Oef 2");	
	int p = 0;
	int p2 = 0;
	for (int x = 1; x < 29; x++) {
		p++;
		if (p == 9){
			p = 1;
			p2++;
		}
		if (x == 1 + 7 * p2) {
			System.out.println("zondag " + x + " februari");
		}
		if (x == 2 + 7 * p2) {
			System.out.println("maandag " + x + " februari");
		}
		if (x == 3 + 7 * p2) {
			System.out.println("dinsdag " + x + " februari");
		}
		if (x == 4 + 7 * p2) {
			System.out.println("woensdag " + x + " februari");
		}
		if (x == 5 + 7 * p2) {
			System.out.println("donderdag " + x + " februari");
		}
		if (x == 6 + 7 * p2) {
			System.out.println("vrijdag " + x + " februari");
		}
		if (x == 7 + 7 * p2) {
			System.out.println("zaterdag " + x + " februari");
		}
		}
		
	
	//////Oef 3 Bereken Pi
	System.out.println("Oef 3");
	float pi = 0;
	int neg = 1;
	for(int i = 1; i <= 1000; i+= 2){
		pi += neg * (1.0f/i);
		neg *= -1;
	}	
	pi *= 4;
	System.out.println("Pi = " + pi);
	
	
	
	//////Oef 4 Getal 4302
	System.out.println("Oef 4");
	int getal = 4302;
	getal = ~getal + 1;
	System.out.println(getal);
	
	
	
	//////Oef 5 Priemgetallen onder 100
	System.out.println("Oef 5");
	int grootstegetal = 100;
	boolean primeNb = true;
	for (int i = 0; i < grootstegetal; i++) {
		for (int j = 3; j < i; j++) {
			if ( i%j == 0) {
			primeNb = false;
			}
		}
		if(primeNb) {
		System.out.println(i + " is a primenumber.");
		}
	primeNb = true;
	}
	
	
	//////Oef 6 Grootste getal uit array
	System.out.println("Oef 6");
	int a[] = {12,34,56,78,123,234,99,88};
	int hoogsteGetal = 0;
	for (int i = 0; i < 8; i++)
	{
		if (a[i] > hoogsteGetal)
		{
			hoogsteGetal = a[i];
		} 
	}
	System.out.println(hoogsteGetal);
	
	
	////Oef 7 Array
	System.out.println("Oef 7");	
	int a_2[] = {12,34,56,78,123,234,99,88};
	int b_Gesorteerd[] = new int[8];
	
	for(int j = 0; j < 8 ; j++) {
		int hoogsteGetal_2 = 0;
		int indexNm = 0;
		for (int i = 0; i < 8; i++)
		{
			if (a_2[i] > hoogsteGetal_2)
			{
				hoogsteGetal_2 = a_2[i];
				indexNm = i;
			} 
		} 
		b_Gesorteerd[j] = hoogsteGetal_2;
		a_2[indexNm] = 0;
		System.out.println(b_Gesorteerd[j]);
	}	
}
}