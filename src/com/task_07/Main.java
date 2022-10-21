package com.task_07;

        /*
        Задание 7
        Создать новую базу данных с помощью MySQLWorkbench.
        Создать обычный java-проект и подключить к нему библиотеки JPA и Hibernate.+
        Создать файл с настройками persistence.xml в папке META-INF.+
        И создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
        И с помощью jpa сделать crud в классе AnimalHelper.
         */

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр класса для работы с клиентом.
        AnimalHelper aH = new AnimalHelper();

        // Добавление нового клиента id сгенерится автоматически
        AnimalA animalA = new AnimalA();
        animalA.setName("Test_Name_1");
        animalA.setAge(5);
        animalA.setTail(true);
        aH.add(animalA);

        // Получение Animal по id
        animalA = aH.getById(2);
        System.out.println("ID = " + animalA.getId() + " Имя = "+ animalA.getName());

        // Обновление возраста по ID
        animalA.setAge(12);
        aH.add(animalA);

        // Получение всех клиентов
        List<AnimalA> animalList = aH.getAllAnimal();
        for (AnimalA animal : animalList ) {
            System.out.println(animal.getName() + " ");
        }

        // Удаление animal по ID
         aH.removeAnimal(animalA);
    }
}
