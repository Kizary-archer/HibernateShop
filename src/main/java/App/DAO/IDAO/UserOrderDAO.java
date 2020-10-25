package App.DAO.IDAO;

import App.Entities.*;

import java.util.List;

public interface UserOrderDAO extends IDAO<UserOrderEntity> {

    List<UserOrderViewEntity> getUserOrderViewList(UserEntity userEntity);
    List<ManufactureEntity> getManufactureList();
    List<ProdTypeEntity> getProdTypeList();


}
