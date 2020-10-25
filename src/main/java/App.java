import App.DAO.IDAO.ProductDAO;
import App.Service.ProductService;
import App.Service.UserOrderService;
import App.Service.UserService;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        productService.ProductList().forEach(System.out::println);
        UserOrderService orderService = new UserOrderService();
        orderService.getManufactureList().forEach(System.out::println);
        orderService.getProdTypeList().forEach(System.out::println);
        orderService.getUserOrderViewList(userService.authorization("alice","s")).forEach(System.out::println);
    }
}
