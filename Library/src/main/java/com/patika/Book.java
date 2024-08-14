package com.patika;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;  // Kitabın benzersiz kimliği

    @ManyToOne
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;  // Kitabın yazarıyla ilişkilendirilmesi (Many-to-One ilişkisi)

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_categories",
            joinColumns = {@JoinColumn(name = "book_category_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_category_category_id")}
    )
    private List<Category> categoryList;  // Kitabın kategorileriyle ilişkilendirilmesi (Many-to-Many ilişkisi)

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;  // Kitabın yayıneviyle ilişkilendirilmesi (Many-to-One ilişkisi)

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<BookBorrowing> bookBorrowings;  // Kitabın ödünç alma işlemleriyle ilişkilendirilmesi (One-to-Many ilişkisi)

    @Column(name = "book_name", length = 150, nullable = false, unique = true)
    private String name;  // Kitabın adı

    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;  // Kitabın yayın yılı

    @Column(name = "stock_count", nullable = false)
    private Integer book_stock;  // Kütüphanedeki mevcut stok miktarı

    // Kitabın stok miktarı için getter metodu
    public Integer getBook_stock() {
        return book_stock;
    }

    // Kitabın stok miktarı için setter metodu
    public void setBook_stock(Integer book_stock) {
        this.book_stock = book_stock;
    }

    // Kitabın benzersiz kimliği için getter metodu
    public int getId() {
        return id;
    }

    // Kitabın benzersiz kimliği için setter metodu
    public void setId(int id) {
        this.id = id;
    }

    // Kitabın yayın yılı için getter metodu
    public Integer getPublicationYear() {
        return publicationYear;
    }

    // Kitabın yayın yılı için setter metodu
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Kitabın adı için getter metodu
    public String getName() {
        return name;
    }

    // Kitabın adı için setter metodu
    public void setName(String name) {
        this.name = name;
    }

    // Kitabın yazarı için getter metodu
    public Author getAuthor() {
        return author;
    }

    // Kitabın yazarı için setter metodu
    public void setAuthor(Author author) {
        this.author = author;
    }

    // Boş yapıcı (default constructor)
    public Book() {
    }

    // Kitabın bilgilerini string olarak döndürmek için toString metodu
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", book_stock=" + book_stock +
                '}';
    }
}