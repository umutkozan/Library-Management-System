package com.patika;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;  // Yazarın benzersiz kimliği

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Book> books;  // Yazarın yazdığı kitapların listesi (One-to-Many ilişkisi)

    @Column(name = "author_name", length = 100, nullable = false)
    private String name;  // Yazarın adı

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;  // Yazarın doğum tarihi

    @Column(name = "author_country", nullable = false)
    private String country;  // Yazarın ülkesi

    // Yazarın ülkesi için getter metodu
    public String getCountry() {
        return country;
    }

    // Yazarın ülkesi için setter metodu
    public void setCountry(String country) {
        this.country = country;
    }

    // Yazarın doğum tarihi için getter metodu
    public Date getBirthDate() {
        return birthDate;
    }

    // Yazarın doğum tarihi için setter metodu
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Yazarın benzersiz kimliği için getter metodu
    public int getId() {
        return id;
    }

    // Yazarın benzersiz kimliği için setter metodu
    public void setId(int id) {
        this.id = id;
    }

    // Yazarın adı için getter metodu
    public String getName() {
        return name;
    }

    // Yazarın adı için setter metodu
    public void setName(String name) {
        this.name = name;
    }

    // Boş yapıcı (default constructor)
    public Author() {
        // Kitap listesi başlatılıyor
        this.books = new ArrayList<>();
    }

    // Yazarın yazdığı kitapların listesi için getter metodu
    public List<Book> getBooks() {
        return books;
    }

    // Yazarın yazdığı kitapların listesi için setter metodu
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Yazarın bilgilerini string olarak döndürmek için toString metodu
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", country='" + country + '\'' +
                '}';
    }
}