package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ListaFuncionarioServlet", urlPatterns = {"/ListarFuncionario"})
public class ListaFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        String bairro = request.getParameter("bairro");

        String cidade = request.getParameter("cidade");

        String logradouro = request.getParameter("logradouro");

        String complemento = request.getParameter("complemento");

        String cargo = request.getParameter("cargo");

        String filial = request.getParameter("filial");

        String departamento = request.getParameter("departamento");

        String id = request.getParameter("id");

        Funcionario funcionario = new Funcionario(nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, complemento, celular, telefone, email, true, cargo, filial, departamento);

        funcionario.setId_func(Integer.parseInt(id));

        HttpSession sessao = request.getSession();
        sessao.setAttribute("funcionario", funcionario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditaFuncionario.jsp");
        dispatcher.forward(request, response);

    }

}
