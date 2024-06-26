package dev.sn.gestionimmeubles.web;

import dev.sn.gestionimmeubles.dao.ImmeubleImpl;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="ImmeubleServlet", urlPatterns = "/immeubles")
public class ImmeubleServlet extends HttpServlet {

    private ImmeubleImpl metier;
    @Override
    public void init(ServletConfig config) throws ServletException {
       metier = new ImmeubleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        req.setAttribute("immeubles", metier.getAllImmeuble());
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
