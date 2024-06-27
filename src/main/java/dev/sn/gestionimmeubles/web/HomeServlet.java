package dev.sn.gestionimmeubles.web;

import dev.sn.gestionimmeubles.dao.IImmeuble;
import dev.sn.gestionimmeubles.dao.ImmeubleImpl;
import dev.sn.gestionimmeubles.entities.Immeuble;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name="HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(HomeServlet.class.getName());
    private IImmeuble iimmeuble;
    @Override
    public void init(ServletConfig config) throws ServletException {
        iimmeuble = new ImmeubleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var path = req.getServletPath();
        System.out.println(path);
        displayImmeublesList(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void displayImmeublesList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Immeuble> immeubles = iimmeuble.getAllImmeubleByMC(req.getParameter("search"));
            for (Immeuble i:
                 immeubles) {
                System.out.println(i);
            }
            req.setAttribute("immeubles", immeubles);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

}
