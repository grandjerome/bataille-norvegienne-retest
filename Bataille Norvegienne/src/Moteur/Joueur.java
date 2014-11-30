package Moteur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class Joueur {

	/*
	 * (non-javadoc)
	 */
	
	private int nbCartes;


	private String nomJoueur;
	
	
	private ArrayList<Carte> main;
	private HashSet<Carte> faceCachee;
	private HashSet<Carte> faceVisible;
	private ArrayList<Carte> carteaposer;
	public Joueur(){
		
	}
	
	public Joueur(String nom){
		this.nomJoueur=nom;			
	}
	
	public void echangerCarte(Joueur joueur) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Combien de cartes voulez vous changer? (De 1 à 3)");
		int nbCartesAEchanger = sc.nextInt();
		for (int i=0;i<nbCartesAEchanger;i++){
			System.out.println("Carte a échanger n°"+(i+1));
			System.out.println("quelle carte voulez vous echanger parmi : ");
			System.out.println("main :");
			for (int j=0;j<main.size();j++){
				System.out.println("numero "+ (j+1) +" "+ main.get(j));
			}
			int numCarteAEchanger = sc2.nextInt()-1;
			Carte carteAEchanger = main.get(numCarteAEchanger);
			System.out.println("Avec quelle carte de la face visible parmi : ");
			System.out.println("face visible :");
			ArrayList<Carte> list = new ArrayList<Carte>( faceVisible );
			for (int j=0;j<main.size();j++){
				System.out.println("numero "+ (j+1) +" "+ list.get(j));
			}
			int numCarteAEchangerFaceVisible = sc3.nextInt()-1;
			Carte carteAEchangerFaceVisible = list.get(numCarteAEchangerFaceVisible);
			main.remove(numCarteAEchanger);
			main.add(carteAEchangerFaceVisible);
			list.remove(numCarteAEchangerFaceVisible);
			list.add(carteAEchanger);
			System.out.println("Vous avez échangé "+carteAEchanger+" et "+carteAEchangerFaceVisible);
			faceVisible = new HashSet<Carte>(list);
			}
	}
	public void creerList(){
		main = new ArrayList<Carte>();
		faceCachee = new HashSet<Carte>();
		faceVisible = new HashSet<Carte>();
	}
	public void piocher(int nbCarte){
		main.add((Carte) Partie.partie.getTasDeCarte().getpioche().remove());
	}
	public HashSet<Carte> getfaceCachee(){
		return(faceCachee);
	}
	public ArrayList<Carte> getmain(){
		return(main);
	}
	public HashSet<Carte> getfaceVisible(){
		return(faceVisible);
	}
	public void setfacevisible(ArrayList<Carte> list){
		faceVisible.removeAll(faceVisible);
		for (int i=0; i<3; i++){
			faceVisible.add(list.get(i));
		}
	}
	public boolean poserCarte(ArrayList<Carte> carteaposer,Collection<Carte> collection) { 
		 boolean cartejouable=carteaposer.get(0).determinerCarteJouable();
		 
		 if (cartejouable){
			 if (carteaposer.get(0) instanceof CarteSpeciale){
				 ListIterator<Carte> it = carteaposer.listIterator();
				 while (it.hasNext()){
					 Carte element= it.next();
					 System.out.println(element);
					 //System.out.println(element.getCouleur()+ " "+element.getValeur());
					 Partie.partie.getTasDeCarte().getTalon().add(element);
					 //System.out.println(Partie.partie.getTasDeCarte().getTalon().get(0));
					 collection.remove(element);
					 ((CarteSpeciale) element).jouerEffet();
					 
					 
			 }
				 
			 }
				 else{
					 ListIterator<Carte> it = carteaposer.listIterator();
					 while (it.hasNext()){
						 Carte element= it.next();
						System.out.println(element);
						 //System.out.println(element.getCouleur()+ " "+element.getValeur());
						 Partie.partie.getTasDeCarte().getTalon().add(element);
						 System.out.println(Partie.partie.getTasDeCarte().getTalon().get(0));
						 collection.remove(element);
						 
					 }
					 
			 
			 
				 }
			 piocher(1);
		 }
		 else {System.out.println("vous ne pouvez pas poser cette carte");}
		 carteaposer.clear();
		 return (cartejouable);
	}

	

	public int getNbCartes() {
		return nbCartes;
	}

	
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	
	public void jouerCarte(){
		if (!(main.isEmpty())){
			boolean carteposee=false;
			while(!(carteposee)){
			System.out.println("quelle carte voulez vous poser parmi : ");
			System.out.println("main :");
			int i;
			for (i=0;i<main.size();i++){
				System.out.println("numero "+ (i+1) +" "+ main.get(i));
			//System.out.println("numero "+ (i+1) +" "+ main.get(i).getCouleur() + " " + main.get(i).getValeur());
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("combien de cartes à poser ?");
			int nombrecarteaposer=sc.nextInt();
			carteaposer = new ArrayList<Carte>();
			if (nombrecarteaposer==0){
				Partie.partie.getTasDeCarte().donnerTalon(this);
			}
			else {
			for(i=0;i<nombrecarteaposer;i++){
			System.out.println("numéro de la carte n° "+(i+1)+" :");
			
			int numerocarte = sc.nextInt();
			carteaposer.add(main.get(numerocarte-1));
			}
			boolean identique=false;
			if(carteaposer.size()==1){
				identique=true;
			}
			//System.out.println(carteaposer.size());
			if(carteaposer.size()>1){
			identique=verifierCarteIdentique(carteaposer);
			}
			if (!(identique)){
			 System.out.println("cartes non identiques, veuillez recommencer");
			}
			//->exception identique=false
			if (identique){
				carteposee = poserCarte(carteaposer,main);	
			}
			
			}
			
		}}
		}
	public boolean verifierCarteIdentique(ArrayList<Carte> carteacomparer){
		boolean carteidentique=true;
		ListIterator<Carte> it = carteacomparer.listIterator();
		Carte elementreference=null;
		if (it.hasNext()){
			elementreference = it.next();
		}
		while(it.hasNext()){
			Carte elementacomparer = it.next();
			if (elementacomparer.getValeur()!=elementreference.getValeur()){
				carteidentique=false;
				
			}
			
		}
		return(carteidentique);
		
	}
	public ArrayList<Carte> getCarteAPoser(){
		return(carteaposer);
	}
	public String toString(){
		return("Joueur "+nomJoueur+" ");
	}
	


	

}

