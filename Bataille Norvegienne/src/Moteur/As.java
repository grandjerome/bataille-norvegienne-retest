package Moteur;

import java.util.ListIterator;
import java.util.Scanner;

import Moteur.Carte.couleurCarte;



public class As extends Moteur.CarteSpeciale {


public enum couleurCarte{coeur,carreau,pique,trefle};
	
    private String couleur;
	private int valeur;
	public As(int valeurcarte, String couleurcarte){
		valeur=valeurcarte;
		couleur=couleurcarte;
		
	};
	
	public void jouerEffet() {
		Scanner sc = new Scanner(System.in);
		int i=1;
		System.out.println("à qui voulez vous donner le talon (numero)");
		ListIterator<Joueur> it = Partie.partie.getlistJoueur().listIterator();
		while (it.hasNext()){
			Joueur element = it.next();
			System.out.println(element+" "+(i));
			i++;
		}
		System.out.println("?");
		int joueur = sc.nextInt();
		Partie.partie.getTasDeCarte().donnerTalon(Partie.partie.getlistJoueur().get(joueur-1));
		

	}
	
	public String getCouleur() {
		return couleur;
	}
	public int getValeur() {
		return valeur;
	}
	public String toString(){
		//System.out.println("coco");
		//System.out.println("valeur en chiffre : "+ this.valeur);
		return("As"+" de "+this.couleur);
	}
	
}
