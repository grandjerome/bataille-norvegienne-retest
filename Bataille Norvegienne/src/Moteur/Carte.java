package Moteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Carte {

	
	
	/*
	 * (non-javadoc)
	 */

	private int valeur;
	

	/*
	 * (non-javadoc)
	 */
	private String couleur;

	/*
	 * (non-javadoc)
	 */
	
	

	/*
	 * (non-javadoc)
	 */
	private boolean carteJouable;
	public static enum couleurCarte{coeur,carreau,pique,trefle};
	
	
	
	
	@SuppressWarnings("null")
	
		
	
	public Carte(int valeur,String couleurcarte){
		this.couleur=couleurcarte;
		this.valeur=valeur;
		//System.out.println("je suis le "+this.valeur+" "+"de"+" "+this.couleur);
		
	}
	public Carte(){
		
	}
	public boolean determinerCarteJouable() {
		boolean cartejouable=true;
		
		//System.out.println(Partie.partie.getTasDeCarte().getTalon().size());
		//System.out.println(Partie.partie.getTasDeCarte().getTalon().isEmpty());
		if (!(Partie.partie.getTasDeCarte().getTalon().isEmpty())){
			if (getValeur() < Partie.partie.getTasDeCarte().getTalon().get(Partie.partie.getTasDeCarte().getTalon().size()-1).getValeur()){
				if (estCarteSpeciale()){
					if (!(estDeux())){
						cartejouable=false;
					}
					else {
						cartejouable=true;
					}}
				
				else {
					cartejouable=false;
				}
				
			}
			
		}
		//System.out.println("carte jouable : "+cartejouable);
		return(cartejouable);

	}

	/**
	 * Getter of the property <tt>valeur</tt>
	 * 
	 * @return Returns the valeur.
	 * 
	 */

	public int getValeur() {
		return valeur;
	}

	/**
	 * Setter of the property <tt>valeur</tt>
	 * 
	 * @param valeur
	 *            The valeur to set.
	 * 
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Getter of the property <tt>couleur</tt>
	 * 
	 * @return Returns the couleur.
	 * 
	 */

	public String getCouleur() {
		return couleur;
	}

	/**
	 * Setter of the property <tt>couleur</tt>
	 * 
	 * @param couleur
	 *            The couleur to set.
	 * 
	 */
	

	/**
	 * Getter of the property <tt>carteJouable</tt>
	 * 
	 * @return Returns the carteJouable.
	 * 
	 */

	public boolean getCarteJouable() {
		return carteJouable;
	}

	/**
	 * Setter of the property <tt>carteJouable</tt>
	 * 
	 * @param carteJouable
	 *            The carteJouable to set.
	 * 
	 */
	public void setCarteJouable(boolean carteJouable) {
		this.carteJouable = carteJouable;
	}
	public boolean estCarteSpeciale(){
		boolean cartespeciale=false;
		if (this.getClass() == CarteSpeciale.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	public boolean estAs(){
		boolean cartespeciale=false;
		if (this.getClass() == As.class){
			cartespeciale=true;
			//System.out.println("cest un 1");
		}
		return (cartespeciale);
	}
	public boolean estDeux(){
		boolean cartespeciale=false;
		if (this.getClass() == Deux.class){
			cartespeciale=true;
			//System.out.println("cest un 2");
		}
		return (cartespeciale);
	}
	public boolean estSept(){
		boolean cartespeciale=false;
		if (this.getClass() == Sept.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	public boolean estHuit(){
		boolean cartespeciale=false;
		if (this.getClass() == Huit.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	public boolean estDix(){
		boolean cartespeciale=false;
		if (this.getClass() == Dix.class){
			cartespeciale=true;
			System.out.println("cest un dix");
		}
		return (cartespeciale);
	}
	public String chiffreEnNom(int valeur){
		String nom=null;
		switch(valeur){
		case 1:
			nom="Deux";
			break;
		case 2:
			nom="Trois";
			break;
		case 3:
			nom="Quatre";
			break;
		case 4:
			nom="Cinq";
			break;
		case 5:
			nom="Six";
			break;
		case 6:
			nom="Sept";
			break;
		case 7:
			nom="Huit";
			break;
		case 8:
			nom="Neuf";
			break;
		case 9:
			nom="Dix";
			break;
		case 10:
			nom="Valet";
			break;
		case 11:
			nom="Dame";
			break;
		case 12:
			nom="Roi";
			break;
		case 13:
			nom="As";
			break;
		
		}
		return(nom);
	}
	
	public String toString(){
		//System.out.println("valeur en chiffre : "+ this.valeur);
		return(chiffreEnNom(this.valeur)+" de "+this.couleur);
	}
	

}

// /**
// * Getter of the property <tt>tasDeCartes</tt>
// *
// * @return Returns the tasDeCartes.
// *
// */
//
// public TasDeCartes getTasDeCartes() {
// return tasDeCartes;
// }
// /**
// * Setter of the property <tt>tasDeCartes</tt>
// *
// * @param tasDeCartes
// * The tasDeCartes to set.
// *
// */
// public void setTasDeCartes(TasDeCartes tasDeCartes) {
// this.tasDeCartes = tasDeCartes;
// }
// /**
// * Setter of the property <tt>joueur</tt>
// *
// * @param joueur
// * The joueur to set.
// *
// */
// public void setJoueur(Joueur joueur) {
// this.joueur = joueur;
// }
// /**
// * Getter of the property <tt>joueur</tt>
// *
// * @return Returns the joueur.
// *
// */
//
// public Joueur getJoueur() {
// return joueur;
// }

