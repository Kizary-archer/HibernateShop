package App.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "manufacture", schema = "public", catalog = "Shop")
public class ManufactureEntity {
    private Integer idmanuf;
    private String namemanuf;
    private Collection<ProductEntity> productsByIdmanuf;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmanuf", nullable = false)
    public Integer getIdmanuf() {
        return idmanuf;
    }

    public void setIdmanuf(Integer idmanuf) {
        this.idmanuf = idmanuf;
    }

    @Basic
    @Column(name = "namemanuf", nullable = false, length = 50)
    public String getNamemanuf() {
        return namemanuf;
    }

    public void setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufactureEntity that = (ManufactureEntity) o;
        return Objects.equals(idmanuf, that.idmanuf) &&
                Objects.equals(namemanuf, that.namemanuf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmanuf, namemanuf);
    }

    @OneToMany(mappedBy = "manufactureByManufacture")
    public Collection<ProductEntity> getProductsByIdmanuf() {
        return productsByIdmanuf;
    }

    public void setProductsByIdmanuf(Collection<ProductEntity> productsByIdmanuf) {
        this.productsByIdmanuf = productsByIdmanuf;
    }
}
