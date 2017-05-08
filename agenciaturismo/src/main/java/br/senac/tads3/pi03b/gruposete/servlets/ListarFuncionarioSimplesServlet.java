package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioSimplaoDAO;
import br.senac.tads3.pi03b.gruposete.models.FuncionarioSimplao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarFuncionarioSimplesServlet", urlPatterns = {"/todos-funcionarios"})
public class ListarFuncionarioSimplesServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FuncionarioSimplaoDAO fsDAO = new FuncionarioSimplaoDAO();
        ArrayList<FuncionarioSimplao> lista = fsDAO.listar();
        request.setAttribute("listaFuncionarios", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Listar/ListaFuncionarioSimples.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
