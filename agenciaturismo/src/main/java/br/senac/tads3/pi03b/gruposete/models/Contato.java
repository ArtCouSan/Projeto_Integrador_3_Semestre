package br.senac.tads3.pi03b.gruposete.models;

import java.util.Date;

public class Contato {
    private String nome;
    private String cpf;
    private char sexo;
    private Date data_nasc;
    private String celular;
    private String telefone;
    private String email;
    private String dd_telefone;
    private String dd_celular;

    public Contato() {
    }

    public Contato(String nome, String cpf, char sexo, Date data_nasc, String celular, String telefone, String email, String dd_telefone, String dd_celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
        this.dd_telefone = dd_telefone;
        this.dd_celular = dd_celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
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
