package App.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userorderview", schema = "public", catalog = "Shop")
public class UserOrderViewEntity {
    private Integer idorder;
    private Integer user;
    private String nameprod;
    private String typename;
    private String namemanuf;
    private Long price;
    private Integer count;
    private Long finalprice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder", nullable = true)
    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    @Basic
    @Column(name = "user", nullable = true)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    @Basic
    @Column(name = "nameprod", nullable = true, length = 50)
    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    @Basic
    @Column(name = "typename", nullable = true, length = 50)
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Basic
    @Column(name = "namemanuf", nullable = true, length = 50)
    public String getNamemanuf() {
        return namemanuf;
    }

    public void setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;

    }

    @Basic
    @Column(name = "finalprice", nullable = true)
    public Long getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(Long finalprice) {
        this.finalprice = finalprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrderViewEntity that = (UserOrderViewEntity) o;
        return Objects.equals(idorder, that.idorder) &&
                Objects.equals(user, that.user) &&
                Objects.equals(nameprod, that.nameprod) &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(namemanuf, that.namemanuf) &&
                Objects.equals(price, that.price) &&
                Objects.equals(count, that.count) &&
                Objects.equals(finalprice, that.finalprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idorder, user, nameprod, typename, namemanuf, price, count, finalprice);
    }
}
