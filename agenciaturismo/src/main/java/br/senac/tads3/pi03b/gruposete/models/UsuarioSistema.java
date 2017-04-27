package br.senac.tads3.pi03b.gruposete.models;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioSistema {

    private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

    static {
        USUARIOS_CADASTRADOS = new LinkedHashMap<>();
        USUARIOS_CADASTRADOS.put("madruga", new UsuarioSistema("madruga",
                "Seu Madruga", "pagueoaluguel", new String[]{"BASICO"}));
        USUARIOS_CADASTRADOS.put("bozo", new UsuarioSistema("bozo",
                "Palhaço Bozo", "abcd1234", new String[]{"BASICO", "ADMIN"}));
    }

    private String usuario;

    private String nomeCompleto;

    private String hashSenha;

    private String[] papeis; // ROLES

    public UsuarioSistema() {

    }

    public UsuarioSistema(String usuario, String nomeCompleto, String senha, String[] papeis) {
        this.usuario = usuario;
        this.nomeCompleto = nomeCompleto;
        setSenha(senha);
        this.papeis = papeis;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public final void setSenha(String senha) {
        this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public String[] getPapeis() {
        return papeis;
    }

    public void setPapeis(String[] papeis) {
        this.papeis = papeis;
    }

    public boolean temPapel(String papel) {
        List<String> papeisUsuario = Arrays.asList(papeis);
        return papeisUsuario.contains(papel);
    }

    public static UsuarioSistema obterUsuario(String usuario, String senha) {
        UsuarioSistema usuarioEncontrado = USUARIOS_CADASTRADOS.get(usuario);
        if (usuarioEncontrado != null && BCrypt.checkpw(senha, usuarioEncontrado.getHashSenha())) {
            return usuarioEncontrado;
        }
        return null;
    }

}
