package App.Service;

import App.DAO.IDAO.ProductDAO;
import App.DAO.ProductDAOImpl;
import App.Entities.ProductViewEntity;

import java.util.List;

public class ProductService {
    ProductDAO productDAO = new ProductDAOImpl();
    public List<ProductViewEntity>ProductList(){
        return productDAO.getProductViewList();
    }
}
