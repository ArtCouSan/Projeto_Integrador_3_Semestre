package br.senac.tads3.pi03b.gruposete.models;

import java.util.Date;

public class Voo {
    private int id_voo;
    private Date data_ida;
    private Date data_volta;
    private String destino;
    private String origem;
    private int quantidade_passagens;

    public Voo() {
        
    }

    public Voo(int id_voo, Date data_ida, Date data_volta, String destino, String origem, int quantidade_passagens) {
        this.id_voo = id_voo;
        this.data_ida = data_ida;
        this.data_volta = data_volta;
        this.destino = destino;
        this.origem = origem;
        this.quantidade_passagens = quantidade_passagens;
    }

    public int getId_voo() {
        return id_voo;
    }

    public void setId_voo(int id_voo) {
        this.id_voo = id_voo;
    }

    public Date getData_ida() {
        return data_ida;
    }

    public void setData_ida(Date data_ida) {
        this.data_ida = data_ida;
    }

    public Date getData_volta() {
        return data_volta;
    }

    public void setData_volta(Date data_volta) {
        this.data_volta = data_volta;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getQuantidade_passagens() {
        return quantidade_passagens;
    }

    public void setQuantidade_passagens(int quantidade_passagens) {
        this.quantidade_passagens = quantidade_passagens;
    }
    
}
