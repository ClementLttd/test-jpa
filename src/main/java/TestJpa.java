import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {
	
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
				
		//méthode pour récupérer les infos d'un livre
		Livre l1 = em.find(Livre.class, 3);
		if (l1!=null) {
			System.out.println(l1);
		}
		
		TypedQuery<Livre>query=em.createQuery("select l1 from Livre l1 where l1.id='3'",Livre.class);
		Livre l2=query.getResultList().get(0);
		//fin de la méthode de récupération de données
		
		//récupération d'un emprunt = requête d'extraction d'un emprunt avec tous ses livres provenant du toString de la classe Emprunt
		Emprunt e1 = em.find(Emprunt.class, 1);
		if (e1!=null) {
			System.out.println(e1);
		}
		
		TypedQuery<Emprunt>query2=em.createQuery("select e1 from Emprunt e1 where e1.id='1'",Emprunt.class);
		Emprunt e2=query2.getResultList().get(0);
		//fin méthode
		
		//requête d'extraction d'un client avec tous ses emprunts provenant du toString de la classe Client 
		Client c1 = em.find(Client.class, 1);
		if (c1!=null) {
			System.out.println(c1);
		}
		
		TypedQuery<Client>query3=em.createQuery("select c1 from Emprunt c1 where c1.id='1'",Client.class);
		Client c3=query3.getResultList().get(0);
		
		em.close();
		entityManagerFactory.close();
	}
}
