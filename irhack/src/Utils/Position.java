package Utils;

public class Position {
  	private int abscisse;
  	private int ordonnee;

  	public Position(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
  	}

  	public int getAbs() {
		return abscisse;
  	}

  	public int getOrd() {
		return ordonnee;
  	}
}