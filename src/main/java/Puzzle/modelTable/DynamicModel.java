package Puzzle.modelTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.log4j.Logger;

import Puzzle.Dao.CsvTirageDao;
import Puzzle.Dao.TirageFunction;
import Puzzle.Domain.Tirage;

public class DynamicModel extends AbstractTableModel {

	private List<Tirage> tirages;
	private String[] entetes;
	private final String NOM_FICHIER = "src/main/resources/euromillions_4.csv";
	private final TirageFunction service = TirageFunction.getInstance();
	final Logger LOGGER = Logger.getLogger(CsvTirageDao.class);

	public DynamicModel() {
		super();

		tirages = service.rechercheTousTirages(NOM_FICHIER);
		for (Tirage tirage : tirages) {
			LOGGER.info(tirage.toString());
		}
		entetes = new String[] { "Numéro du tirage", "Boule 1", "Boule 2", "Boule 3", "Boule 4", "Boule 5", "Etoile 1",
				"Etoile 2" };

	}

	public int getColumnCount() {
		return entetes.length;
	}

	public int getRowCount() {
		return tirages.size();
	}

	public Object getValueAt(int row, int col) {
		Object value = null;
		if ((col < 0 || col > entetes.length - 1) || (row < 0 || row > tirages.size() - 1)) {
			throw new IllegalArgumentException("Ligne ou colonne non-exitante");
		}
		switch (col) {
		case 0:
			value = row;
			break;

		case 1:
			value = tirages.get(row).getBoule1();
			break;

		case 2:
			value = tirages.get(row).getBoule2();
			break;

		case 3:
			value = tirages.get(row).getBoule3();
			break;

		case 4:
			value = tirages.get(row).getBoule4();
			break;

		case 5:
			value = tirages.get(row).getBoule5();
			break;

		case 6:
			value = tirages.get(row).getEtoile1();
			break;

		case 7:
			value = tirages.get(row).getEtoile1();
			break;

		}
		return value;
	}

	public List<Tirage> getTirages() {
		return tirages;
	}

	public String getColumnName(int columnIndex) {
		if (columnIndex < 0 || columnIndex > entetes.length - 1) {
			throw new IllegalArgumentException("Cette colonne n'existe pas");
		}
		return entetes[columnIndex];
	}

	/*
	 * Selection de tirage
	 */

	public void SelectionnerUnTirage() {
		LOGGER.info("Selection d'un Tirage");
	}

}
