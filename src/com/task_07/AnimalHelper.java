package com.task_07;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {

    //    Внутри будут два объекта
    EntityManagerFactory emf;
    EntityManager em;
    // При создании класса будет вызываться конструктор и создаваться эти два объекта.
    public AnimalHelper() {
        //  При создании фабрики мы указываем имя, которое указали в насторойках persistence.xml
        emf = Persistence.createEntityManagerFactory("mohr");
        // Создаем энтитименеджера, через которого мы будем делать наши операции.
        em = emf.createEntityManager();
    }

    public void add(AnimalA a) {
        em.getTransaction().begin();
        //  Вместо save в примере с гибернейт, здесь используется метод merge для добавления клиента в таблицу
        em.merge(a);
        em.getTransaction().commit();
        emf.close();
    }

    public AnimalA getById(int id) {
//        Начинаем транзакцию
        em.getTransaction().begin();
//        Находим клиента по id
        AnimalA animalA = em.find(AnimalA.class, id);
        em.getTransaction().commit();
//        Закрываем все соединения в EntityManagerFactory
        emf.close();
        return animalA;
    }

    public void removeAnimal(AnimalA a) {
        em.getTransaction().begin();
        // Удаление клиента из таблицы
        em.remove(a);
        em.getTransaction().commit();
        emf.close();
    }


      public List<AnimalA> getAllAnimal() {
        em.getTransaction().begin();
        // Получаем объект типа Query - осуществляем запрос, но он не совсем SQL, Это уже с ООП подходом. Это HQL
        // animals - это таблицы в БД и имя таблицы в классе. AnimalA - это класс, который является образом этой таблицы.
        Query query = em.createQuery("SELECT animals FROM AnimalA animals");
        // Полученный результат записываем в список
        List<AnimalA> animalA = query.getResultList();
        em.getTransaction().commit();
        emf.close();
        return animalA;
    }


}
