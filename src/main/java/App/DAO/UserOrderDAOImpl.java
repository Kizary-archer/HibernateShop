package App.DAO;

import App.DAO.IDAO.UserOrderDAO;
import App.Entities.ManufactureEntity;
import App.Entities.ProdTypeEntity;
import App.Entities.UserEntity;
import App.Entities.UserOrderViewEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class UserOrderDAOImpl implements UserOrderDAO {


    @Override
    public List<UserOrderViewEntity> getUserOrderViewList(UserEntity userEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  uov " +
                    "from UserOrderViewEntity uov " +
                    "where uov.user = :idUser";
            Query query = session.createQuery(hql);
            query.setParameter("idUser", userEntity.getIduser());
            List<UserOrderViewEntity> res = query.getResultList();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<ManufactureEntity> getManufactureList() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  m " +
                    "from ManufactureEntity m ";
            Query query = session.createQuery(hql);
            List<ManufactureEntity> res = (List<ManufactureEntity>) query.getResultList();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<ProdTypeEntity> getProdTypeList() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  p " +
                    "from ProdTypeEntity p ";
            Query query = session.createQuery(hql);
            List<ProdTypeEntity> res = (List<ProdTypeEntity>) query.getResultList();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
