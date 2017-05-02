<<<<<<< HEAD:agenciaturismo/src/main/java/br/senac/tads3/pi03b/gruposete/servlets/FuncionarioServlet.java
package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Contato;
import br.senac.tads3.pi03b.gruposete.models.Endereco;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.models.Pessoa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "funcionario", urlPatterns = {"/funcionario"})
public class FuncionarioServlet extends HttpServlet {
    
    private FuncionarioDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("funcionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean erro = false;

        //Contato
        String telefone = request.getParameter("telefone");
        if (telefone == null || !"     -    ".equals(telefone)) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        }
        String celular = request.getParameter("celular");
        if (celular == null || !"     -    ".equals(celular)) {
            erro = true;
            request.setAttribute("erroCelular", true);
        }
        String email = request.getParameter("email");
        if (email == null || !email.contains("@") && !email.contains(".com") || !email.contains(".com.br")) {
            erro = true;
            request.setAttribute("erroEmail", true);
        }
        String dd_telefone = request.getParameter("dd_telefone");
        if (dd_telefone == null || !"(  )".equals(dd_telefone)) {
            erro = true;
            request.setAttribute("erroDd_telefone", true);
        }
        String dd_celular = request.getParameter("dd_celular");
        if (dd_celular == null || !"(  )".equals(dd_celular)) {
            erro = true;
            request.setAttribute("erroDd_celular", true);
        }

        //Endereço
        String rua = request.getParameter("rua");
        if (rua == null || rua.length() < 1) {
            erro = true;
            request.setAttribute("erroRua", true);
        }
        int numero = Integer.parseInt(request.getParameter("numero"));
        if (numero <= 0) {
            erro = true;
            request.setAttribute("erroNumero", true);
        }
        String complemento = request.getParameter("complemento");
        if (complemento == null || complemento.length() < 1) {
            erro = true;
            request.setAttribute("erroComplemento", true);
        }
        String logradouro = request.getParameter("logradouro");
        if (logradouro == null || logradouro.length() < 1) {
            erro = true;
            request.setAttribute("erroLogradouro", true);
        }
        String cep = request.getParameter("cep");
        if (cep == null || !"     -   ".equals(cep)) {
            erro = true;
            request.setAttribute("erroCep", true);
        }
        String cidade = request.getParameter("cidade");
        if (cidade == null || cidade.length() < 1) {
            erro = true;
            request.setAttribute("erroCidade", true);
        }
        String bairro = request.getParameter("bairro");
        if (bairro == null || bairro.length() < 1) {
            erro = true;
            request.setAttribute("erroBairro", true);
        }

        //Pessoa
        String nome = request.getParameter("nome");
        if (nome == null || nome.length() < 1) {
            erro = true;
            request.setAttribute("erroNome", true);
        }
        String cpf = request.getParameter("cpf");
        if (cpf == null || !"   .   .   -  ".equals(cpf)) {
            erro = true;
            request.setAttribute("erroCpf", true);
        }
        char sexo = request.getParameter("sexo").charAt(0);
        if ("".equals(sexo)) {
            erro = true;
            request.setAttribute("erroSexo", true);
        }
        String nascimento = request.getParameter("nascimento");
        if (nascimento == null || !"  /  /    ".equals(nascimento)) {
            erro = true;
            request.setAttribute("erroNascimento", true);
        }

        //Funcionario
        String departamento = request.getParameter("departamento");
        if (departamento == null || departamento.length() < 1) {
            erro = true;
            request.setAttribute("erroDepartamento", true);
        }
        String cargo = request.getParameter("cargo");
        if (cargo == null || cargo.length() < 1) {
            erro = true;
            request.setAttribute("erroCargo", true);
        }
        String filial = request.getParameter("filial");
        if (filial == null || filial.length() < 1) {
            erro = true;
            request.setAttribute("erroFilial", true);
        }

