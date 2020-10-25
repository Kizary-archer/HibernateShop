package App.Service;

import App.DAO.IDAO.UserDAO;
import App.DAO.UserDAOImpl;
import App.Entities.UserEntity;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();

    public UserEntity authorization(String login, String pass) {
        if (login != null && pass != null) {
            UserEntity user = userDAO.getUserByLogin(login);
            if (user != null && BCrypt.checkpw(pass, user.getPassword())) return user;
        }
        return null;
    }

    public boolean registration(String login, String pass) {
        if (login != null && pass != null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setLogin(login);
            userEntity.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt(12)));//кодирование пароля
            return userDAO.add(userEntity);
        }
       return false;
    }
}
