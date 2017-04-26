package br.senac.tads3.pi03b.gruposete.cruds;

import br.senac.tads3.pi03b.gruposete.models.Contato;
import br.senac.tads3.pi03b.gruposete.models.Endereco;
import br.senac.tads3.pi03b.gruposete.models.Voo;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Voo", urlPatterns = {"/voo"})
public class VooCRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("voo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        String dataIda = request.getParameter("dataIda");
        String dataVolta = request.getParameter("dataVolta");
        int quantidadeP = Integer.parseInt(request.getParameter("quantidade"));

        Voo v = new Voo(dataIda, dataVolta, destino, origem, quantidadeP);

        HttpSession sessao = request.getSession();
        //sessao.setAttribute("", );
        // Colocar pag de resposta
        response.sendRedirect("index.html");
        
    }
    
}
