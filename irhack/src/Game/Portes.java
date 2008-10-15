package Game;

import Utils.Utils;

public class Portes {
	private Porte porteNord;							// NSEO = 1
	private Porte porteSud;							// NSEO = 2
	private Porte porteEst;								// NSEO = 3
	private Porte porteOuest;						// NSEO = 4

	private void setPorte(Porte porte, int NSEO) {
		switch(NSEO) {
			case 1 :	porteNord = porte;
				break;
			case 2 :	porteSud = porte;
				break;
			case 3 :	porteEst = porte;
				break;
			case 4 :	porteOuest = porte;
				break;
			default:
				break;
		}
	}

	public void setPorte(Cellule cellules[][], int NSEO) {
		switch(NSEO) {
			case 1 :	porteNord = new Porte(cellules[0][Utils.getMilieu(0,cellules[0].length)-1]);
				break;
			case 2 :	porteSud =  new Porte(cellules[cellules.length-1][Utils.getMilieu(0,cellules[0].length)-1]);
				break;
			case 3 :	porteEst = new Porte(cellules[Utils.getMilieu(0,cellules.length)-1][cellules[0].length-1]);
				break;
			case 4 :	porteOuest = new Porte(cellules[Utils.getMilieu(0,cellules.length)-1][0]);
				break;
			default:
				break;
		}
	}

	public Porte getPorte(int NSEO) {
		Porte porteTmp = null;

		switch(NSEO) {
			case 1 :	porteTmp =  porteNord;
				break;
			case 2 :	porteTmp = porteSud;
				break;
			case 3 :	porteTmp = porteEst;
				break;
			case 4 :	porteTmp = porteOuest;
				break;
			default:
				break;
		}
		
		return porteTmp;
	}
}
