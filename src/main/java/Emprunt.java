import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table (name="EMPRUNT")

public class Emprunt {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column (name="DATE_DEBUT")
	private LocalDateTime dateDebut;
	
	@Column (name = "DELAI")
	private int delai;
	
	@Column (name = "DATE_FIN")
	private LocalDateTime dateFin;
	
	@ManyToMany
	@JoinTable (name="COMPO",
	joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;

	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	public String toString() {
		return "id =" + id + " livres = " + livres.size();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	
	
	

}
