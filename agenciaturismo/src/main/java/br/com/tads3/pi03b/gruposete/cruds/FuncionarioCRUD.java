package br.com.tads3.pi03b.gruposete.cruds;

import br.senac.tads3.pi03b.gruposete.models.Contato;
import br.senac.tads3.pi03b.gruposete.models.Endereco;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FuncionarioCRUD", urlPatterns = {"/funcionario"})
public class FuncionarioCRUD extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("funcionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        char sexo = request.getParameter("sexo").charAt(0);
        String nascimento = request.getParameter("nascimento");
        String rua = request.getParameter("rua");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String complemento = request.getParameter("complemento");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String departamento = request.getParameter("departamento");
        String cargo = request.getParameter("cargo");
        String filial = request.getParameter("filial");

        Contato contato = new Contato(celular, telefone, email, telefone.substring(0, 1), celular.substring(0, 1));
        Endereco endereco = new Endereco(numero, cep, rua, cargo, estado, complemento);
        
        // Pessoa e retorno dos ids contato e endereco
        
        
        HttpSession sessao = request.getSession();
        //sessao.setAttribute("", Pessoa);
        // Colocar pag de resposta
        response.sendRedirect("index.html");
        
    }

}
