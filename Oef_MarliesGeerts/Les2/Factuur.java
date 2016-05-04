public class Factuur implements Betaalbaar{
	public int factuurNr;
	public float factuurBedrag;
	
	public Factuur(int factuurNrIn, float factuurBedragIn) {
		factuurNr = factuurNrIn;
		factuurBedrag = factuurBedragIn;
	}
	
	public void betaal() {
		System.out.println("Betaal de factuur " + factuurNr + " voor een bedrag van " + factuurBedrag + " euro");
	}
	
}