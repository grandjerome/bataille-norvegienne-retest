package Moteur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class JoueurVirtuel extends Joueur{

	/*
	 * (non-javadoc)
	 */
	private int nbCartes;
	private String nomJoueur;
	public String[] nom={"Roger","Patrick","Corentin","Emilie","Albert","Alberta","Alberte","Albertine","Albin","Alda","Aldo","Aldegonde","Alèthe","Alex","Alexandra"};//,Alexandre,Alexandrine,Alexia,Alexiane,Alexis,Aleyde,Alfred,Alfreda,Alice,Alida,Aline,Alix,Aloïs,Aloysius,Alphonse,Alphonsine,Amaël,Amance,Amand,Amandine,Amoury,Ambroise,Amédée,Amélie,Amos,Anaïs,Anastase,Anastasie,Anatole,Andoche,André,Andrée,Ange,Angèle,Angéline,Angélique,Anicet,Anita,Anna,Annabelle,Anne,Annette,Annick,Annie,Annonciade,Anouchka,Anouck,Anselme,Anthelme,Anthony,Antoine,Antoinette,Antonin,Apollinaire,Apolline,Apollos,Arabelle,Arcadius,Arcady,Archibald,Ariane,Arielle,Aristide,Arlette,Armand,Armande,Armel,Armelle,Arnaud,Arnold,Arnould,Arsène,Arthur,Astrid,Athanase,Auberi,Aubert,Aubin,Aude,Audrey,Augusta,Auguste,Augustin,Augustine,Aure,Aurèle,Aurélia,Aurélie,Aurélien,Aurore,Ava,Avit,Axel,Axelle,Aymar,Aymeric,Aymone,Babette,Babine,Babita,Balbine,Balthazar,Baptiste,Barbara,Barbe,Barberine,Barnabé,Barnard,Barthélémy,Bartolomé,Basile,Bastien,Bastienne,Bathilde,Baudouin,Béatrice,Beatrix,Bénédicte,Benjamin,Benjamine,Benoît,Benoîte,Bérenger};
	static private int indiceNom=0;
	/**
*
*/

	
	
	private ArrayList<Carte> main;
	private HashSet<Carte> faceCachee;
	private HashSet<Carte> faceVisible;
	
	public HashSet<Carte> getfaceCachee(){
		return(faceCachee);
	}
	public ArrayList<Carte> getmain(){
		return(main);
	}
	public HashSet<Carte> getfaceVisible(){
		return(faceVisible);
	}
	public JoueurVirtuel(){
		if (indiceNom == 15){
			indiceNom=0;
		}
		this.nomJoueur=nom[indiceNom];
		indiceNom++;
		
	}
	public void echangerCarte() {

	}
	public void creerList(){
		main = new ArrayList<Carte>();
		faceCachee = new HashSet<Carte>();
		faceVisible = new HashSet<Carte>();
		//super.creerList();
	}
	public void poserCarte() {

	}

	/**
	 * Getter of the property <tt>nbCartes</tt>
	 * 
	 * @return Returns the nbCartes.
	 * 
	 */

	public int getNbCartes() {
		return nbCartes;
	}

	/**
	 * Setter of the property <tt>nbCartes</tt>
	 * 
	 * @param nbCartes
	 *            The nbCartes to set.
	 * 
	 */
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	/**
	 * Getter of the property <tt>main</tt>
	 * 
	 * @return Returns the main.
	 * 
	 */

	
	/**
	 * Setter of the property <tt>main</tt>
	 * 
	 * @param main
	 *            The main to set.
	 * 
	 */
	public void jouerCarte(){
		
	}
	public String toString(){
		return("Joueur Virtuel "+nomJoueur+" ");
	}

	

}

