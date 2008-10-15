package Game.Modificateurs;

/**
 * <p>Titre : JDR</p>
 * <p>Description : Gestion d'un JDR</p>
 * <p>Copyright : Copyright (c) 2004</p>
 * <p>Société : Ingénieur 200</p>
 * @author Barbisan Laurent
 * @version 1.0
 */

public class ModificateurExpr extends Modificateur {
  protected Modificateur M1;
  protected Modificateur M2;

  public ModificateurExpr(Modificateur M1, Modificateur M2) {
    this.M1 = M1;
    this.M2 = M2;
  }
}