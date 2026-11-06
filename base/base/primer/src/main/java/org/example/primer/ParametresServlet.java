package org.example.primer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ParametresServlet extends HttpServlet {

    private List<Inscripcio> alumnes = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        alumnes.add(new Inscripcio("Paulo", 20, "Grau mitja"));
        alumnes.add(new Inscripcio("Mateu", 20, "Grau mitja"));
        alumnes.add(new Inscripcio("Inti", 20, "Grau mitja"));
        alumnes.add(new Inscripcio("Toni", 20, "Grau mitja"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        String parametre = req.getParameter("nom");

        try{
            int index = Integer.parseInt(parametre);
            writer.println("<h2>" + alumnes.get(index) + "</h2>");
        }catch (NumberFormatException | IndexOutOfBoundsException e){
            writer.println("<p>" + "No se ha encontrado el alumno" + "</p>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("nom");

        String studis = switch ()
        //Guardar el valor del formulario
        resp.sendRedirect("parametres");
    }
}
