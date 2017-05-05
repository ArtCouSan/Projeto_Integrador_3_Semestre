package br.senac.tads3.pi03b.gruposete.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.senac.tads3.pi03b.gruposete.dao.FuncionarioSimplaoDAO;
import br.senac.tads3.pi03b.gruposete.models.FuncionarioSimplao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danimo
 */
@WebServlet(name = "CadastroFuncionarioSimplaoServlet", urlPatterns = {"/cadastro-funcionario-simplao"})
public class CadastroFuncionarioSimplaoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CadastroFuncionarioSimplao.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + nome);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + sobrenome);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + idade);
        
        FuncionarioSimplao funcHumildade = new FuncionarioSimplao(nome, sobrenome, idade);
        
        System.out.println("CRIOU>>>>>>>>>>>>>>>>>>>>>");
        
        FuncionarioSimplaoDAO fSDAO = new FuncionarioSimplaoDAO();
        
        fSDAO.inserir(funcHumildade);
        
        HttpSession sessao = request.getSession();
        
        sessao.setAttribute("novoFuncionario", funcHumildade);
        
        response.sendRedirect("index.html");
        
    }


}
