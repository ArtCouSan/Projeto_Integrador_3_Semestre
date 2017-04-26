package br.senac.tads3.pi03b.gruposete.models;

public class Produto {

    private int id_produto;
    private Voo voo;
    private Hotel hotel;
    private boolean ativo;

    // Venda com voo e sem hotel
    public Produto(Voo voo, boolean ativo) {
        this.voo = voo;
        this.ativo = ativo;
    }

    // Venda com hotel e sem voo
    public Produto(Hotel hotel, boolean ativo) {
        this.hotel = hotel;
        this.ativo = ativo;
    }

    // Venda com voo e com hotel
    public Produto(Voo voo, Hotel hotel, boolean ativo) {
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
