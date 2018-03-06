package Puzzle.Domain;

/*
 * La classe qui contient les attributs des tirages
 */
public class Tirage {
	/* Les 5 boules du tirages */
	private final int boule1;
	private final int boule2;
	private final int boule3;
	private final int boule4;
	private final int boule5;
	/* Les 2 étoiles du tirage */
	private final int etoile1;
	private final int etoile2;

	/*
	 * Le constructeur de la classe qui initialise les attributs
	 */
	public Tirage(int boule1, int boule2, int boule3, int boule4, int boule5, int etoile1, int etoile2) {
		super();
		this.boule1 = boule1;
		this.boule2 = boule2;
		this.boule3 = boule3;
		this.boule4 = boule4;
		this.boule5 = boule5;
		this.etoile1 = etoile1;
		this.etoile2 = etoile2;
	}

	/*
	 * Les getters et les Setters
	 */
	public int getBoule1() {
		return boule1;
	}

	public int getBoule2() {
		return boule2;
	}

	public int getBoule3() {
		return boule3;
	}

	public int getBoule4() {
		return boule4;
	}

	public int getBoule5() {
		return boule5;
	}

	public int getEtoile1() {
		return etoile1;
	}

	public int getEtoile2() {
		return etoile2;
	}

	@Override
	public String toString() {
		return "Tirage [boule1=" + boule1 + ", boule2=" + boule2 + ", boule3=" + boule3 + ", boule4=" + boule4
				+ ", boule5=" + boule5 + ", etoile1=" + etoile1 + ", etoile2=" + etoile2 + "]";
	}

}
