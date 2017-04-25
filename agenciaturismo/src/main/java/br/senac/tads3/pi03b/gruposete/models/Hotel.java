package br.senac.tads3.pi03b.gruposete.models;

import java.util.Date;

public class Hotel {
    protected int id_hotel;
    protected String nome_hotel;
    protected Date data_entrada;
    protected Date data_saida;
    protected String quantidade_quartos;
    protected String quantidade_hospedes;

    public Hotel() {
        
    }

    public Hotel(int id_hotel, String nome_hotel, Date data_entrada, Date data_saida, String quantidade_quartos, String quantidade_hospedes) {
        this.id_hotel = id_hotel;
        this.nome_hotel = nome_hotel;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.quantidade_quartos = quantidade_quartos;
        this.quantidade_hospedes = quantidade_hospedes;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNome_hotel() {
        return nome_hotel;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome_hotel = nome_hotel;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public String getQuantidade_quartos() {
        return quantidade_quartos;
    }

    public void setQuantidade_quartos(String quantidade_quartos) {
        this.quantidade_quartos = quantidade_quartos;
    }

    public String getQuantidade_hospedes() {
        return quantidade_hospedes;
    }

    public void setQuantidade_hospedes(String quantidade_hospedes) {
        this.quantidade_hospedes = quantidade_hospedes;
    }
    
}
