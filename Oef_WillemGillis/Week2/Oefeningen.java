
public class Oefeningen
{
	static int oefNumber = 1;
	public static void main(String args[]) {
		//Oefeningen pagina 31
		//Oefening 1
		nextExercise();
		Werknemer Judy = new Werknemer("Judy", "Something", 0, 5000);
		Werknemer George = new Werknemer("George", "Bad", 1, 3000);
		Werknemer Juliet = new Werknemer("Juliet", "Gorgeous", 2, 3500);
		Werknemer Max = new Werknemer("Max", "Stupid", 3, 2900);
		
		//Oefening 2
		nextExercise();
		Judy.salarisVerhogen(10);
		George.salarisVerhogen(10);
		System.out.println(Judy.getSalaris());
		System.out.println(George.getSalaris());
		System.out.println(Juliet.getSalaris());
		System.out.println(Max.getSalaris());
		
		//Oefening 3
		nextExercise();
		PartTimeWerknemer Nicolas = new PartTimeWerknemer("Juliet", "Gorgeous", 100, 3500, 5);
		PartTimeWerknemer Suzy = new PartTimeWerknemer("Suzy", "Gorgeous", 101, 3500, 32);
		
		//Oefening 4
		nextExercise();
		Nicolas.salarisVerhogen(10);
		System.out.println(Nicolas.getSalaris());
		System.out.println(Suzy.getSalaris());
		
		//Oefening 5
		nextExercise();
		
		//Oefening 6
		nextExercise();
		Judy.setRSZ(52.0f);
		Suzy.setRSZ(52.0f);
		System.out.println(Judy.getRSZ());
		System.out.println(George.getRSZ());
		System.out.println(Juliet.getRSZ());
		System.out.println(Max.getRSZ());
		System.out.println(Nicolas.getRSZ());
		System.out.println(Suzy.getRSZ());	

		//Oefening 7
		nextExercise();	
		
		//Oefening 8
		nextExercise();		
		StudentWerknemer Mikey = new StudentWerknemer("Mikey", "Bored", 200, 3500, 32);
		System.out.println(Mikey.getRSZ());
		
		//Oefening 9
		nextExercise();	
		Mikey.betaal();
		Judy.betaal();
		Nicolas.betaal();
		
		//Oefening 10
		nextExercise();	
		Faktuur test = new Faktuur(0, 5000);
		test.betaal();
	}
	
	private static void nextExercise(){
		System.out.println("\nDit is oefening: " + oefNumber++ + " --------------------------------------");
	}
}