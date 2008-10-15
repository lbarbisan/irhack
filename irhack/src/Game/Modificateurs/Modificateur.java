package Game.Modificateurs;

/**
 * <p>Titre : Modificateur</p>
 * <p>Description : Gère les modificateurs sur les attributs</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Société : Ingénieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */
import java.util.Comparator;

public class Modificateur implements Comparator {

  protected long ValueMod;
  protected Modificateur next_mod = null;
  protected Modificateur last_mod = null;

  /* Constructeur */
  public Modificateur() {
    this.ValueMod = 0;
  }

  public Modificateur(int Value) {
    this.ValueMod = Value;
  }

  /* Ajoute un modificateur dans la liste */
  public void Add_Mod(Modificateur mod) {
    if (this.next_mod == null) {
      this.next_mod = mod;
      this.next_mod.last_mod = this;
    }
    else {
      this.next_mod.Add_Mod(mod);
    }
  }
  
  /* Supprime ce modificateur */
  public void Del_Mod(Modificateur mod)
  {
  	/* Si le modificateur suivant existe */
  	Modificateur modificateur;
  	if(this.next_mod==mod)
  	{
  			modificateur = this.next_mod ;
  			this.next_mod = this.next_mod.next_mod;
  			this.next_mod.last_mod = this;
  	} 
  }
  
  /* Renvoie la valeur du modificateur */
  public long Get_Value() {
    if (this.next_mod != null) {
      return ValueMod + this.next_mod.Get_Value();
    }
    else {
      return ValueMod;
    }
  }
  
  /* (non-Javadoc)
 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
 */
	public int compare(Object o1, Object o2) {
		return (int)( ((Modificateur)o1).Get_Value()-((Modificateur)o2).Get_Value());
	}

	/* (non-Javadoc)
 	* @see java.util.Comparator#equals(java.lang.Object)
 	*/
	public boolean equals(Object obj) {
	if(this.Get_Value()==((Modificateur)obj).Get_Value())
		return true;
	return false;
	}

  
}