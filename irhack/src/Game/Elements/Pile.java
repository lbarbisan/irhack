package Game.Elements;

import Game.Cellule;
import Game.Interactions.*;
import java.util.ArrayList;
import Game.Donjon;

public class Pile extends Meuble {
	
ArrayList liste = new ArrayList();
private int index;
	
public Pile(Cellule cellule) {
	super(cellule);
	this.nom = "Pile d'objet";
	this.description = "Ceci est un coffre contenant de nombreux objets";
	index=0;
	actions = new ActionsManager(this);
}

/* Ajoute l'objet */
private void addObject(Object obj)
{
	liste.add(index, obj);
	index++;
}

/*Prend un Objet*/
public  Object  getObject()
{
	Object obj;
	if(index==0) return null;
	
	obj  =  this.liste.get(index);
	this.liste.remove(index);
	return obj;
	
}
  	
public void Prendre(Pile source, Creature Destination)
{
	Objet objet;
	
	if(Donjon.Distance(source, Destination)>1){
		System.err.println("La cible est trop loin");
			return;
	}
	
	objet = (Objet)source.getObject();
	
	if(objet!=null)
		Destination.Sac.Add_Object(objet);
}

public void Deposer(Objet Source,  Pile pile)
{
	pile.addObject(Source);
}

  	
}