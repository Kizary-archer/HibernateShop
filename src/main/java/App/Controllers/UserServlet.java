package App.Controllers;

import App.Entities.UserEntity;
import App.Entities.UserOrderViewEntity;
import App.Service.UserOrderService;
import App.Service.UserService;
import App.Util.HibernateSessionFactoryUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/authUser"})
public class UserServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        if (request.getServletPath().equals("/authUser")) {//авторизация
            RequestDispatcher requestDispatcher;
            try {
                UserEntity authUser = userService.authorization(request.getParameter("login"), request.getParameter("password"));
                if (authUser != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("authUser", authUser);
                    UserOrderService orderService = new UserOrderService();
                    List<UserOrderViewEntity> orderList = orderService.getUserOrderViewList((UserEntity) session.getAttribute("authUser"));
                    request.setAttribute("UserOrders", orderList);
                    requestDispatcher = request.getRequestDispatcher("./view/listUserOrder.jsp");
                } else {
                    request.setAttribute("userIsAuth", "false");
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                }
                requestDispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


