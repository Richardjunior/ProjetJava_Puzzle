package Puzzle.Jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.log4j.Logger;

import Puzzle.Dao.CsvTirageDao;
import Puzzle.modelTable.DynamicModel;

public class PuzzleJFrame extends JFrame {
	final Logger LOGGER = Logger.getLogger(CsvTirageDao.class);

	private JTable table;
	private DynamicModel model;
	private final JButton buttonSelectionner;
	private final JButton buttonAnnuler;
	private CsvTirageDao dao;
	private String nomFichierAcces = "src/main/resources/euromillions_4.csv";

	public PuzzleJFrame() {
		model = new DynamicModel();
		setTitle("Puzzle");
		setPreferredSize(new Dimension(1380, 1036));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		table = new JTable(model);
		table.setAutoCreateRowSorter(true);

		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		/*
		 * Zone de gestion des Boutons
		 */
		final JPanel boutonPanel = new JPanel();
		boutonPanel.setBackground(Color.DARK_GRAY);
		ImageIcon imgSelectionner = new ImageIcon("src/main/resources/buttonSelectionner.png");
		ImageIcon imgAnnuler = new ImageIcon("src/main/resources/buttonAnnuler.png");
		buttonSelectionner = new JButton(new SelectionnerUnTirageAction("", imgSelectionner));
		buttonAnnuler = new JButton(new AnnulerOperationSurTirage("", imgAnnuler));
		boutonPanel.add(buttonSelectionner);
		boutonPanel.add(buttonAnnuler);
		getContentPane().add(boutonPanel, BorderLayout.SOUTH);
		/*
		 * Fin de la zone de gestion des boutons
		 **/
		pack();
		setLocationRelativeTo(null);
	}

	/*
	 * C'est cette action qui est appelée lorsque on clique sur le bouton
	 * Selectionner.
	 * 
	 * Il permet de mettre en écoute les évènements du boutons Selectionner et
	 * d'exécuter les actions qui se trouvent dans actionPerformed(ActionEvent e)
	 */
	private class SelectionnerUnTirageAction extends AbstractAction {
		final Logger LOGGER = Logger.getLogger(CsvTirageDao.class);
		private int boule1s[];
		private int boule2s[];
		private int boule3s[];
		private int boule4s[];
		private int boule5s[];

		private SelectionnerUnTirageAction(String texte, ImageIcon img) {
			super(texte, img);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			LOGGER.info("Vous avez cliqué sur selectionner");
			final int[] rows = table.getSelectedRows();
			boule1s = null;
			boule2s = null;
			boule3s = null;
			boule4s = null;
			boule5s = null;
			/*
			 * je l'utiliserais pour savoir quelles sont lignes qui ont été selectionné pour
			 * le tirage for (int i = rows.length - 1; 0 < i; i--) {
			 * 
			 * }
			 */
			if (rows.length != 0) {
				final JFrame frame = new ImagePuzzleJFrame();
				dao = new CsvTirageDao();

				for (int i = 0; i <= rows.length; i++) {
					boule1s[i] = dao.rechercheTousTirages(nomFichierAcces).get(rows[i]).getBoule1();
					boule2s[i] = dao.rechercheTousTirages(nomFichierAcces).get(rows[i]).getBoule2();
					boule3s[i] = dao.rechercheTousTirages(nomFichierAcces).get(rows[i]).getBoule3();
					boule4s[i] = dao.rechercheTousTirages(nomFichierAcces).get(rows[i]).getBoule4();
					boule5s[i] = dao.rechercheTousTirages(nomFichierAcces).get(rows[i]).getBoule5();

				}
				//LOGGER.info("Les boules selectionnées sont : [" + boule1s + " " + boule2s + " " + boule3s + " " + boule4s
				//		+ " " + boule5s + "]");
				frame.setVisible(true);

			}
		}

	}

	/*
	 * Pareillement pour le bouton Annuler
	 */
	private class AnnulerOperationSurTirage extends AbstractAction {
		final Logger LOGGER = Logger.getLogger(CsvTirageDao.class);

		private AnnulerOperationSurTirage(String texte, ImageIcon img) {
			super(texte, img);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			LOGGER.info("Vous avez cliqué sur Annuler");
		}

	}

}
