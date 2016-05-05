public class Oefeningen
{
	static int oefNumber = 1;
	public static void main(String args[]) {
		//While loop
		System.out.println("\n--------------------------------------");
		int test = 55;
		while(test>34){
			System.out.println(test);
			test--;
		}
		
		//Bitoperaties
		//0000 1010 = 10
		//1111 0101 = -11
		System.out.println("\n--------------------------------------");
		System.out.println(~10);
		
		//Oefeningen pagina 19
		//Oefening 1
		nextExercise();
		for(int i = 1; i<=9; i++){
			for(int j = 1; j<=9; j++){
				System.out.print(i + " * ");
				System.out.print(j + " = ");
				System.out.println(i*j);
			}
		}	
		
		//Oefening 2
		nextExercise();
		int dateYear = 2009;
		int dayOfTheWeekNum = 6;

		String daysOfTheWeek[] = { "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag" };
		for (int dateDay = 1; dateDay <= 28; dateDay++)
		{
			System.out.println(daysOfTheWeek[dayOfTheWeekNum++] +" " +dateDay+ " februari " + dateYear);
			dayOfTheWeekNum %= 6;
		}
		
		//Oefening 3
		nextExercise();
		double pi = 1;
		boolean toggle = false;
		for(int i = 1; i<= 1000; i++){
			if(toggle){
				pi += (double)1/(i*2+1);
			}else{
				pi -= (double)1/(i*2+1);
			}
			toggle = !toggle;
		}
		System.out.println("Dit is pi: " + pi*4);
		
		//Oefening 4
		nextExercise();
		int funnyNumber = 4302;
		System.out.println(~funnyNumber +1);
		
		//Oefening 5
		nextExercise();
		for(int i = 3; i< 100; i++){
			boolean isPrime = true;
			for (int j = 2; j < i; j++)
			{
				if (i%j==0)
				{
					isPrime = false;
				}
			}
			if (isPrime)
			{
				System.out.println(i);
			}
		}
		
		int highest = 0;
		int a[] = {12,34,56,78,123,234,99,88};
		//Oefening 6
		nextExercise();
		for(int i = 0; i <a.length; i++){
			if(highest < a[i]){
				highest = a[i];
			}
		}
		System.out.println(highest);
		
		//Oefening 7
		nextExercise();
		int b[] = new int[8];
		for(int j= 0; j < b.length; j++){
			highest = 0;
			int index = 0;
			for(int i = 0; i < a.length; i++){
				if(highest < a[i]){
					highest = a[i];
					index = i;
				}
			}
			a[index] = 0;
			b[j] = highest;
			System.out.print(b[j] + ", ");
		}
	}
	
	private static void nextExercise(){
		System.out.println("\nDit is oefening: " + oefNumber++ + " --------------------------------------");
	}
}