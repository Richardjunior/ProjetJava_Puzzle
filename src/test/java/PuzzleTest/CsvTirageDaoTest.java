package PuzzleTest;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import Puzzle.Dao.CsvTirageDao;
import Puzzle.Domain.Tirage;

public class CsvTirageDaoTest {
	private CsvTirageDao dao;
	private final String nomFichier;


	final Logger LOGGER = Logger.getLogger(CsvTirageDaoTest.class);

	public CsvTirageDaoTest() {
		dao = new CsvTirageDao();
		nomFichier = "src/main/resources/euromillions_4.csv";

	}

	/*
	 * Test du nombre totale des lignes du fichiers CSV
	 */
	@Test
	public void testRechercheTousTirages_resultat_Attendu() {
		LOGGER.info("Debut::: testRechercheTousTirages_resultat_Attendu() ");
		final int expectedSize = 145;

		final int actualSize = dao.rechercheTousTirages(nomFichier).size();

		Assert.assertEquals(expectedSize, actualSize);
		LOGGER.info("Fin::: testRechercheTousTirages_resultat_Attendu() ");

	}

	/*
	 * Test de la première ligne du fichier Csv
	 */
	@Test
	public void testRechercheTousTirages_tirage_0() {
		LOGGER.info("Debut::: testRechercheTousTirages_tirage_0() ");

		final int numTirage = 0;
		final Tirage expectedTirage = new Tirage(41, 6, 13, 39, 9, 2, 12);

		final Tirage actualTirage = dao.rechercheTousTirages(nomFichier).get(numTirage);

		Assert.assertEquals(expectedTirage.toString(), actualTirage.toString());
		LOGGER.info("Debut::: testRechercheTousTirages_tirage_0() ");

	}

	/*
	 * Test de la deuxième ligne du fichicer CSV
	 */
	@Test
	public void testRechercheTousTirages_tirage_1() {
		LOGGER.info("Debut::: testRechercheTousTirages_tirage_1() ");

		final int numTirage = 1;
		final Tirage expectedTirage = new Tirage(35, 44, 17, 37, 43, 10, 2);

		final Tirage actualTirage = dao.rechercheTousTirages(nomFichier).get(numTirage);

		Assert.assertEquals(expectedTirage.toString(), actualTirage.toString());
		LOGGER.info("Fin::: testRechercheTousTirages_tirage_1() ");

	}
}
