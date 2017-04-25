package br.senac.tads3.pi03b.gruposete.models;

public class Cliente {
    private int id_cliente;
    private boolean ativo;
    private Pessoa pessoa;

    public Cliente() {
    }

    public Cliente(int id_cliente, boolean ativo, Pessoa pessoa) {
        this.id_cliente = id_cliente;
        this.ativo = ativo;
        this.pessoa = pessoa;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
