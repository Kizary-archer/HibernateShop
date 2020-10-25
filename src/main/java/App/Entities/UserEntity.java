package App.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "public", catalog = "Shop")
public class UserEntity {
    private Integer iduser;
    private String login;
    private String password;
    private Collection<UserOrderEntity> userordersByIduser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(iduser, that.iduser) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, login, password);
    }

    @OneToMany(mappedBy = "userByUser")
    public Collection<UserOrderEntity> getUserordersByIduser() {
        return userordersByIduser;
    }

    public void setUserordersByIduser(Collection<UserOrderEntity> userordersByIduser) {
        this.userordersByIduser = userordersByIduser;
    }
}
