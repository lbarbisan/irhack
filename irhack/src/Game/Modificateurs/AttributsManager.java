/*
 * Cr�� le 16 f�vr. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package Game.Modificateurs;

/**
 * @author lbarbisa
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
import java.lang.reflect.*;
import java.util.Hashtable;
import java.util.*;
import Game.Elements.Occupant;

public class AttributsManager {

	/* Classe pour retrouver les m�thodes d'une class Action */
		private Class ClassLauncher;
		private Hashtable Attributslist;
		/* Listes des actions possible */
		private Occupant occupant;

	  /* Constructeur */
	  public AttributsManager(Occupant occupant) {

		Attributslist = new Hashtable();
	
		ClassLauncher = occupant.getClass();
		this.occupant = occupant;

		while(ClassLauncher.getName()!="Game.Elements.Occupant" )
			{
				Get_FilterField(ClassLauncher);
				ClassLauncher = ClassLauncher. getSuperclass();
			}
	  }
  
	  /* Ajoute une methode dans la table de hachage */
	  private void Add_Field(Field champs) {
		Attributslist.put( champs.getName(), champs);
	  }
  
	  /*R�cup�re toutes les methodes public*/
	private void Get_FilterField(Class type)
		{ 
			Field[] Variables;  	
			Variables = ClassLauncher.getDeclaredFields();

			for(int index=0;index<Variables.length;index++)
			{
				 /* ne prend que les m�thode public */
				 if( Variables[index].getModifiers()==Modifier.PUBLIC && 
					  Variables[index].getType().getName().endsWith("Attribut") ==true)
				 {
						Add_Field(Variables[index]);
				 }
			}
		}

/* Essai d'executer une actions */
public Attribut  getContenaire(String nom)
 {
	   	Field champs;
	    champs = (Field)Attributslist.get(nom);
		try{
			return (Attribut)champs.get(this.occupant);
		}
		catch(IllegalAccessException e)
		{
			System.out.println("Champs Illegal");
		}
		
		return null;
 }
 
 /* Retourne tout les contenaire de la cr�ature */
 public String[] getAllContenaire()
 {
		String[] list = new String[Attributslist.size()];
		int index=0;
 	
		for(Enumeration e=Attributslist.keys(); e.hasMoreElements() ;  )
				{
					String nom;
					nom = (String)e.nextElement();
					list[index] = nom + ":\t" +  ((Attribut)getContenaire(nom)).Get_Value();
					index++;
				}
	return list;	
 }
}
