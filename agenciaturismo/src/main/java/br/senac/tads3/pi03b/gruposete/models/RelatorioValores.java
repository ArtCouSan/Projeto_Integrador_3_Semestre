package br.senac.tads3.pi03b.gruposete.models;

public class RelatorioValores {

    private String filial;
    private float valor;
    private String data;

    public RelatorioValores(String filial, float valor, String data) {
        this.filial = filial;
        this.valor = valor;
        this.data = data;
    }

    public RelatorioValores() {
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
