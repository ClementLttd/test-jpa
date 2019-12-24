package banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import banque.Adresse;
import banque.Banque;
import banque.Client;
import banque.Compte;
import banque.Operation;


public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		//instance de banque
		Banque b1 = new Banque();
		b1.setNom("BNP");
		em.persist(b1);
		
		//instance client 1
		Client c1 = new Client();
		c1.setAdresse(new Adresse(45, "Avenue Charles de Gaulle", 34000, "Montpellier"));
		c1.setDateNaissance(LocalDate.of(1970,11,24));
		c1.setNom("Zidane");
		c1.setPrenom("Zinedine");
		em.persist(c1);
		c1.setBanque(b1);		
		
		//instance client 2
		Client c2 = new Client();
		c2.setAdresse(c1.getAdresse());
		c2.setDateNaissance(LocalDate.of(1992,9,11));
		c2.setNom("Durand");
		c2.setPrenom("Paul");
		em.persist(c2);
		c2.setBanque(b1);
		
		//instance de compte
		Compte co1 = new Compte();
		co1.setNumero("A528B");
		co1.setSolde(4500.32);
		co1.getClients().add(c1);
		co1.getClients().add(c2);
		em.persist(c1);
		
		//insertion client avec livret a + assurance vie
		
		Banque b2 = new Banque();
		b1.setNom("Credit Agricole");
		em.persist(b2);
		
		Client c3 = new Client();
		c3.setAdresse(new Adresse(6, "Place Jacques Bonsergent", 75010, "Paris"));
		c3.setDateNaissance(LocalDate.of(1992, 12, 8));
		c3.setNom("Dupont");
		c3.setPrenom("Kevin");
		c3.setBanque(b2);
		em.persist(c3);
		
		
		LivretA la = new LivretA();
		la.setNumero("VS4567DB");
		la.setTaux(1.04);
		la.setSolde(10000);
		la.getClients().add(c3);
		em.persist(la);
		
		AssuranceVie av = new AssuranceVie();
		av.setNumero("SLR43597F");
		av.setTaux(1.5);
		av.setSolde(5000);
		av.getClients().add(c3);
		em.persist(av);
		
		Virement vr = new Virement();
		vr.setCompte(av);
		vr.setDate(LocalDate.of(2018, 11, 15));
		vr.setMontant(1200);
		vr.setMotif("assurance vie");
		em.persist(vr);
				
		Operation op = new Operation();
		op.setCompte(la);
		op.setDate(LocalDate.of(2019, 12, 10));
		op.setMontant(1000);
		op.setMotif("blabla");
		em.persist(op);
		
		transaction.commit();
		
		em.close();
		
		emf.close();

	}

}
