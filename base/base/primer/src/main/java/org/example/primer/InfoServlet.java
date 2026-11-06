package org.example.primer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/inscripcions.jsp").forward(req, resp);
        //resp.setContentType("text/html;charset=UTF-8");
//
        //PrintWriter writer = resp.getWriter();
//
        //writer.println("<ul>");
        //writer.println("<li>" + req.getParameter("nom") + "</li>");
        //writer.println("<li>" + req.getMethod() + "</li>");
        //writer.println("<li>" + req.getRequestURI() + "</li>");
        //writer.println("<li>" + req.getRequestURL() + "</li>");
        //writer.println("<li>" + req.getContextPath() + "</li>");
        //writer.println("<li>" + req.getPathInfo() + "</li>");
        //writer.println("<li>" + req.getHeader("User-Agent") + "</li>");
        //writer.println("</ul>");
    }
}
