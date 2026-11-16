package org.example.jdbcdao.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jdbcdao.model.Taller;
import org.example.jdbcdao.model.TallerModel;

import java.io.IOException;
import java.util.List;

@WebServlet("/tallers")
public class TallersServlet extends HttpServlet {

    TallerModel tallerModel;

    @Override
    public void init(ServletConfig config) throws ServletException {
        tallerModel = TallerModel.instancia();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Taller> tallers = tallerModel.tallers();

        System.out.println("TALLERS: " + tallers);

        req.setAttribute("tallers", tallers);

        req.getRequestDispatcher("/WEB-INF/tallers.jsp").forward(req, resp);
    }
}
