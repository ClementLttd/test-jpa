package banque;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "id")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_cli", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_com", referencedColumnName = "id"))
	private Set<Compte> comptes;

}
