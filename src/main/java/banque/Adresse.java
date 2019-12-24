package banque;

import javax.persistence.*;

@Embeddable
public class Adresse {
	
	
	@Column(name = "numero", nullable = false)
	private int numero;
	
	@Column(name = "rue", length = 50 , nullable = false)
	private String rue;
	
	@Column(name = "code_postal", nullable = false)
	private int codePostal;

	@Column(name = "ville", length = 50 , nullable = false)
	private String ville;
	
	public Adresse(){}
	/**
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param villes
	 */
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/** Getter
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/** Setter
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/** Getter
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/** Getter
	 * @return the ville
	 */
	public String getVilles() {
		return ville;
	}

	/** Setter
	 * @param villes the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
