
package Crud;

import javax.persistence.*;

import Entity.Author;

public class Update {

    public static void main(String[] args) {

    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Author author = em.find(Author.class, 2);
        author.setEmail("new@mail.com");

        author.getBooks().get(0).setPrice(700);

        et.commit();

        System.out.println("updated");
    }
}

