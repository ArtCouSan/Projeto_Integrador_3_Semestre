package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.HotelDAO;
import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.Hotel;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import br.senac.tads3.pi03b.gruposete.services.HotelService;
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarHotel.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HotelService service = new HotelService();
        HotelDAO dao = new HotelDAO();

        String nome_hotel = request.getParameter("nome_hotel");
        String data_entrada = request.getParameter("data_entrada");
        String data_saida = request.getParameter("data_saida");
        int quantidade_quartos = Integer.parseInt(request.getParameter("quantidade_quartos"));
        int quantidade_hospedes = Integer.parseInt(request.getParameter("quantidade_hospedes"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        int id = Integer.parseInt(request.getParameter("identificacao"));
        
        Hotel hotel = new Hotel(nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, true);
            hotel.setId_hotel(id);

        if (service.validaHotel(hotel)) {
            try {
                
                dao.alterar(hotel);
                RelatorioDAO relatorioDAO = new RelatorioDAO();
                RelatorioMudancas relatorio = new RelatorioMudancas();
                relatorio.setId_funcionario(1);
                relatorio.setMudanca("Alteração de hotel efetuado!");
                relatorioDAO.inserir(relatorio);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
                dispatcher.forward(request, response);
                
            } catch (Exception ex) {
                
                Logger.getLogger(AlteraHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
                
            }

        } else {
            
            request.setAttribute("erroNome_hotel", service.validaNome_hotel(nome_hotel));
            request.setAttribute("erroQuantidade_quartos", service.validaQuantidade_quartos(quantidade_quartos));
            request.setAttribute("erroQuantidade_hospedes", service.validaQuantidade_hospedes(quantidade_hospedes));
            request.setAttribute("erroPreco", service.validaPreco(preco));
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarHotel.jsp");
            dispatcher.forward(request, response);
            
        }
    }
}
