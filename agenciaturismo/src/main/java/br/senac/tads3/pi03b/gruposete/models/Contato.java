package br.senac.tads3.pi03b.gruposete.models;

public class Contato {

    private String celular;
    private String telefone;
    private String email;
    private String dd_telefone;
    private String dd_celular;

    public Contato() {
    }

    public Contato(String celular, String telefone, String email, String dd_telefone, String dd_celular) {
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
        this.dd_telefone = dd_telefone;
        this.dd_celular = dd_celular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDd_telefone() {
        return dd_telefone;
    }

    public void setDd_telefone(String dd_telefone) {
        this.dd_telefone = dd_telefone;
    }

    public String getDd_celular() {
        return dd_celular;
    }

    public void setDd_celular(String dd_celular) {
        this.dd_celular = dd_celular;
    }

}
