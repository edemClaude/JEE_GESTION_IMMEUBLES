package dev.sn.gestionimmeubles.web;

import dev.sn.gestionimmeubles.dao.ContratImpl;
import dev.sn.gestionimmeubles.dao.IContratLocation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contrat")
public class ContratServlet extends HttpServlet {
    private IContratLocation dao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = new ContratImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/contrats/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
