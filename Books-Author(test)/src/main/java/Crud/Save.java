package Crud;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

import Entity.Author;
import Entity.Book;

public class Save {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Author author = new Author(2, "Reema Tharega", "8888899999", "reema@mail.com");

        Book b1 = new Book(103, "Atomic Habit", 800, 99, LocalDate.now());
        Book b2 = new Book(104, "Maths 2", 200, 999, LocalDate.now());

        // dono side ko link 
        b1.setAuthor(author);
        b2.setAuthor(author);
        author.getBooks().addAll(Arrays.asList(b1, b2));


        et.begin();
        em.persist(author);   // books ko save kiya
        et.commit();

        System.out.println("saved");
    }
}
