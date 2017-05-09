package br.senac.tads3.pi03b.gruposete.models;

public final class Funcionario extends Pessoa {

    private int id_func;
    private String cargo;
    private String filial;
    private String departamento;

    public Funcionario(String nome, String cpf, String sexo, String data_nasc, int numero, String cep, String rua, String bairro, String cidade, String logradouro, String complemento, String celular, String telefone, String email, boolean ativo,String cargo, String filial, String departamento) {
        super(nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, complemento, celular, telefone, email, ativo);
        this.cargo = cargo;
        this.filial = filial;
        this.departamento = departamento;
    }

    public Funcionario() {
        
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
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
    
}
