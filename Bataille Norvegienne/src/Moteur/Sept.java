package Moteur;

import Moteur.As.couleurCarte;

public class Sept extends Moteur.CarteSpeciale {

public enum couleurCarte{coeur,carreau,pique,trefle};
	
private String couleur;
	private int valeur;
	public Sept(int valeurcarte, String couleurcarte){
		couleur=couleurcarte;
		valeur=valeurcarte;
		
	};
	
	public void jouerEffet() {

	}
	public void donnerTalon() {

	}
	public void jouerCarteInferieure() {

	}
	public String getCouleur() {
		return couleur;
	}
	public int getValeur() {
		return valeur;
	}
	public String toString(){
		//System.out.println("valeur en chiffre : "+ this.valeur);
		return("Sept"+" de "+this.couleur);
	}

}
