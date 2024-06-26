package dev.sn.gestionimmeubles.web;

import dev.sn.gestionimmeubles.dao.IRegistration;
import dev.sn.gestionimmeubles.dao.RegistrationImpl;
import dev.sn.gestionimmeubles.entities.Lodger;
import dev.sn.gestionimmeubles.entities.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"*.do"})
public class LoginServlet extends HttpServlet {

    private IRegistration iregistration;

    @Override
    public void init(ServletConfig config) throws ServletException {
        iregistration = new RegistrationImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String action = req.getServletPath();
        System.out.println(action);

        if (action.equalsIgnoreCase("/login.do")) {
            this.login(req, resp);
        } else if (action.equals("/register.do")) {
            this.register(req, resp);
        } else if (action.equals("/logout.do")) {
            this.logout(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (iregistration.login(username, password)) {
            req.getSession().setAttribute("username", username);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("confirm_password").equals(req.getParameter("password"))) {

            User user = new User();
            user.setUsername(req.getParameter("username"));
            user.setPassword(req.getParameter("password"));
            user.setAddress(req.getParameter("address"));
            user.setPhoneNumber(req.getParameter("phone_number"));
            user.setFirstName(req.getParameter("first_name"));
            user.setLastName(req.getParameter("last_name"));

            if (iregistration.register(user)) {
                req.getSession().setAttribute("username", user.getUsername());
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Passwords do not match");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }


}
