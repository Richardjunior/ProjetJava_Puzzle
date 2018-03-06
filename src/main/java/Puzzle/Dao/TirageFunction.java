package Puzzle.Dao;

import org.apache.log4j.Logger;

import java.util.List;

import Puzzle.Domain.Tirage;

public class TirageFunction {
	final Logger LOGGER = Logger.getLogger(CsvTirageDao.class);

	private static TirageFunction singleton;
	private CsvTirageDao dao;

	public TirageFunction() {
		dao = new CsvTirageDao();
	}

	/*
	 * Cette fonction nous permets d'avoir une instance de TirageFunction si elle
	 * n'existe pas déjà
	 */
	public static synchronized TirageFunction getInstance() {
		if (singleton == null) {
			singleton = new TirageFunction();
		}
		return singleton;
	}

	public List<Tirage> rechercheTousTirages(String nomFichier) {
		List<Tirage> tirages = dao.rechercheTousTirages(nomFichier);
		for (Tirage tirage : tirages) {
			LOGGER.info(tirage.toString() + "\n");
		}
		return tirages;
	}

}
