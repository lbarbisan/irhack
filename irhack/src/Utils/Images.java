package Utils;

import java.awt.Image;
import java.awt.Toolkit;

public class Images {
	
	/* charge une image et retourne son objet */
	public static Image getImage(String url, Toolkit kit) {
	  	return kit.getImage( url );
	}

	/* charge une image et retourne son objet (mais creé l'objet Toolkit) */
	public static Image getImage(String url) {
		Toolkit kit = Toolkit.getDefaultToolkit();
	  	return kit.getImage( url );
	}
}
