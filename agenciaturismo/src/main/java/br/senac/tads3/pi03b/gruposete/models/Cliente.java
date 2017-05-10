package br.senac.tads3.pi03b.gruposete.models;

public final class Cliente extends Pessoa {

    private int id_cliente;

    public Cliente(String nome, String cpf, String sexo, String data_nasc, int numero, 
            String cep, String rua, String bairro, String cidade, String logradouro, 
            String complemento, String celular, String telefone, String email, boolean ativo) {
        
        super(nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, 
                complemento, celular, telefone, email, ativo);
    }

    public Cliente() {

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}
