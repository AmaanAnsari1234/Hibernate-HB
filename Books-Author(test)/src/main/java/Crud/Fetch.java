package Crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity.Author;
import Entity.Book;

public class Fetch {

    public static void main(String[] args) {

    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
         EntityManager em = emf.createEntityManager();
         EntityTransaction et = em.getTransaction();
    		
        Author author = em.find(Author.class, 2);

        if (author != null) {

            System.out.println("Author Name: " + author.getName());
            System.out.println("Email: " + author.getEmail());

            System.out.println("Books written:");

            
            for (Book b : author.getBooks()) {
                System.out.println(
                    "Book ID: " + b.getBid() +
                    ", Name: " + b.getName() +
                    ", Price: " + b.getPrice()
                );
            }

        } else {
            System.out.println("Author not found");
        }

        em.close();
        emf.close();
    }
}
