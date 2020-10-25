package App.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();
                    configuration.configure();
                    sessionFactory = configuration.buildSessionFactory();
                } catch (Throwable ex) {
                    throw new ExceptionInInitializerError(ex);
                }
            }
        return sessionFactory;
    }
}