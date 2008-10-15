package Game.Modificateurs;

/**
 * <p>Titre : JDR</p>
 * <p>Description : Gestion d'un JDR</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Société : Ingénieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */

public class ModificateurAdd extends ModificateurExpr {

  public ModificateurAdd(Modificateur M1, Modificateur M2) {
    super(M1, M2);
  }

  public long Get_Value() {
    return this.M1.Get_Value() + this.M2.Get_Value() + super.Get_Value();
  }

}
