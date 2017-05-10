package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscaFuncionarioServlet", urlPatterns = {"/BuscaFuncionario"})
public class BuscaFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Buscar/BuscaFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean erro = false;

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

        if (!erro) {
            Funcionario funcHumilde = new Funcionario(nome, cpf, sexo, data_nasc,
                    numero, cep, rua, bairro, cidade, logradouro, complemento,
                    celular, telefone, email, true, cargo, filial, departamento);
            try {
                FuncionarioDAO dao = new FuncionarioDAO();
                //dao.
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("ListaFuncionario", funcHumilde);
                response.sendRedirect("jsp/index.html");

            } catch (Exception ex) {
                Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Buscar/BuscaFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
