package Game.Modificateurs;

/**
 * <p>Titre : JDR</p>
 * <p>Description : Gestion d'un JDR</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Société : Ingénieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */

public class Attribut extends Modificateur {
  public Attribut(int Base_Value) {
    super(Base_Value);
  }
  
  public void ResetMod(int Value)
  {
  		this.next_mod = null;
  		this.ValueMod = Value;
  }
  
  public int getBase()
  {
  	return (int)this.ValueMod;
  }
  
}