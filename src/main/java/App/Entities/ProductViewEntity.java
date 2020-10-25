package App.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productview", schema = "public", catalog = "Shop")
public class ProductViewEntity {
    private Integer idproduct;
    private String nameprod;
    private String typename;
    private String namemanuf;
    private Long price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct", nullable = true)
    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    @Basic
    @Column(name = "nameprod", nullable = true, length = 50)
    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductViewEntity that = (ProductViewEntity) o;
        return Objects.equals(idproduct, that.idproduct) &&
                Objects.equals(nameprod, that.nameprod) &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(namemanuf, that.namemanuf) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, nameprod, typename, namemanuf, price);
    }
}
