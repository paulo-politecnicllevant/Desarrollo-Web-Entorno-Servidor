
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
                    "Debes indicar el identificador del taller.");
            return;
        }

        Taller taller = tallerModel.taller(id);

        if (taller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "No se ha encontrado ningún taller con ese ID.");
            return;
        }

        req.setAttribute("taller", taller);

        req.getRequestDispatcher("/WEB-INF/taller.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Taller nou = new Taller();
        nou.setId(req.getParameter("id"));
        nou.setNom(req.getParameter("nom"));
        nou.setPonent(req.getParameter("ponent"));
        nou.setDia(parseDia(req.getParameter("dia")));
        nou.setPlaces(parsePlaces(req.getParameter("places")));
        nou.setPreu(parsePreu(req.getParameter("preu")));

        List<String> errors = tallerModel.crea(nou);

        if (errors.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/tallers");
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("nou", nou);
            req.setAttribute("tallers", tallerModel.tallers());
            req.getRequestDispatcher("/WEB-INF/tallers.jsp").forward(req, resp);
        }
    }

    //Convierto los parámetros del formulario (Strings) a valores necesarios para el Taller
    private LocalDate parseDia(String text) {
        return LocalDate.parse(text);
    }

    private Integer parsePlaces(String text) {
        return Integer.valueOf(text.trim());
    }

    private BigDecimal parsePreu(String text) {
        return new BigDecimal(text.trim().replace(',', '.'));
    }
}