package br.senac.tads3.pi03b.gruposete.models;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String cpf;
    private char sexo;
    private Date data_nasc;
    private Contato contato;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, char sexo, Date data_nasc, Contato contato, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.contato = contato;
        this.endereco = endereco;
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
