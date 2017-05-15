package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.HotelDAO;
import br.senac.tads3.pi03b.gruposete.models.Hotel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/EditaHotelServlet")
public class EditaHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HotelDAO dao = new HotelDAO();

        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {

            try {

                Hotel hoteis = dao.getHotelById(id);

                request.setAttribute("hoteis", hoteis);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(EditaHotelServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarHotel.jsp");
            dispatcher.forward(request, response);

        }
    }

}
