package com.patika;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;  // Yayınevinin benzersiz kimliği

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Book> books;  // Yayınevinin yayımladığı kitapların listesi, publisher ile bağlantılı

    @Column(name = "publisher_name", length = 100, nullable = false)
    private String publisherName;  // Yayınevinin adı

    @Temporal(TemporalType.DATE)
    @Column(name = "establish_year", nullable = false)
    private Date establishYear;  // Yayınevinin kuruluş yılı (tarih formatında)

    @Column(name = "publisher_address", length = 200, nullable = false)
    private String publisherAddress;  // Yayınevinin adresi

    // Kuruluş yılı için getter metodu
    public Date getEstablishYear() {
        return establishYear;
    }

    // Kuruluş yılı için setter metodu
    public void setEstablishYear(Date establishYear) {
        this.establishYear = establishYear;
    }

    // Yayınevi adresi için getter metodu
    public String getPublisherAddress() {
        return publisherAddress;
    }

    // Yayınevi adresi için setter metodu
    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    // Yayınevi adı için getter metodu
    public String getPublisherName() {
        return publisherName;
    }

    // Yayınevi adı için setter metodu
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
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
    public Publisher() {
    }

    // Kitap listesi için getter metodu
    public List<Book> getBooks() {
        return books;
    }

    // Kitap listesi için setter metodu
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}