        if (!erro) {
            Contato contato = new Contato(celular, telefone, email, dd_telefone, dd_celular);
            Endereco endereco = new Endereco(numero, cep, rua, bairro, cidade, logradouro, complemento);
            Pessoa pessoa = new Pessoa(nome, cpf, sexo, nascimento, contato, endereco);
            Funcionario funcionario = new Funcionario(cargo, departamento, true, filial, pessoa);

            try {
                dao.inserir(funcionario);
            } catch (Exception ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession sessao = request.getSession();
            sessao.setAttribute("novoFuncionario", funcionario);
            response.sendRedirect("resultado.jsp");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("entrada.jsp");
            dispatcher.forward(request, response);
        }
    }
}
=======
package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Contato;
import br.senac.tads3.pi03b.gruposete.models.Endereco;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.models.Pessoa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastroFuncionarioServlet", urlPatterns = {"/cadastro-funcionario"})
public class CadastroFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CadastroFuncionario.jsp");
        dispatcher.forward(request, response);
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean erro = false;

        //Contato
        String telefone = request.getParameter("telefone");
        if (telefone == null || !"     -    ".equals(telefone)) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        }
        String celular = request.getParameter("celular");
        if (celular == null || !"     -    ".equals(celular)) {
            erro = true;
            request.setAttribute("erroCelular", true);
        }
        String email = request.getParameter("email");
        if (email == null || !email.contains("@") && !email.contains(".com") || !email.contains(".com.br")) {
            erro = true;
            request.setAttribute("erroEmail", true);
        }
        String dd_telefone = request.getParameter("dd_telefone");
        if (dd_telefone == null || !"(  )".equals(dd_telefone)) {
            erro = true;
            request.setAttribute("erroDd_telefone", true);
        }
        String dd_celular = request.getParameter("dd_celular");
        if (dd_celular == null || !"(  )".equals(dd_celular)) {
            erro = true;
            request.setAttribute("erroDd_celular", true);
        }

        //Endereço
        String rua = request.getParameter("rua");
        if (rua == null || rua.length() < 1) {
            erro = true;
            request.setAttribute("erroRua", true);
        }
        int numero = Integer.parseInt(request.getParameter("numero"));
        if (numero <= 0) {
            erro = true;
            request.setAttribute("erroNumero", true);
        }
        String complemento = request.getParameter("complemento");
        if (complemento == null || complemento.length() < 1) {
            erro = true;
            request.setAttribute("erroComplemento", true);
        }
        String logradouro = request.getParameter("logradouro");
        if (logradouro == null || logradouro.length() < 1) {
            erro = true;
            request.setAttribute("erroLogradouro", true);
        }
        String cep = request.getParameter("cep");
        if (cep == null || !"     -   ".equals(cep)) {
            erro = true;
            request.setAttribute("erroCep", true);
        }
        String cidade = request.getParameter("cidade");
        if (cidade == null || cidade.length() < 1) {
            erro = true;
            request.setAttribute("erroCidade", true);
        }
        String bairro = request.getParameter("bairro");
        if (bairro == null || bairro.length() < 1) {
            erro = true;
            request.setAttribute("erroBairro", true);
        }

        //Pessoa
        String nome = request.getParameter("nome");
        if (nome == null || nome.length() < 1) {
            erro = true;
            request.setAttribute("erroNome", true);
        }
        String cpf = request.getParameter("cpf");
        if (cpf == null || !"   .   .   -  ".equals(cpf)) {
            erro = true;
            request.setAttribute("erroCpf", true);
        }
        char sexo = request.getParameter("sexo").charAt(0);
        if ("".equals(sexo)) {
            erro = true;
            request.setAttribute("erroSexo", true);
        }
        String nascimento = request.getParameter("nascimento");
        if (nascimento == null || !"  /  /    ".equals(nascimento)) {
            erro = true;
            request.setAttribute("erroNascimento", true);
        }

        //Funcionario
        String departamento = request.getParameter("departamento");
        if (departamento == null || departamento.length() < 1) {
            erro = true;
            request.setAttribute("erroDepartamento", true);
        }
        String cargo = request.getParameter("cargo");
        if (cargo == null || cargo.length() < 1) {
            erro = true;
            request.setAttribute("erroCargo", true);
        }
        String filial = request.getParameter("filial");
        if (filial == null || filial.length() < 1) {
            erro = true;
            request.setAttribute("erroFilial", true);
        }

        if (!erro) {
            Contato contato = new Contato(celular, telefone, email, dd_telefone, dd_celular);
            Endereco endereco = new Endereco(numero, cep, rua, bairro, cidade, logradouro, complemento);
            Pessoa pessoa = new Pessoa(nome, cpf, sexo, nascimento, contato, endereco);
            Funcionario funcionario = new Funcionario(cargo, departamento, true, filial, pessoa);

            try {
                FuncionarioDAO.inserir(funcionario);
            } catch (Exception ex) {
                Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession sessao = request.getSession();
            sessao.setAttribute("novoFuncionario", funcionario);
            response.sendRedirect("resultado.jsp");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("entrada.jsp");
            dispatcher.forward(request, response);
        }
    }
}
>>>>>>> origin/master:agenciaturismo/src/main/java/br/senac/tads3/pi03b/gruposete/servlets/CadastroFuncionarioServlet.java
