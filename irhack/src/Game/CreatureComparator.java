/*
 * Cr�� le 10 f�vr. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package Game;

import java.util.Comparator;
import Game.Elements.*;

/**
 * @author lbarbisa
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
public class CreatureComparator implements Comparator {

/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
public boolean equals(Object obj) {
	return false;
}

/* (non-Javadoc)
 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
 */
public int compare(Object o1, Object o2) {
		return (int)( ((Creature)o1).V.Get_Value() - ((Creature)o2).V.Get_Value());
}

}
