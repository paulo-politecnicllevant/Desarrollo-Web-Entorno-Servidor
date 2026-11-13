package org.example.jdbcdao.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jdbcdao.dao.TallerDao;
import org.example.jdbcdao.dao.TallerDaoMemoryImpl;
import org.example.jdbcdao.model.Taller;

import java.io.IOException;
import java.util.List;

@WebServlet("/tallers")
public class TallersServlet extends HttpServlet {

    private TallerDao modelTaller;

    @Override
    public void init(ServletConfig config) throws ServletException {
        modelTaller = new TallerDaoMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Taller> tallers = modelTaller.getAll();

        System.out.println("TALLERS: " + tallers);

        req.setAttribute("tallers", tallers);

        req.getRequestDispatcher("/WEB-INF/tallers.jsp").forward(req, resp);
    }
}
