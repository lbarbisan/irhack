package Game.Contenaires;

/**
 * <p>Titre : Contenaire</p>
 * <p>Description : Gestion des contenaires</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Soci�t� : Ing�nieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */
import java.util.*;
import Game.Elements.*;

public class Contenaire {

  protected Class classType;
  protected int Max_Size;

  /* Contiens la liste des objets */
  LinkedList Objets;

  /* Constructeur */
  public Contenaire(String ClassType, int Size) {
    try {
      classType = Class.forName(ClassType);
      this.Max_Size = Size;
    }
    catch (ClassNotFoundException e) {
      System.out.println("Erreur dans le conteneur " + ClassType);
      System.out.println(e.toString());
    }

    Objets = new LinkedList();
  }

  /* Ajoute un objet au contenaire */
  public int Add_Object(Objet objet) {
    /* V�rifit que l'objet est compatible avec le contenaire */
    if (!classType.isInstance(objet)) {
      return 0;
    }
    
    /* V�rification de la */
   if(Max_Size>Objets.size())
   {
    Objets.add(objet);
    objet.On_Contenaire_Add(this);
	return Objets.indexOf(objet);
   }
    return 0;
  }

  /* Supprime un objet du contenaire */
  public boolean Remove_Object(Objet objet) {
    objet.On_Contenaire_Remove(this);
    return Objets.remove(objet);
  }

  /* Renvoi l'objet � l'endroit indiqu� */
  public Object Get_Object(int Index) {
    return Objets.get(Index);
  }
}