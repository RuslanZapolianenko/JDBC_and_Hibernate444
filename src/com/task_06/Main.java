package com.task_06;

import com.task_06.entity.Book;
import java.util.List;

/*
Задание 6
Создать Gradle-проект и настроить его под Hibernate.
Взять пример ex_003_hibernate_get_and_insert.
Получить объект Book и коллекцию объектов. +
Получить конкретный Book по id.+
Добавить Новый Book.+
И это все реализовать в классе BookHelper.+
 */
public class Main {

    public static void main(String[] args) {
        // Создаем объект Helper для работы с сущностью БД
        BookHelper bH = new BookHelper();

        // Создаем книгу, устанавливаем ему имя и автора добавляем в БД
        Book newBook = new Book();
        newBook.setName("Тополь");
        newBook.setAuthor_id(1);
        bH.addBook(newBook);

        // Получение книгу по айди
        Book book_id = bH.getBookById(1);
        System.out.println(book_id);

        // Получение списка Books
        List<Book> books = bH.getBookList();
        for (Book a : books) {
            System.out.println("id = " + a.getId() + " " + "Книга " + a.getName());
        }
    }
}
