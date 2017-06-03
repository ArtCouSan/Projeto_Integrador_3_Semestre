package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;
import br.senac.tads3.pi03b.gruposete.services.VooService;
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

@WebServlet(name = "AlteraVooServlet", urlPatterns = {"/EditarVoo"})
public class AlteraVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        VooDAO dao = new VooDAO();
        String action = request.getParameter("action");
        if ("edit".equalsIgnoreCase(action)) {
            try {
                Voo voos = dao.getVooById(id);
                request.setAttribute("voos", voos);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlteraVooServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarVoo.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VooService service = new VooService();
        VooDAO dao = new VooDAO();

        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        String data_ida = request.getParameter("data_ida");
        String data_volta = request.getParameter("data_volta");
        int quantidade_passagens = Integer.parseInt(request.getParameter("quantidade_passagens"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        int id = Integer.parseInt(request.getParameter("identificacao"));

        Voo voo = new Voo(data_ida, data_volta, destino, origem, 
                quantidade_passagens, preco, true);
        voo.setId_voo(id);

        if (service.validaVoo(voo)) {
            try {
                dao.alterar(voo);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AlteraVooServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            request.setAttribute("erroOrigem", service.validaOrigem(origem));
            request.setAttribute("erroDestino", service.validaDestino(destino));
            request.setAttribute("erroQuantidade_passagens", service.validaQuantidade_passagens(quantidade_passagens));
            request.setAttribute("erroPreco", service.validaPreco(preco));
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarVoo.jsp");
            dispatcher.forward(request, response);
        }
    }
}
