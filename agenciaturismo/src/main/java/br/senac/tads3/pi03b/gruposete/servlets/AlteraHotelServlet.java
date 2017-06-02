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

@WebServlet(name = "AlteraHotelServlet", urlPatterns = {"/EditarHotel"})
public class AlteraHotelServlet extends HttpServlet {

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
                Logger.getLogger(AlteraHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Editar/EditarHotel.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HotelDAO dao = new HotelDAO();
        boolean erro = false;

        String nome_hotel = request.getParameter("nome_hotel");
        String data_entrada = request.getParameter("data_entrada");
        String data_saida = request.getParameter("data_saida");
        int quantidade_quartos = Integer.parseInt(request.getParameter("quantidade_quartos"));
        int quantidade_hospedes = Integer.parseInt(request.getParameter("quantidade_hospedes"));
        float preco = Float.parseFloat(request.getParameter("preco"));

        if (nome_hotel == null || nome_hotel.length() < 1) {
            erro = true;
            request.setAttribute("erroNome_hotel", true);
        }

        if (data_entrada == null || !"  /  /    ".equals(data_entrada)) {
            erro = true;
            request.setAttribute("erroData_entrada", true);
        }

        if (data_saida == null || !"  /  /    ".equals(data_saida)) {
            erro = true;
            request.setAttribute("erroData_saida", true);
        }

        if (quantidade_quartos < 1) {
            erro = true;
            request.setAttribute("erroQuantidade_quartos", true);
        }

        if (quantidade_hospedes < 1) {
            erro = true;
            request.setAttribute("erroQuantidade_hospedes", true);
        }

        if (preco < 0) {
            erro = true;
            request.setAttribute("erroPreco", true);
        }

        int id = Integer.parseInt(request.getParameter("identificacao"));

        if (erro == false) {
            Hotel hotel = new Hotel(nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, true);
            hotel.setId_hotel(id);
            
            try {
                dao.alterar(hotel);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Layout/index.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AlteraHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Editar/EditarHotel.jsp");
            dispatcher.forward(request, response);
        }
    }
}
