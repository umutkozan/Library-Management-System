package com.patika;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_borrowing")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;  // Kitap ödünç alma işleminin benzersiz kimliği

    @Column(name = "borrower_name", length = 150, nullable = false)
    private String borrowerName;  // Kitap ödünç alan kişinin adı

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date", nullable = false)
    private Date borrowingDate;  // Kitabın ödünç alındığı tarih

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date returnDate;  // Kitabın geri iade edildiği tarih (ilk başta null olabilir)

    @ManyToOne
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;  // Ödünç alınan kitabı temsil eden Book nesnesi

    // Ödünç alma tarihi için getter metodu
    public Date getBorrowingDate() {
        return borrowingDate;
    }

    // Ödünç alma tarihi için setter metodu
    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    // Geri iade tarihi için getter metodu
    public Date getReturnDate() {
        return returnDate;
    }

    // Geri iade tarihi için setter metodu
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Ödünç alan kişi adı için getter metodu
    public String getBorrowerName() {
        return borrowerName;
    }

    // Ödünç alan kişi adı için setter metodu
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // ID için getter metodu
    public int getId() {
        return id;
    }

    // ID için setter metodu
    public void setId(int id) {
        this.id = id;
    }

    // Boş yapıcı (default constructor)
    public BookBorrowing() {
    }

    // Kitap için getter metodu
    public Book getBook() {
        return book;
    }

    // Kitap için setter metodu
    public void setBook(Book book) {
        this.book = book;
    }
}
