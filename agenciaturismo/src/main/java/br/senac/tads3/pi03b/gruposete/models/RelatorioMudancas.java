package br.senac.tads3.pi03b.gruposete.models;

public class RelatorioMudancas {

    private String filial;
    private String mudanca;
    private String funcionario;
    private String cargo;
    private String data;
    private int id_funcionario;

    public RelatorioMudancas(String mudanca, int id_funcionario, String data) {
        this.mudanca = mudanca;
        this.id_funcionario = id_funcionario;
        this.data = data;
    }
    
    public RelatorioMudancas() {

    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
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
