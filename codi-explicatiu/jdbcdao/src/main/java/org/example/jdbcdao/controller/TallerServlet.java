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

/** Detall d'un taller. El doPost s'ha mogut a NouTallerServlet. */
@WebServlet("/taller")
public class TallerServlet extends HttpServlet {

    private TallerModel tallerModel;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        tallerModel = TallerModel.instancia();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id == null || id.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Has de introducir una ID");
            return;
        }

        Taller taller = tallerModel.taller(id);

        if (taller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "No hay talleres con esa ID");
            return;
        }

        req.setAttribute("taller", taller);

        req.getRequestDispatcher("/WEB-INF/taller.jsp").forward(req, resp);
    }
}
