package br.senac.tads3.pi03b.gruposete.models;

public class Voo {
    private int id_voo;
    private String data_ida;
    private String data_volta;
    private String destino;
    private String origem;
    private int quantidade_passagens;

    public Voo() {
        
    }

    public Voo(String data_ida, String data_volta, String destino, String origem, int quantidade_passagens) {
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

    public String getData_ida() {
        return data_ida;
    }

    public void setData_ida(String data_ida) {
        this.data_ida = data_ida;
    }

    public String getData_volta() {
        return data_volta;
    }

    public void setData_volta(String data_volta) {
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
