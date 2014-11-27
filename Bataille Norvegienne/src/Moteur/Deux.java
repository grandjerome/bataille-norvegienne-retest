package Moteur;

import Moteur.As.couleurCarte;

public class Deux extends Moteur.CarteSpeciale {

public enum couleurCarte{coeur,carreau,pique,trefle};
	
    private String couleur;
	private int valeur;
	public Deux(int valeurcarte, String couleurcarte){
		couleur=couleurcarte;
		valeur=valeurcarte;
		
	};
	
	public void jouerEffet() {
		

	}
	public void donnerTalon() {

	}
	public void repartirDuDeux() {

	}
	public String getCouleur() {
		return couleur;
	}
	public int getValeur() {
		return valeur;
	}
	public String toString(){
		return("Deux"+" de "+this.couleur);
	}

}
