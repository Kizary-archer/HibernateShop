package App.Service;

import App.DAO.IDAO.UserOrderDAO;
import App.DAO.UserOrderDAOImpl;
import App.Entities.*;

import java.util.List;

public class UserOrderService {
    UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    public List<UserOrderViewEntity> getUserOrderViewList(UserEntity userEntity) {
        return userOrderDAO.getUserOrderViewList(userEntity);
    }

    public List<ManufactureEntity> getManufactureList() {
        return userOrderDAO.getManufactureList();
    }

    public List<ProdTypeEntity> getProdTypeList() {
        return userOrderDAO.getProdTypeList();
    }

    public boolean addOrder(UserOrderEntity userOrderEntity) {
        return userOrderDAO.add(userOrderEntity);
    }
    public boolean delOrder(Integer id) {
              return userOrderDAO.delById(id);
    }
}
