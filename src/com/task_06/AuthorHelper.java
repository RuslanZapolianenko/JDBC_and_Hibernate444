package com.task_06;

import com.task_06.entity.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Asus on 01.11.2017.
 */
public class AuthorHelper {
   // Содержит приватное поле сессии
    private SessionFactory sessionFactory;
   // этот экземпляр фабрикиСессии мы будем получать через HibernateUtil
    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Метод получения всех авторов
    public List<Author> getAuthorList(){
        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

        // Данный класс из пакета гибернейт, передаем ему шаблон класса
        Criteria cb = session.createCriteria(Author.class);// не использовать session.createCriteria, т.к. deprecated
       //Из Критериа получаем список авторов
        List<Author> authorList = cb.list();
       //Сессию закрываем
        session.close();
       // Список возвращаем
        return authorList;
    }

     // Метод получаения автора по айди
    public Author getAuthorById(long id) {
        Session session = sessionFactory.openSession();
    // Т.к. возврат метода предполагает Обжект, то нужно произвести кастинг
        Author author = (Author) session.get(Author.class, id); // получение объекта по id
        session.close();
        return author;
    }

//    Метод добавления автора.
//    Используем транзакцию. Транзакция используется для операций insert, update, delete. Для выборки транзакции не нужны.
    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(author); // сгенерит ID и вставит в объект

        session.getTransaction().commit();

        session.close();

        return author;

    }
}
