package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AutorizacaoFilter",
        servletNames = {"AgendaServlet", "EntradaServlet"},
        urlPatterns = {"/protegido/*"}
)
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1) Verificar se usuário está autenticado
        // 1a) Cast dos objetos request e response
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 2) Tenta obter a sessao do usuario
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario
                = (Usuario) sessao.getAttribute("usuario");

        // Usuario nulo significa que não está logado
        // Redireciona para tela de login
        if (usuario == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        // 3) Usuario está logado, então verifica se tem permissão
        // para acessar a página.
        if (verificarAcesso(usuario, httpRequest, httpResponse)) {
            // Acesso a página está liberado.
            chain.doFilter(request, response);
        } else {
            // Usuário não tem permissão de acesso a página.
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erroNaoAutorizado.jsp");
        }
    }

    private static boolean verificarAcesso(Usuario usuario,
            HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");

        if (pagina.endsWith("entrada")
                && usuario.temPapel("ADMIN")) {
            return true;
        } else if (pagina.endsWith("agenda")
                && usuario.temPapel("BASICO")) {
            return true;

        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
