package Game.Interactions;

/**
 * <p>Titre : ActionsManager</p>
 * <p>Description : S'occupe de retrouver la methode liée à une action, puis l'execute</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Société : Ingénieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */
import java.lang.reflect.*;
import java.util.Hashtable;
import java.util.*;
import Game.Elements.Occupant;

public class ActionsManager {
  	
  	/* Classe pour retrouver les méthodes d'une class Action */
  	private Class ClassLauncher;
  	private Hashtable methodelist;
	/* Listes des actions possible */
private Occupant occupant;

  /* Constructeur */
  public ActionsManager(Occupant occupant) {

	methodelist = new Hashtable();
	
    ClassLauncher = occupant.getClass();
    this.occupant = occupant;

    while(ClassLauncher.getName()!="Game.Elements.Occupant" )
    	{
			Get_FilterMethode(ClassLauncher);
			ClassLauncher = ClassLauncher. getSuperclass();
    	}	
  }
  
  /* Ajoute une methode dans la table de hachage */
  private void Add_Methode(Method methode) {
  	methodelist.put( methode.getName(), methode);
  }
  
  /*Récupère toutes les methodes public*/
private void Get_FilterMethode(Class type)
	{ 
		Method[] Methodes;  	
	 	Methodes = ClassLauncher.getDeclaredMethods();
 
	 	for(int index=0;index<Methodes.length;index++)
	 	{
			 /* ne prend que les méthode public */
			 if( Methodes[index].getModifiers()==Modifier.PUBLIC && 
			 	  Methodes[index].getParameterTypes().length==2 && Methodes[index].getName().startsWith("doIndex")!=true)
			 {
			 	Add_Methode(Methodes[index]);
			 }
	 	}
	}

  /* Détermine si la fonction existe */
  private Method Exist(String action, Class[] Parametres) {
   Method ExeMethod;
   ExeMethod = (Method)methodelist.get(action);
   return ExeMethod;
 }

 /* Essai d'executer une actions */
 public void Try(String action, Object Source, Object Destination)
 {
   Method exemethod;
   Class[] Clsparametre = new Class[2];
   Object[] parametre = new Object[2];
   try{
     Clsparametre[0] = (new Object()).getClass();
     Clsparametre[1] = (new Object()).getClass();
   }
   catch(Exception e){System.err.println("Erreur");}
  
   if((exemethod = Exist(action,Clsparametre))==null)
     {
     	System.err.println("L'action n'existe pas");
     	return ;
     	} 
   parametre[0] = Source;
   parametre[1] =  Destination;
   try{
   	exemethod.invoke(this.occupant ,parametre);	}
   catch(Exception e){
			System.err.println("Impossible d'executer cette action");
   			}
 }
 
 /*Récupère les methodes public */
 public String[] getAllActions()
 {
 	String[] list = new String[methodelist.size()];
 	int index=0;
 	
 	for(Enumeration e=methodelist.keys(); e.hasMoreElements() ;  )
 	{
 		list[index] = (String)e.nextElement() ;
		index++;
 	}
 	return list;
 }
 
 /* Récupère les interacions compatible avec l'objet destination */
 public String[] getInteractions(Object Destination)
 {
	Vector VectList = new Vector();
	int index=0;
	Class[] Parameters;
 	
	for( Iterator e=methodelist.values().iterator() ; e.hasNext() ;  )
	{
		/* Vérifit que les destinations sont bien du même type */
		Method methode;
		methode = (Method)e.next();
		Parameters = methode.getParameterTypes()  ;
		if(Parameters[1].isInstance(Destination)==true )
		{
		VectList.add(methode);
		}
	}
	
	String[] list = new String[VectList.size()];
	for(Enumeration e=VectList.elements() ; e.hasMoreElements() ;  )
	{
		list[index] = ((Method)e.nextElement()).getName() ;
		index++;
	}
	return list;
 }
 
 /* Récupère les interacions compatible avec l'objet destination */
 public String[] getUserInteractions(Object Destination)
 {
	Vector VectList = new Vector();
	int index=0;
	Class[] Parameters;
 	
	for( Iterator e=methodelist.values().iterator() ; e.hasNext() ;  )
	{
		/* Vérifit que les destinations sont bien du même type */
		Method methode;
		methode = (Method)e.next();
		Parameters = methode.getParameterTypes();
		
		
		if(Parameters[1].isInstance(Destination)==true && methode.getName().startsWith("p_")==false ) // && methode.getReturnType()!=long.class)
		{
			VectList.add(methode);
		}
	}
	
	String[] list = new String[VectList.size()];
	for(Enumeration e=VectList.elements() ; e.hasMoreElements() ;  )
	{
		list[index] = ((Method)e.nextElement()).getName() ;
		index++;
	}
	return list;
 }
 
 
 }
 