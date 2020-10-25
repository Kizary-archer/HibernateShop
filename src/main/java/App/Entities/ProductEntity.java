package App.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "public", catalog = "Shop")
public class ProductEntity {
    private Integer idproduct;
    private String nameprod;
    private Integer type;
    private Long price;
    private ManufactureEntity manufactureByManufacture;
    private ProdTypeEntity prodtypeByType;
    private Collection<UserOrderEntity> userordersByIdproduct;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct", nullable = false)
    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    @Basic
    @Column(name = "nameprod", nullable = false, length = 50)
    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price", nullable = false)
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
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(idproduct, that.idproduct) &&
                Objects.equals(nameprod, that.nameprod) &&
                Objects.equals(type, that.type) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, nameprod, type, price);
    }

    @ManyToOne
    @JoinColumn(name = "manufacture", referencedColumnName = "idmanuf", nullable = false)
    public ManufactureEntity getManufactureByManufacture() {
        return manufactureByManufacture;
    }

    public void setManufactureByManufacture(ManufactureEntity manufactureByManufacture) {
        this.manufactureByManufacture = manufactureByManufacture;
    }

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "idtype", nullable = false,insertable = false, updatable = false)
    public ProdTypeEntity getProdtypeByType() {
        return prodtypeByType;
    }

    public void setProdtypeByType(ProdTypeEntity prodtypeByType) {
        this.prodtypeByType = prodtypeByType;
    }

    @OneToMany(mappedBy = "productByProduct")
    public Collection<UserOrderEntity> getUserordersByIdproduct() {
        return userordersByIdproduct;
    }

    public void setUserordersByIdproduct(Collection<UserOrderEntity> userordersByIdproduct) {
        this.userordersByIdproduct = userordersByIdproduct;
    }
}
