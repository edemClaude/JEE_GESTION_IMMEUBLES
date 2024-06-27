package dev.sn.gestionimmeubles.web;

import dev.sn.gestionimmeubles.dao.IUserDao;
import dev.sn.gestionimmeubles.dao.ImmeubleImpl;
import dev.sn.gestionimmeubles.dao.UserImplDao;
import dev.sn.gestionimmeubles.entities.Immeuble;
import dev.sn.gestionimmeubles.entities.Owner;
import dev.sn.gestionimmeubles.entities.Person;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ImmeubleServlet", urlPatterns = "/immeubles")
public class ImmeubleServlet extends HttpServlet {

    private ImmeubleImpl iImmeuble;
    @Override
    public void init(ServletConfig config) throws ServletException {
       iImmeuble = new ImmeubleImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "list";
        }

        switch (action){
            case "add":
                redirectToAddForm(req, resp);
                break;
            case "store":
                storeImmeuble(req, resp);
                break;
            case "list":
                List<Immeuble> immeubles = iImmeuble.getAllImmeubleByMC("%%");
                req.setAttribute("immeubles", immeubles);
                req.getRequestDispatcher("pages/immeubles/list.jsp").forward(req, resp);
                break;
            case "delete":
                deleteImmeuble(req, resp);
                break;
            default:
                displayImmeublesList(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    private void redirectToAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserDao iUser = new UserImplDao();
        List<Person> owners = iUser.getUsersByRole("Owner");
        for (Person p: owners) {
            System.out.println(p);
        }
        req.setAttribute("owners", owners);
        req.getRequestDispatcher("pages/immeubles/add.jsp").forward(req, resp);
    }

    private void storeImmeuble(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserDao iUser = new UserImplDao();
        Person owner = iUser.getUserById(Integer.parseInt(req.getParameter("owner_id")));
        Immeuble immeuble = new Immeuble();
        immeuble.setName(req.getParameter("name"));
        immeuble.setCity(req.getParameter("city"));
        immeuble.setOwner((Owner) owner);
        immeuble.setAddress(req.getParameter("address"));
        immeuble.setEquipments(req.getParameter("equipments"));
        immeuble.setDescription(req.getParameter("description"));

        if (iImmeuble.addImmeuble(immeuble)) {
            req.setAttribute("immeubles", iImmeuble.getAllImmeubleByMC("%%"));
            req.getRequestDispatcher("pages/immeubles/list.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Non Enregistrer");
            redirectToAddForm(req, resp);
        }
    }

    private void displayImmeublesList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Immeuble> immeubles = iImmeuble.getAllImmeubleByMC("%%");
            req.setAttribute("immeubles", immeubles);
            req.getRequestDispatcher("pages/immeubles/list.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteImmeuble(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            if (iImmeuble.deleteImmeuble(Integer.parseInt(req.getParameter("id")))){
                displayImmeublesList(req, resp);
            } else
            {
                req.setAttribute("error", "Erreur de suppression");
                displayImmeublesList(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
