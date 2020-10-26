package App.Controllers;

import App.Entities.ProductViewEntity;
import App.Entities.UserEntity;
import App.Entities.UserOrderViewEntity;
import App.Service.ProductService;
import App.Service.UserOrderService;
import App.Util.HibernateSessionFactoryUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/addOrder", "/listUserOrder"})
public class OrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        UserOrderService orderService = new UserOrderService();
        if (request.getServletPath().equals("/addOrder")) {

            requestDispatcher = request.getRequestDispatcher("view/addAgent.jsp");
        }
        if (request.getServletPath().equals("/listUserOrder")) {
            HttpSession session = request.getSession();
            List<UserOrderViewEntity> orderList = orderService.getUserOrderViewList((UserEntity) session.getAttribute("authUser"));
            request.setAttribute("UserOrders", orderList);
            requestDispatcher = request.getRequestDispatcher("view/listUserOrder.jsp");
        }
        assert requestDispatcher != null;
        requestDispatcher.forward(request, response);
    }

}


