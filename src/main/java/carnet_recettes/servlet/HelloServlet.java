package carnet_recettes.servlet;

import java.io.*;
import java.util.List;

import carnet_recettes.bll.RecetteManager;
import carnet_recettes.bo.Recette;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        System.out.println("HelloServlet DoGet");
        int idMet=4;

        List<Recette> recetteTest= RecetteManager.getInstance().selectRecettesByMet(idMet);
        System.out.println(recetteTest);
        request.setAttribute("RecetteTest", recetteTest);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPost(req, resp);
    }

    public void destroy() {
    }
}