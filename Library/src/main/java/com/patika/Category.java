package com.patika;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;  // Kategorinin benzersiz kimliği

    @ManyToMany(mappedBy = "categoryList")
    private List<Book> books;  // Bu kategoride bulunan kitapların listesi, Book sınıfındaki "categoryList" tarafından yönetilir

    @Column(name = "category_name", length = 150, nullable = false)
    private String categoryName;  // Kategori adı

    @Column(name = "category_description", length = 350, nullable = false)
    private String categoryDescription;  // Kategori açıklaması

    // Kategori adı için getter metodu
    public String getCategoryName() {
        return categoryName;
    }

    // Kategori adı için setter metodu
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // ID için getter metodu
    public int getId() {
        return id;
    }

    // ID için setter metodu
    public void setId(int id) {
        this.id = id;
    }

    // Kategori açıklaması için getter metodu
    public String getCategoryDescription() {
        return categoryDescription;
    }

    // Kategori açıklaması için setter metodu
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    // Boş yapıcı (default constructor)
    public Category() {
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