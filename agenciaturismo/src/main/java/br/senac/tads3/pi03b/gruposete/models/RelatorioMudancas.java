package br.senac.tads3.pi03b.gruposete.models;

public class RelatorioMudancas {

    private String filial;
    private String mudanca;
    private String funcionario;
    private String cargo;
    private String data;
    private int id_func;

    public RelatorioMudancas(String mudanca, int id_func, String data) {
        this.mudanca = mudanca;
        this.id_func = id_func;
        this.data = data;
    }
    
    public RelatorioMudancas() {

    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getMudanca() {
        return mudanca;
    }

    public void setMudanca(String mudanca) {
        this.mudanca = mudanca;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
