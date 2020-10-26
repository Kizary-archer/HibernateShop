package App.Controllers;

import App.Entities.UserEntity;
import App.Entities.UserOrderEntity;
import App.Entities.UserOrderViewEntity;
import App.Service.UserOrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/addOrder", "/listUserOrder","/delOrder"})
public class OrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        HttpSession session = request.getSession();
        UserOrderService orderService = new UserOrderService();
        if (request.getServletPath().equals("/addOrder")) {
            UserOrderEntity userOrderEntity = new UserOrderEntity();
            UserEntity userEntity = (UserEntity) session.getAttribute("authUser");
            userOrderEntity.setShuser(userEntity.getIduser());
            userOrderEntity.setProduct(Integer.parseInt(request.getParameter("idProduct")));
            userOrderEntity.setCount(1);
            orderService.addOrder(userOrderEntity);
        }
        if (request.getServletPath().equals("/delOrder")) {
            orderService.delOrder(Integer.parseInt(request.getParameter("idOrder")));
        }
            List<UserOrderViewEntity> orderList = orderService.getUserOrderViewList((UserEntity) session.getAttribute("authUser"));
            request.setAttribute("UserOrders", orderList);
            requestDispatcher = request.getRequestDispatcher("view/listUserOrder.jsp");

        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }
}


