package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private int bid;

    private String name;
    private double price;
    private int pages;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "author_id")   
    private Author author;

    public Book() {}

    public Book(int bid, String name, double price, int pages, LocalDate date) {
        this.bid = bid;
        this.name = name;
        this.price = price;
        this.pages = pages;
        this.date = date;
    }

    
    public int getBid() { return bid; }
    public void setBid(int bid) { this.bid = bid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}

