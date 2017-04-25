package br.senac.tads3.pi03b.gruposete.models;

public class Venda {
    protected int id_venda;
    protected Produto produto;
    protected Cliente cliente;
    protected boolean ativo;
    protected float preco;

    public Venda() {
        
    }

    public Venda(int id_venda, Produto produto, Cliente cliente, boolean ativo, float preco) {
        this.id_venda = id_venda;
        this.produto = produto;
        this.cliente = cliente;
        this.ativo = ativo;
        this.preco = preco;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
