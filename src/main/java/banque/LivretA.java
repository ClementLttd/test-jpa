package banque;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;


@Entity
@DiscriminatorValue("LIVRET_A")
public class LivretA extends Compte {

	@Column (name="TAUX")
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
