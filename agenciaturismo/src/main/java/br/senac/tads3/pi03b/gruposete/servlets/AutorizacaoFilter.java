package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AutorizacaoFilter",
        servletNames = {"AlteraClienteServlet", "AlteraFuncionarioServlet", "AlteraHotelServlet", "AlteraVooServlet",
            "BuscaClienteServlet", "BuscaFuncionarioServlet", "BuscaHotelServlet", "BuscaVooServlet",
            "CadastroClienteServlet", "CadastroFuncionarioServlet", "CadastroHotelServlet", "CadastroVooServlet",
            "ExcluiClienteServlet", "ExcluiFuncionarioServlet", "ExcluiHotelServlet", "ExcluiVooServlet",
            "ListaClienteServlet", "ListaFuncionarioServlet", "ListaHotelServlet", "ListaVooServlet"},
        urlPatterns = {"/protegido/*"}
)
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        System.out.println("USUARIO ACESSO >>>>>>>>>>>>>>>>>>>>>>>>" + usuario.getAcesso());
        
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
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/LoginNaoAutorizado");
        }
    }

    private static boolean verificarAcesso(Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ENTROU BVERIFICACAO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");
        System.out.println("ENTROU BVERIFICACAO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1");
        System.out.println("ENTROU BVERIFICACAO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + usuario.getAcesso());
        System.out.println("ENTROU BVERIFICACAO>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + pagina);
        if (pagina.endsWith("") && usuario.temPapel("MASTER")) {
            return true;
        } else if (pagina.contains("Cliente") || pagina.contains("BuscaVoo") || pagina.contains("BuscaHotel") && usuario.temPapel("BASICO")) {
            return true;

        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
