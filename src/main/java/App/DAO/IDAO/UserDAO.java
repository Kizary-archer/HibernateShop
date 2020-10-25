package App.DAO.IDAO;

import App.Entities.UserEntity;
import App.Entities.UserOrderViewEntity;

import java.util.List;

public interface UserDAO extends IDAO<UserEntity> {
    UserEntity getUserByLogin(String login);

}
