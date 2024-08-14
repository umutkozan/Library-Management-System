package com.patika;

import javax.persistence.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // EntityManagerFactory, Persistence birimini başlatmak için kullanılır.
        // Bu satırda, 'library' isimli persistence-unit kullanılarak bir EntityManagerFactory oluşturulur.
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");

        // EntityManager, veritabanı işlemlerini gerçekleştirmek için kullanılır.
        // Bu satırda, EntityManagerFactory'den bir EntityManager örneği oluşturulur.
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // EntityTransaction, veritabanı işlemlerini bir bütün olarak yönetmek için kullanılır.
        // Bu satırda, EntityManager üzerinden bir EntityTransaction başlatılır.
        EntityTransaction entityTransaction = entityManager.getTransaction();

        // Burada veritabanı işlemleri gerçekleştirilebilir.
        // Örneğin: entityTransaction.begin(), entityManager.persist(), entityTransaction.commit(), vb.
    }
}
