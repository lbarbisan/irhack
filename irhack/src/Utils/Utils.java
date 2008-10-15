package Utils;

public class Utils {
 
   	/* Retourne une entier compris entre x et y */
  	public static int random(int x, int y) {
  		return (int) ( ( y - x ) * Math.random() + x );
  	}

	/* Retourne une entier impaire compris entre x et y */
	public static int randomImpaire(int x, int y) {
		return (int) ( 2 * ( (int) (Utils.random(x,y) / 2) ) + 1 );
	}

	/* Retourne le milieu arrondi supérieur x et y */
	public static int getMilieu(int x, int y) {
		return ( (int) ( ( y - x ) / 2 ) + 1 );
	}
}