// /**
// * Ensures that this collection contains the specified element (optional
// * operation).
// *
// * @param element
// * whose presence in this collection is to be ensured.
// * @see java.util.Collection#add(Object)
// *
// */
// public boolean addCarte(Carte carte) {
// return this.carte.add(carte);
// }
// /**
// * Setter of the property <tt>carte</tt>
// *
// * @param carte
// * the carte to set.
// *
// */
// public void setCarte(Collection<Carte> carte) {
// this.carte = carte;
// }
// /**
// * Removes a single instance of the specified element from this
// * collection, if it is present (optional operation).
// *
// * @param element
// * to be removed from this collection, if present.
// * @see java.util.Collection#add(Object)
// *
// */
// public boolean removeCarte(Carte carte) {
// return this.carte.remove(carte);
// }
// /**
// * Getter of the property <tt>carte</tt>
// *
// * @return Returns the carte.
// *
// */
//
// public Collection<Carte> getCarte() {
// return carte;
// }
// /**
// * Returns the number of elements in this collection.
// *
// * @return the number of elements in this collection
// * @see java.util.Collection#size()
// *
// */
// public int carteSize() {
// return carte.size();
// }
// /**
// * Setter of the property <tt>partie</tt>
// *
// * @param partie
// * The partie to set.
// *
// */
// public void setPartie(Partie partie) {
// this.partie = partie;
// }
// /**
// * Getter of the property <tt>partie</tt>
// *
// * @return Returns the partie.
// *
// */
//
// public Partie getPartie() {
// return partie;
// }
