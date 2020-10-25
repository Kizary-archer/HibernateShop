package App.DAO.IDAO;

import App.Util.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface IDAO<T> {

     default Session getSession() throws HibernateException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }

     default boolean add(T t){
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

     default boolean update(T t){
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public default boolean delete(T t){
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
