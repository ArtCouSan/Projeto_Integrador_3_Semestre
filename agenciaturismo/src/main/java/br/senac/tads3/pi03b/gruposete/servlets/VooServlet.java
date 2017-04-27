package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Voo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Voo", urlPatterns = {"/voo"})
public class VooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("voo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        String data_ida = request.getParameter("dataIda");
        String data_volta = request.getParameter("dataVolta");
        int quantidade_passagens = Integer.parseInt(request.getParameter("quantidade"));

        Voo voo = new Voo(data_ida, data_volta, destino, origem, quantidade_passagens);

        HttpSession sessao = request.getSession();
        //sessao.setAttribute("", );
        // Colocar pag de resposta
        response.sendRedirect("index.html");
        
    }
    
}
