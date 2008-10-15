/*
 * Cr�� le 16 f�vr. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package Game.Contenaires;

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

public class ContenairesManager {

	/* Classe pour retrouver les m�thodes d'une class Action */
		private Class ClassLauncher;
		private Hashtable contenairelist;
		/* Listes des actions possible */
		private Occupant occupant;

	  /* Constructeur */
	  public ContenairesManager(Occupant occupant) {

		contenairelist = new Hashtable();
	
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
		contenairelist.put( champs.getName(), champs);
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
					  Variables[index].getType().getName().endsWith("Contenaire") ==true)
				 {
						Add_Field(Variables[index]);
				 }
			}
		}

	  /* D�termine si la fonction existe */
private Field Exist(String nom) {
   Field champ;
   champ = (Field)contenairelist.get(nom);
   return champ;
 }

/* Essai d'executer une actions */
public Contenaire  getContenaire(String nom)
 {
	   return (Contenaire)contenairelist.get(nom);
 }
 
 /* Retourne tout les contenaire de la cr�ature */
 public Contenaire[] getAllContenaire()
 {
	Contenaire[] list = new Contenaire[contenairelist.size()];
		int index=0;
 	
		for(Enumeration e=contenairelist.elements(); e.hasMoreElements() ;  )
		{
			list[index] = (Contenaire)e.nextElement() ;
			index++;
		}
		
		return list;	
 }
	 
 

}
