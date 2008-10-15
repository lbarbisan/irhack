package Utils;

public class Point {
	public final static int TYPE_PX = 0;
	public final static int TYPE_NUM = 1;
	
	private int ligne;
	private int colonne;
	private int type;				/* 0 : Pixel   1: Numero de cellule*/
											
	public Point(int ligne, int colonne, int type ) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.type = type;
	}
	
	/* Converti les coordonn�es pixel en numero */
	private void cellToPix() {
		if(this.type == TYPE_NUM) {
			this.ligne *= Config.IMG_HAUT; 
			this.colonne *= Config.IMG_LARG; 
			this.type = TYPE_PX;
		}
	}
	
	/* Converti les numeros en les coordonn�es pixel */
	private void pixToCell() {
		if(this.type == TYPE_PX) {
			this.ligne = (int) (this.ligne / Config.IMG_HAUT); 
			this.colonne = (int) (this.colonne /Config.IMG_LARG); 
			this.type = TYPE_NUM;
		}
	}

	/* Retourne la coordonn�e de la ligne en pixel */
	public int getLignePix() {
		cellToPix();
		return this.ligne;
	}	
	
	/* Retourne la cxoordonn�e de la colonne en pixel */
	public int getColonnePix() {
		cellToPix();
		return this.colonne;
	}	

	/* Retourne le numero de la ligne */
	public int getLigne() {
		pixToCell();
		return this.ligne;
	}	

	/* Retourne le numero de la ligne */
	public int getColonne() {
		pixToCell();
		return this.colonne;
	}	
}
