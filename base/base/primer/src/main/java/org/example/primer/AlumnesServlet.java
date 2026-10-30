package org.example.primer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/alumnes")
public class AlumnesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter contingut = resp.getWriter();

        contingut.println("Això serà una llista d'alumnes:");
        contingut.println("que pasa bro");

        resp.setContentType("text/html");
        resp.getWriter();
        resp.setStatus(400);
        resp.sendError(404, "...");
        resp.sendRedirect("...");
        resp.setHeader("...", "...");
    }
}
