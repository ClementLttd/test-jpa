package banque;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column (name="numero")
	private int numero;
	
	@Column (name="rue")
	private String rue;
	
	@Column (name="code_postal")
	private int codePostal;
	
	@Column (name="ville")
	private String ville;

}
