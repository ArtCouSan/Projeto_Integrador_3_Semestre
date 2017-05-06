package br.senac.tads3.pi03b.gruposete.models;

public class Produto {

    private int id_produto;
    private int id_voo;
    private int id_hotel;
    private double preco;

    // Venda com voo e sem hotel
    public Produto(int id_voo, double preco) {
        this.id_voo = id_voo;
        this.preco = preco;
    }

    // Venda com hotel e sem voo
    public Produto(double preco, int id_hotel) {
        this.id_hotel = id_hotel;
        this.preco = preco;
    }

    // Venda com voo e com hotel
    public Produto(int id_voo, int id_hotel, double preco) {
        this.id_voo = id_voo;
        this.id_hotel = id_hotel;
        this.preco = preco;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_voo() {
        return id_voo;
    }

    public void setId_voo(int id_voo) {
        this.id_voo = id_voo;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
