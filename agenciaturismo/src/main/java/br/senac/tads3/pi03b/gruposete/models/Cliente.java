package br.senac.tads3.pi03b.gruposete.models;

public class Cliente {

    private int id_cliente;
    private String nome;
    private String cpf;
    private char sexo;
    private String data_nasc;
    private int numero;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String complemento;
    private String celular;
    private String telefone;
    private String email;
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, char sexo, String data_nasc, int numero, 
            String cep, String rua, String bairro, String cidade, String logradouro, 
            String complemento, String celular, String telefone, String email, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.numero = numero;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
        this.ativo = ativo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
