package com.task_06;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Asus on 01.11.2017.
 */
public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
             factory = new AnnotationConfiguration()
                    .configure("/com/task_06/hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

}
