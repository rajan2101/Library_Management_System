package com.lms.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class book {
    @Id
    @Column(name = "book_id")
    private String bookId;
    private String title;
    private String author;
    private double price;
    private String available;

    @ManyToOne
    @JoinColumn(name = "pub_id")
    private Publisher publisher; // Relationship: Published By

    // Constructors, Getters, Setters
    public book() {}
    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getAvailable() { return available; }
    public void setAvailable(String available) { this.available = available; }
    public Publisher getPublisher() { return publisher; }
    public void setPublisher(Publisher publisher) { this.publisher = publisher; }
}