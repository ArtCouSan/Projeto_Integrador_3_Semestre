package br.senac.tads3.pi03b.gruposete.models;

import java.util.LinkedHashMap;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

public class Usuario {

private static Map<String, Usuario> USUARIOS_CADASTRADOS = new LinkedHashMap<>();

    static {
        USUARIOS_CADASTRADOS.put("admin", new Usuario("admin",
                "Administrador", "admin", "ADMIN"));
    }

    private int id_usuario;
    private String login;
    private String nome;
    private String senha;
    private String hashSenha;
    private String acesso;

    public Usuario() {
    }

    public Usuario(String usuario, String nome, String senha, String papel) {
        this.login = usuario;
        this.nome = nome;
        this.setHashSenha(senha);
        this.setSenha(senha);
        this.acesso = papel;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public final void setHashSenha(String senha) {
        this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public void cadastrarUsuario() {
        USUARIOS_CADASTRADOS.put(this.getLogin(), new Usuario(this.getLogin(),
                this.getNome(), this.getSenha(), this.getAcesso()));
    }

    public boolean temPapel(String papel) {
        return (this.acesso.equalsIgnoreCase(papel));
    }

    public static Usuario obterUsuario(String usuario, String senha) {
        Usuario usuarioEncontrado = USUARIOS_CADASTRADOS.get(usuario);
        if (usuarioEncontrado != null && BCrypt.checkpw(senha, usuarioEncontrado.getHashSenha())) {
            return usuarioEncontrado;
        }
        return null;
    }
}
