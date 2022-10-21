package com.task_07;


// И создать класс Animal(int age, String name, boolean tail) с методами get и set,
// как сущность к нашей таблице.

import javax.persistence.*;

@Entity
@Table(name = "Animals")
public class AnimalA {

    // IDENTITY - Указание назначать первичные ключи для entity используя столбец-идентификтор в БД
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  int age;
    @Column
    private String name;
    @Column
    private boolean tail;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }
}
