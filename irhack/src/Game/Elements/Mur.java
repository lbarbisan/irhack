package Game.Elements;

import Game.Cellule;

public class Mur extends Fixe {
  	public String nom = "Mur de Jade";
  	public String description = "Ceci est une partie du mur du donjon. Indestructible";

  	public Mur (Cellule cellule){
		super(cellule);
  	}
}
