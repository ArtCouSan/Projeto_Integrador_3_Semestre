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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastroHotelServlet", urlPatterns = {"/CadastroHotel"})
public class CadastroHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CadastroHotel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HotelService service = new HotelService();
        HotelDAO dao = new HotelDAO();

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        RelatorioMudancas relatorio = new RelatorioMudancas();

        String nome_hotel = request.getParameter("nome_hotel");
        String data_entrada = request.getParameter("data_entrada");
        String data_saida = request.getParameter("data_saida");
        int quantidade_quartos = Integer.parseInt(request.getParameter("quantidade_quartos"));
        int quantidade_hospedes = Integer.parseInt(request.getParameter("quantidade_hospedes"));
        float preco = Float.parseFloat(request.getParameter("preco"));

        request.setAttribute("erroNome_hotel", service.validaNome(nome_hotel));
        request.setAttribute("erroData_entrada", service.validaEntrada(data_entrada));
        request.setAttribute("erroData_saida", service.validaSaida(data_saida));
        request.setAttribute("erroQuantidade_quartos", service.validaQuantidade_quartos(quantidade_quartos));
        request.setAttribute("erroQuantidade_hospedes", service.validaQuantidade_hospedes(quantidade_hospedes));
        request.setAttribute("erroPreco", service.validaPreco(preco));

        Hotel hotel = new Hotel(nome_hotel, data_entrada, data_saida,
                quantidade_quartos, quantidade_hospedes, preco, true);

        if (service.validaHotel(nome_hotel, quantidade_quartos, data_entrada, data_saida, quantidade_hospedes, preco)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CadastroHotel.jsp");
            dispatcher.forward(request, response);
        } else {
            try {

                dao.inserir(hotel);
                HttpSession sessao = request.getSession();
                int identificacaoF = (int) sessao.getAttribute("id_func");
                relatorio.setId_func(identificacaoF);
                relatorio.setMudanca("Cadastro de hotel efetuado!");
                relatorioDAO.inserir(relatorio);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
                dispatcher.forward(request, response);

            } catch (Exception ex) {

                Logger.getLogger(CadastroHotelServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
