package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.UsuarioSistema;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException, IOException {

    // Verifica se usuário já se logou, se positivo redireciona para tela principal
    HttpSession sessao = request.getSession(false);
    if (sessao != null && sessao.getAttribute("usuario") != null) {
      response.sendRedirect(request.getContextPath() + "/agenda");
      return;
    }

    // Apresenta tela de login para o usuário
    RequestDispatcher dispatcher
	    = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    dispatcher.forward(request, response);

  }

  @Override
  public void doPost(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException, IOException {
    // Recupera dados preenchidos pelo usuário
    String usuario = request.getParameter("usuario");
    String senhaDigitada = request.getParameter("senha");

    // Compara com o usuário/senha previamente cadastrado
    UsuarioSistema usuarioSistema
	    = UsuarioSistema.obterUsuario(usuario, senhaDigitada);
    if (usuarioSistema != null) {
      // Usuario existe e a senha está correta
      // Caso exista, invalida a sessão anterior (www.owasp.org)
      HttpSession sessao = request.getSession(false);
      if (sessao != null) {
	sessao.invalidate();
      }
      // Criar uma sessão
      sessao = request.getSession(true);
      sessao.setAttribute("usuario", usuarioSistema);

      response.sendRedirect(request.getContextPath() + "/agenda");
    } else {
      response.sendRedirect(
	      request.getContextPath() + "/erroLogin.jsp");
    }
  }

}
