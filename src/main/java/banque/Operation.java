package banque;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="OPERATION")
public class Operation {
	
	@Id
	private int id;
	
	@Column (name="date")
	private LocalDateTime date;
	
	@Column (name="montant")
	private double montant;
	
	@Column (name="motif")
	private String motif;
	
	@OneToMany (mappedBy="operation")
	private Set<Compte> comptes;
	
	public Operation() {
		comptes = new HashSet<Compte>();
	}

}
