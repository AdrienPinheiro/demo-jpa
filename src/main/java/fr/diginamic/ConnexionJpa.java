package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("db-java-jdbc-tp");
        EntityManager em = emf.createEntityManager();
        Auteurs auteur = em.find(Auteurs.class, 74);
        if(auteur!=null){
            System.out.println(auteur);
        }

        Auteurs newAuteur = new Auteurs();
        newAuteur.setName("Sophie");
        newAuteur.setLastname("Thomas");
        em.getTransaction().begin();
        em.persist(newAuteur);
        em.getTransaction().commit();

        TypedQuery<Auteurs> request = em.createQuery("SELECT a FROM Auteurs a", Auteurs.class);
        List<Auteurs> auteurs = request.getResultList();
        System.out.println("Nombre d'auteurs " + auteurs.size());
        auteurs.forEach(System.out::println);

    }
}
