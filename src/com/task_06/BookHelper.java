package com.task_06;

import com.task_06.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class BookHelper {

    // Содержит приватное поле сессии
    private SessionFactory sessionFactory;
    // этот экземпляр фабрикиСессии мы будем получать через HibernateUtil
    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    // Метод получения всех авторов
    public List<Book> getBookList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();
        // Данный класс из пакета гибернейт, передаем ему шаблон класса
        Criteria cb = session.createCriteria(Book.class);// не использовать session.createCriteria, т.к. deprecated
        //Из Критериа получаем список авторов
        List<Book> booksList = cb.list();
        //Сессию закрываем
        session.close();
        // Список возвращаем
        return booksList;
    }

    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        // Т.к. возврат метода предполагает Обжект, то нужно произвести кастинг
        Book book_id = (Book) session.get(Book.class, id); // получение объекта по id
        session.close();
        return book_id;
    }

    public Book addBook(Book newBook){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(newBook); // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();
        System.out.println("_________новая книга добавлена_________");
        return newBook;
    }


}
