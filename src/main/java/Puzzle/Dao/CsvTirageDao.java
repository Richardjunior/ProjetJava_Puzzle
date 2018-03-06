package Puzzle.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import Puzzle.Domain.Tirage;

public class CsvTirageDao {
	final Logger LOGGER = Logger.getLogger(CsvTirageDao.class);

	private List<Tirage> tirages;
	private List<String> entetes;

	public CsvTirageDao() {
		tirages = new ArrayList<Tirage>();
	}

	/*
	 * Cette fonction nous renvoie la liste des tirages contenus dans le fichier
	 * passé en paramètre
	 */
	public List<Tirage> rechercheTousTirages(String nomFichier) {
		File fichier = new File(nomFichier);

		List<String> lignes = null;

		try {
			lignes = lectureFichier(fichier);
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}

		tirages = new ArrayList<Tirage>(lignes.size());

		for (String ligne : lignes) {

			final Tirage tirage = ligneToTirage(ligne);
			tirages.add(tirage);
		}
		return tirages;
	}

	/*
	 * Cette fonction nous permet de selectionner les ligne dont on a besoin les
	 * retourne sous forme d'un seul objet
	 */
	private Tirage ligneToTirage(String ligne) {
		final String[] tabTirage = ligne.split(";");
		final int b1 = Integer.parseInt(tabTirage[5]);
		final int b2 = Integer.parseInt(tabTirage[6]);
		final int b3 = Integer.parseInt(tabTirage[7]);
		final int b4 = Integer.parseInt(tabTirage[8]);
		final int b5 = Integer.parseInt(tabTirage[9]);
		final int e1 = Integer.parseInt(tabTirage[10]);
		final int e2 = Integer.parseInt(tabTirage[11]);

		Tirage tirage = new Tirage(b1, b2, b3, b4, b5, e1, e2);
		return tirage;
	}

	private List<String> lectureFichier(File fichier) throws IOException {
		List<String> lignes = new ArrayList<String>();

		FileReader fr = new FileReader(fichier);
		BufferedReader br = new BufferedReader(fr);

		for (String ligne = br.readLine(); ligne != null; ligne = br.readLine()) {
			ligne = ligne.trim(); // on retire les espaces

			if (ligne.startsWith("#")) { // si cette ligne est en commentaire
				continue;
			}
			if (ligne.isEmpty()) { // si c'est une ligne vide
				continue;
			}

			lignes.add(ligne);
		}

		entetes(lignes.get(0)); // On récupère les entetes avant de les
		lignes.remove(0); // effacer du contenu du tableau
		fr.close();
		br.close();
		return lignes;
	}

	/* Pour les entetes */
	private void entetes(String entetes) {
		String[] tabEntetes = entetes.split(";");
		this.entetes = new ArrayList<String>(tabEntetes.length);
		for (String entete : tabEntetes) {
			this.entetes.add(entete);
		}
	}
	
}
