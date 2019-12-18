package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {

	@Id
	private int id;

	@Column(name = "numero")
	private String numero;

	@Column(name = "solde")
	private double solde;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_com", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_cli", referencedColumnName = "id"))
	private Set<Client> clients;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Operation operation;

}
