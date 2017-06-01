package br.senac.tads3.pi03b.gruposete.models;

public class Carrinho {

    // Declara atributos.
    private int id_venda;
    private int id_produto;
    private float preco;
    private int quantidade;
    private String tipo;

    public Carrinho(int id_produto, float preco, int quantidade, int id_venda, String tipo) {
        this.id_produto = id_produto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id_venda = id_venda;
        this.tipo = tipo;
    }

    // Get e Set do id do produto.
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    // Get e Set do preco unitario do produto.
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    // Get e Set da quantidade selecionada.
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

}
