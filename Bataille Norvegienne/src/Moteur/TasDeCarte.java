package Moteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TasDeCarte extends Carte{
	private ConcurrentLinkedQueue<Carte> pioche;
	private  ArrayList<Carte> talon;
	public TasDeCarte(int nombreJoueurVirtuel){
		distribuerCarte(nombreJoueurVirtuel);
		
	}
	public void creerPioche(int nombrePaquet){
		
		int[] valeurCarte = new int[8];
		int[] valeurCarteSpeciale = new int[5];
		int i,j,k;
		String[] couleurCarte = new String[4];
		
		couleurCarte[0]="coeur";
		couleurCarte[1]="carreau";
		couleurCarte[2]="trefle";
		couleurCarte[3]="pique";
		valeurCarte[0]=2;
		valeurCarte[1]=3;
		valeurCarte[2]=4;
		valeurCarte[3]=5;
		valeurCarte[4]=8;
		valeurCarte[5]=10;
		valeurCarte[6]=11;
		valeurCarte[7]=12;
		valeurCarteSpeciale[0]=1;
		valeurCarteSpeciale[1]=6;
		valeurCarteSpeciale[2]=7;
		valeurCarteSpeciale[3]=9;
		valeurCarteSpeciale[4]=13;
		//System.out.println("pas probleme 1");
		ArrayList<Carte> piocheDeMelange = new ArrayList<Carte>();
		for (i=0;i<nombrePaquet;i++){
			for (j=0;j<13;j++){
				for (k=0;k<4;k++){
					switch (j){
					case 0:
					As m = new As((j+1),couleurCarte[k]);
					piocheDeMelange.add(m);
						break;
					case 1:
					Deux m2 = new Deux((j+1),couleurCarte[k]);
					piocheDeMelange.add(m2);
						break;
					case 6:
					Sept m3 = new Sept((j+1),couleurCarte[k]);
					piocheDeMelange.add(m3);
						break;
					case 7:
					Huit m4 = new Huit((j+1),couleurCarte[k]);
					piocheDeMelange.add(m4);
						break;
					case 9:
					Dix m5 = new Dix((j+1),couleurCarte[k]);
					piocheDeMelange.add(m5);
						break;
					
					default :
					
					 	Carte m6 = new Carte((j+1),couleurCarte[k]);
						piocheDeMelange.add(m6);
						//System.out.println("pas probleme "+(j+1)+" "+i+" "+couleurCarte[k]);
					}
					}
				}
			}
		
		Collections.shuffle(piocheDeMelange);
		
		pioche = new ConcurrentLinkedQueue<Carte>();
		System.out.println("boucle list :");
		ListIterator<Carte> it = piocheDeMelange.listIterator();
		while (it.hasNext()){
			Carte element = it.next();
			System.out.println(element);
			//System.out.println(element.getCouleur() + " " + element.getValeur());
			pioche.add(element);
		}
		//System.out.println("boucle queue :");
	//for(i=0;i<(nombrePaquet*52);i++){
	//	Carte elementtest = pioche.remove();
		//System.out.println(elementtest.couleur+" "+elementtest.valeur);
	//}
		}
	public void creerTalon(){
		talon=new ArrayList<Carte>();
	}
	public void distribuerCarte(int nombreJoueurVirtuel){
		int nombrePaquet=0;
		int i;
		
		nombrePaquet=nombreJoueurVirtuel/4;
		
		if ((nombreJoueurVirtuel%4) != 0) {
			nombrePaquet++;
		}
		System.out.println("nombre paquets : " + nombrePaquet);
		creerPioche(nombrePaquet);
		creerTalon();
		ListIterator<Joueur> it = Partie.partie.getlistJoueur().listIterator();
		
		while (it.hasNext()){
			Joueur element = it.next();
			element.creerList();
			//System.out.println("joueur "+element+"à comme cartes :");
			//System.out.println(element + " ");
			for(i=0;i<3;i++){
				
				
				element.getmain().add(pioche.remove());
				//System.out.println(element.main.get(i).valeur + " " + element.main.get(i).couleur);
				
				element.getfaceCachee().add(pioche.remove());
				//System.out.println(element.faceCachee.get(i).valeur + " " + element.faceCachee.get(i).couleur);
				
				element.getfaceVisible().add(pioche.remove());
				//System.out.println(element.faceVisible.get(i).valeur + " " + element.faceVisible.get(i).couleur);
				
			}
		}
		
		
		
	}
	public ConcurrentLinkedQueue<Carte> getpioche(){
		return(pioche);
	}
	public ArrayList<Carte> getTalon(){
		return(talon);
	}
	public void afficherTalon(){
		if (!(talon.isEmpty())){
			ListIterator<Carte> it = talon.listIterator();
			while (it.hasNext()){
				Carte element = it.next();
				System.out.println(element);
				//System.out.println(element.getValeur() + " " + element.getCouleur());
			}
		}
		else {
			System.out.println("rien dans le talon");
			
		}
	}
	public void donnerTalon(Joueur joueur){
		joueur.getmain().addAll(Partie.partie.getTasDeCarte().talon);
		Partie.partie.getTasDeCarte().talon.clear();
	}
	
}
