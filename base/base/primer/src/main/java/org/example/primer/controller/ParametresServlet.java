package org.example.primer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.primer.model.Inscripcio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParametresServlet extends HttpServlet {

    private List<Inscripcio> inscripcions = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        inscripcions.add(new Inscripcio("Paulo", 20, "Grau mitjà"));
        inscripcions.add(new Inscripcio("Mateu", 20, "Grau mitjà"));
        inscripcions.add(new Inscripcio("Inti", 20, "Grau mitjà"));
        inscripcions.add(new Inscripcio("Toni", 20, "Grau mitjà"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("inscripcions", inscripcions);
        req.getRequestDispatcher("/WEB-INF/inscripcions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req);
        req.setCharacterEncoding("UTF-8");

        String nom = req.getParameter("nom");

        String estudis = switch (String.valueOf(req.getParameter("estudis"))){
            case "grau-mitja" -> "Grau mitjà";
            case "grau-superior" -> "Grau Superior";
            case "curs-especialitzacio" -> "Curs Especialització";
            default -> null;
        };

        try{
            int edat = Integer.parseInt(req.getParameter("edat"));
            if(nom != null && !nom.isBlank() && estudis != null){
                inscripcions.add(new Inscripcio(nom, edat, estudis));
            }
        }catch (NumberFormatException | IndexOutOfBoundsException e){
            req.setAttribute("error", "No se ha encontrado el alumno");
            req.getRequestDispatcher("/WEB-INF/inscripcions.jsp").forward(req, resp);
            return;
        }

        //Guardar el valor del formulario
        resp.sendRedirect(req.getContextPath() + "/parametres");
    }
}
