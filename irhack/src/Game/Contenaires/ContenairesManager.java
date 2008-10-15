/*
 * Créé le 16 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package Game.Contenaires;

/**
 * @author lbarbisa
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
import java.lang.reflect.*;
import java.util.Hashtable;
import java.util.*;
import Game.Elements.Occupant;

public class ContenairesManager {

	/* Classe pour retrouver les méthodes d'une class Action */
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
  
	  /*Récupère toutes les methodes public*/
	private void Get_FilterField(Class type)
		{ 
			Field[] Variables;  	
			Variables = ClassLauncher.getDeclaredFields();

			for(int index=0;index<Variables.length;index++)
			{
				 /* ne prend que les méthode public */
				 if( Variables[index].getModifiers()==Modifier.PUBLIC && 
					  Variables[index].getType().getName().endsWith("Contenaire") ==true)
				 {
						Add_Field(Variables[index]);
				 }
			}
		}

	  /* Détermine si la fonction existe */
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
 
 /* Retourne tout les contenaire de la créature */
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
