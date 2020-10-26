package App.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userorder", schema = "public", catalog = "Shop")
public class UserOrderEntity {
    private Integer idorder;
    private Integer shuser;
    private Integer product;
    private Integer count;
    private UserEntity userByUser;
    private ProductEntity productByProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorder", nullable = false)
    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    @Basic
    @Column(name = "shuser", nullable = false)
    public Integer getShuser() {
        return shuser;
    }

    public void setShuser(Integer user) {
        this.shuser = user;
    }

    @Basic
    @Column(name = "product", nullable = false)
    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrderEntity that = (UserOrderEntity) o;
        return Objects.equals(idorder, that.idorder) &&
                Objects.equals(shuser, that.shuser) &&
                Objects.equals(product, that.product) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idorder, shuser, product, count);
    }

    @ManyToOne
    @JoinColumn(name = "shuser", referencedColumnName = "iduser", nullable = false,insertable = false, updatable = false)
    public UserEntity getUserByUser() {
        return userByUser;
    }

    public void setUserByUser(UserEntity userByUser) {
        this.userByUser = userByUser;
    }

    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "idproduct", nullable = false,insertable = false, updatable = false)
    public ProductEntity getProductByProduct() {
        return productByProduct;
    }

    public void setProductByProduct(ProductEntity productByProduct) {
        this.productByProduct = productByProduct;
    }
}
