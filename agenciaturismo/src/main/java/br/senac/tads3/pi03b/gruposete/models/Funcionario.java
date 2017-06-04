package br.senac.tads3.pi03b.gruposete.models;

public final class Funcionario extends Pessoa {

    private int id;
    private String cargo;
    private String filial;
    private String departamento;
    private String login;
    private String senha;
    private String acesso;

    public Funcionario(String nome, String cpf, String sexo, String data_nasc, 
            int numero, String cep, String rua, String bairro, String cidade, 
            String complemento, String celular, String telefone, 
            String email, boolean ativo,String cargo, String filial, 
            String departamento, String login, String senha, String acesso) {
        
        super(nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, 
                complemento, celular, telefone, email, ativo);
        this.cargo = cargo;
        this.filial = filial;
        this.departamento = departamento;
        this.login = login;
        this.senha = senha;
        this.acesso = acesso;
    }

    public Funcionario() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    
    public boolean temPapel(String papel) {
        return (this.acesso.equalsIgnoreCase(papel));
    }
}
