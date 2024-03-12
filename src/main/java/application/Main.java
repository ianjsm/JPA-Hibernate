package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p1 = new Pessoa(null, "Jeremias Jacó", "jeremias@gmail.com");
		
		em.getTransaction();
		em.persist(p1);
		em.getTransaction().commit();
		System.out.println("ADD DONE!");
		

		Pessoa p = em.find(Pessoa.class, 2);		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("REMOVE DONE!");
		em.close();
		emf.close();
	}
}