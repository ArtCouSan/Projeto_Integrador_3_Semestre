package br.senac.tads3.pi03b.gruposete.models;
/**
 * Classe que cria lista de produto escolhidos pelo cliente.
 *
 * @author Grupo 07
 */
public class Carrinho {
    
    // Declara atributos.
    private int id_produto;    
    private float preco; 
    private int quantidade;

    public Carrinho(int id_produto, float preco, int quantidade) {
        this.id_produto = id_produto;
        this.preco = preco;
        this.quantidade = quantidade;
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
    
}
