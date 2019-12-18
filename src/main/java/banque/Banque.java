package banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="BANQUE")
public class Banque {
	
	@Id
	private int id;
	
	@Column (name="nom")
	private String nom;
	
	@OneToMany (mappedBy="banque")
	private Set<Client> clients;
	
	public Banque() {
		clients = new HashSet<Client>();
	}
	

}
