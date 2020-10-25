package App.DAO.IDAO;

import App.Entities.ManufactureEntity;
import App.Entities.ProdTypeEntity;
import App.Entities.ProductEntity;
import App.Entities.ProductViewEntity;

import java.util.List;

public interface ProductDAO extends IDAO<ProductEntity> {

    List<ProductViewEntity> getProductViewList();

}
