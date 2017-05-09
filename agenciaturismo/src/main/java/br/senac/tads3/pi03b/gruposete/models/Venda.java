package br.senac.tads3.pi03b.gruposete.models;

public class Venda {

    private int id_venda;
    private int id_produto;
    private int id_cliente;
    private int id_func;
    private int total_quantidade;
    private double preco;

    public Venda() {

    }

    public Venda(int id_produto, int id_cliente, int id_func, double preco, int total_quantidade) {
        this.id_produto = id_produto;
        this.id_cliente = id_cliente;
        this.id_func = id_func;
        this.preco = preco;
        this.total_quantidade = total_quantidade;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTotal_quantidade() {
        return total_quantidade;
    }

    public void setTotal_quantidade(int total_quantidade) {
        this.total_quantidade = total_quantidade;
    }

    
}
