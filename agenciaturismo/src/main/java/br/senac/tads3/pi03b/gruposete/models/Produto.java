package br.senac.tads3.pi03b.gruposete.models;

public class Produto {
    protected int id_produto;
    protected Voo voo;
    protected Hotel hotel;
    protected boolean ativo;

    // Venda com voo e sem hotel
    public Produto(int id_produto, Voo voo, boolean ativo) {
        this.id_produto = id_produto;
        this.voo = voo;
        this.ativo = ativo;
    }

    // Venda com hotel e sem voo
    public Produto(int id_produto, Hotel hotel, boolean ativo) {
        this.id_produto = id_produto;
        this.hotel = hotel;
        this.ativo = ativo;
    }

    // Venda com voo e com hotel
    public Produto(int id_produto, Voo voo, Hotel hotel, boolean ativo) {
        this.id_produto = id_produto;
        this.voo = voo;
        this.hotel = hotel;
        this.ativo = ativo;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
