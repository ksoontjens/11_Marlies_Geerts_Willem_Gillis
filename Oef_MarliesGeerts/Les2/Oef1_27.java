public class Oef1_27 {

	public static void main(String args[]) {

	//Oef 1
	Werknemer henry = new Werknemer("Henry", "Van Dijck", 12, 1000.5f);
	Werknemer nina = new Werknemer("Nina", "Veldeman", 13, 2000.5f);
	Werknemer katja = new Werknemer("Katja", "Geens", 14, 1500.5f);
	Werknemer marco = new Werknemer("Marco", "Van Velde", 15, 1500.0f);
	
	//Oef 2
	System.out.println("Oef 2");
	henry.salarisVerhogen(10);
	nina.salarisVerhogen(10);
	System.out.println(henry.getSalaris());
	System.out.println(nina.getSalaris());
	System.out.println(katja.getSalaris());
	System.out.println(marco.getSalaris());
	
	//Oef 3
	PartTimeWerknemer lily = new PartTimeWerknemer("Lily", "Denver", 16, 1700.0f, 20);
	PartTimeWerknemer frederic = new PartTimeWerknemer("Frederic", "DeGryse", 16-7, 1800.0f, 50);
	
	//Oef 4
	System.out.println("Oef 4");
	lily.salarisVerhogen(10);
	frederic.salarisVerhogen(10);
	System.out.println(lily.getSalaris());
	System.out.println(frederic.getSalaris());
	
	//Oef 6
	System.out.println("Oef 6");
	marco.setRSZ(0.44f);
	System.out.println(marco.getRSZ());
	
	lily.setRSZ(0.55f);
	System.out.println(lily.getRSZ());
	
	//Oef 7
	System.out.println("Oef 7");
	StudentWerknemer koen = new StudentWerknemer("Koen", "Daans", 16-7, 1800.0f, 50);
	System.out.println(koen.getRSZ());
	
	//Oef 9
	System.out.println("Oef 9");
	nina.betaal();
	frederic.betaal();
	koen.betaal();
	
	//Oef 10
	System.out.println("Oef 10");
	Factuur eenfact = new Factuur(1, 200.75f);
	eenfact.betaal();
	
	}



}