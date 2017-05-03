/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Contato;
import br.senac.tads3.pi03b.gruposete.models.Endereco;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.models.Pessoa;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "CadastroFuncionarioServlet", urlPatterns = {"/cadastro-funcionario"})
public class CadastroFuncionarioServlet extends HttpServlet {

    private FuncionarioDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CadastroFuncionario.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //        //Contato
//        String telefone = request.getParameter("telefone");
//        String celular = request.getParameter("celular");
//        String email = request.getParameter("email");
//        String dd_telefone = request.getParameter("dd_telefone");
//        String dd_celular = request.getParameter("dd_celular");
//
//
//        //Endereço
//        String rua = request.getParameter("rua");
//        int numero = Integer.parseInt(request.getParameter("numero"));
//        String complemento = request.getParameter("complemento");
//        String logradouro = request.getParameter("logradouro");
//        String cep = request.getParameter("cep");
//        String cidade = request.getParameter("cidade");
//        String bairro = request.getParameter("bairro");
//        
//        //Pessoa
//        String nome = request.getParameter("nome");
//        String cpf = request.getParameter("cpf");
//        char sexo = request.getParameter("sexo").charAt(0);
//        String nascimento = request.getParameter("nascimento");
//
//
//        //Funcionario
//        String departamento = request.getParameter("departamento");
//        String cargo = request.getParameter("cargo");
//        String filial = request.getParameter("filial");
//        
//        System.out.println(numero + "  " + numero + "  ");
//
//        
//        //Contato contato = new Contato(celular, telefone, email, dd_telefone, dd_celular);
//        Endereco endereco = new Endereco(numero, cep, rua, bairro, cidade, logradouro, complemento);
//        System.out.println(numero + "  " + numero + "  ");
//        Contato contato = new Contato(celular, telefone, email, dd_telefone, dd_celular);
//        Pessoa pessoa = new Pessoa(nome, cpf, sexo, nascimento, contato, endereco);
//        Funcionario funcionario = new Funcionario(cargo, departamento, true, filial, pessoa);
//
//        try {
//            
//            dao.inserir(funcionario);
//            HttpSession sessao = request.getSession();
//            sessao.setAttribute("novoFuncionario", funcionario);
//            response.sendRedirect("index.html");
//            
//        } catch (Exception ex) {
//            
//            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
//        
//        }
//
//        


        try{
        Connection con = DbUtil.getConnection();
            System.out.println(">>>>>>>>>>>>DEU CERTO");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(">>>>>>>>>>>>DEU RUIM");
        }
        
        
    }

}
