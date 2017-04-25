package br.senac.tads3.pi03b.gruposete.models;

public class Funcionario {
    private int id_func;
    private String cargo;
    private String departamento;
    private boolean ativo;
    private Pessoa pessoa;

    public Funcionario() {
    }

    public Funcionario(int id_func, String cargo, String departamento, boolean ativo, Pessoa pessoa) {
        this.id_func = id_func;
        this.cargo = cargo;
        this.departamento = departamento;
        this.ativo = ativo;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
