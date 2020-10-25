package App.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "prodtype", schema = "public", catalog = "Shop")
public class ProdTypeEntity {
    private Integer idtype;
    private String typename;
    private Collection<ProductEntity> productsByIdtype;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtype", nullable = false)
    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    @Basic
    @Column(name = "typename", nullable = false, length = 50)
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdTypeEntity that = (ProdTypeEntity) o;
        return Objects.equals(idtype, that.idtype) &&
                Objects.equals(typename, that.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtype, typename);
    }

    @OneToMany(mappedBy = "prodtypeByType")
    public Collection<ProductEntity> getProductsByIdtype() {
        return productsByIdtype;
    }

    public void setProductsByIdtype(Collection<ProductEntity> productsByIdtype) {
        this.productsByIdtype = productsByIdtype;
    }
}
