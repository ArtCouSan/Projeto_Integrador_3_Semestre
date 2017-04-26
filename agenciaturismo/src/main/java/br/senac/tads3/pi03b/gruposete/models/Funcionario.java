package br.senac.tads3.pi03b.gruposete.models;

public class Funcionario {

    private int id_func;
    private String cargo;
    private String departamento;
    private boolean ativo;
    private String filial;
    private Pessoa pessoa;

    public Funcionario() {
    }

    public Funcionario(String cargo, String departamento, boolean ativo, String filial, Pessoa pessoa) {
        this.cargo = cargo;
        this.departamento = departamento;
        this.ativo = ativo;
        this.filial = filial;
        this.pessoa = pessoa;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
