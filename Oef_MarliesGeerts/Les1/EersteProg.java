import java.lang.*;
/**
Oefening Labo Digitale Broadcast
@author Marlies
*/ 
public class EersteProg {

/** 
Dit is de main functie die opstart bij het begin van het programma.
*/
	public static void main(String args[]) {
		//System.out.println("Dit is mijn eerste Java programma\n");
		drukaf(100);
	}
/** 
Deze functie zorgt ervoor dat een bepaalde hoeveelheid getallen afgedrukt worden op het scherm.
*/	
	public static void drukaf(int n) { //Moet public staan voordat het in de JavaDoc staat.
		int a;
		for	(a = 0; a < n ; a++) {
			System.out.println(a);
		}
}
}