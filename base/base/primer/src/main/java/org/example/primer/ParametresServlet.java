package org.example.primer;

import jakarta.servlet.ServletConfig;
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

    private List<String> alumnes = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        alumnes.add("Paulo");
        alumnes.add("Mateu");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        String[] noms = req.getParameterValues("nom");

        writer.println("<ul>");
        for(String nom : noms){
            writer.println("<li>" + nom + "</li>");
        }
        writer.println("</ul>");

        writer.println("<h2>" + req.getParameter("nom") + "</h2>");
        writer.println("<h2>" + req.getParameter("edat") + "</h2>");

        String index = alumnes.get(1);
        if(index.isEmpty()){
            writer.println("<h1>" + "error" + "</h1>");
        }else{
            writer.println("<h1>" + index + "</h1>");
        }
    }
}
