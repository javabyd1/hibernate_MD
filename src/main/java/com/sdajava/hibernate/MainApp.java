package com.sdajava.hibernate;

import com.sdajava.hibernate.entity.BooksEntity;
import javafx.scene.layout.Pane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class MainApp {

    private static final SessionFactory sessionfactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionfactory = configuration.buildSessionFactory();
        } catch (Throwable x) {
            throw new ExceptionInInitializerError(x);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionfactory.openSession();
    }

    public static void main(String[] args) {

        Session session = sessionfactory.openSession();

        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            BooksEntity booksEntity = new BooksEntity();
            booksEntity.setAuthor("Marek Kafarek");
            booksEntity.setTitle("Pakowanie na Ekranie");
            booksEntity.setCategory("Sportowe");
            session.save(booksEntity);
            transaction.commit();

            transaction = session.beginTransaction();
            List<BooksEntity> bookList = session.createQuery("FROM " + BooksEntity.class.getName()).list();

            for (BooksEntity book : bookList) {
                System.out.println(book.getTitle());
                System.out.println(book.getAuthor());
                System.out.println(book.getCategory() + "\n");
            }
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionfactory.close();
        }
    }
}
