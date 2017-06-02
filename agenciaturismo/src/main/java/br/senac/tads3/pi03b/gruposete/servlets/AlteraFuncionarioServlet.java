package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
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

@WebServlet(name = "AlteraFuncionarioServlet", urlPatterns = {"/EditarFuncionario"})
public class AlteraFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("id");
        FuncionarioDAO dao = new FuncionarioDAO();
        String action = request.getParameter("action");
        if ("edit".equalsIgnoreCase(action)) {
            try {
                Funcionario funcionarios = dao.getFuncionarioByCPF(cpf);
                request.setAttribute("funcionarios", funcionarios);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlteraFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FuncionarioDAO dao = new FuncionarioDAO();
        boolean erro = false, verifica = false;

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String data_nasc = request.getParameter("nascimento");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String complemento = request.getParameter("complemento");
        String cargo = request.getParameter("cargo");
        String filial = request.getParameter("filial");
        String departamento = request.getParameter("departamento");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String acesso = request.getParameter("acesso");

//        if (nome == null || nome.length() < 1) {
//            erro = true;
//            request.setAttribute("erroNome", true);
//        }
//
//        if (numero <= 0) {
//            erro = true;
//            request.setAttribute("erroNumero", true);
//        }
//
//        if (rua == null || rua.length() < 1) {
//            erro = true;
//            request.setAttribute("erroRua", true);
//        }
//
//        if (estado == null || estado.length() < 1) {
//            erro = true;
//            request.setAttribute("erroEstado", true);
//        }
//
//        if (cidade == null || cidade.length() < 1) {
//            erro = true;
//            request.setAttribute("erroCidade", true);
//        }
//
//        if (complemento == null || complemento.length() < 1) {
//            erro = true;
//            request.setAttribute("erroComplemento", true);
//        }
//
//        if (cargo == null || cargo.length() < 1) {
//            erro = true;
//            request.setAttribute("erroCargo", true);
//        }
//
//        if (filial == null || filial.length() < 1) {
//            erro = true;
//            request.setAttribute("erroFilial", true);
//        }
//
//        if (departamento == null || departamento.length() < 1) {
//            erro = true;
//            request.setAttribute("erroDepartamento", true);
//        }
//
//        if (telefone == null || !"(  )    -    ".equals(telefone)) {
//            erro = true;
//            request.setAttribute("erroTelefone", true);
//        }
//
//        if (celular == null || !"(  )     -    ".equals(celular)) {
//            erro = true;
//            request.setAttribute("erroCelular", true);
//        }
//
//        if (email == null || !email.contains("@") && !email.contains(".com") || !email.contains(".com.br")) {
//            erro = true;
//            request.setAttribute("erroEmail", true);
//        }
//        
//        try {
//            verifica = dao.verificarCPF(cpf);
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(AlteraFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (cpf == null || !"   .   .   -  ".equals(cpf)) {
//            erro = true;
//            request.setAttribute("erroCpf", true);
//        }
//
//        if (cep == null || !"     -   ".equals(cep)) {
//            erro = true;
//            request.setAttribute("erroCep", true);
//        }

        if (erro == false) {
            Funcionario func = new Funcionario(nome, cpf, sexo, data_nasc,
                    numero, cep, rua, estado, cidade, complemento,
                    celular, telefone, email, true, cargo, filial, departamento, login, senha, acesso);
            try {
                dao.alterar(func);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Layout/index.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AlteraFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Editar/EditarFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
