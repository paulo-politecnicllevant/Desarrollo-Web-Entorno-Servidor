package org.example.jdbcdao.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.jdbcdao.model.Taller;
import org.example.jdbcdao.model.TallerModel;

import java.io.IOException;
import java.util.List;

@WebServlet("/tallers")
public class TallersServlet extends HttpServlet {

    private TallerModel tallerModel;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        tallerModel = TallerModel.instancia();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Taller> tallers = tallerModel.tallers();
        req.setAttribute("tallers", tallers);

        HttpSession sessio = req.getSession(false);
        String usuari = (sessio == null) ? null : (String) sessio.getAttribute("usuari");
        req.setAttribute("usuari", usuari);

        req.getRequestDispatcher("/WEB-INF/tallers.jsp").forward(req, resp);
    }
}