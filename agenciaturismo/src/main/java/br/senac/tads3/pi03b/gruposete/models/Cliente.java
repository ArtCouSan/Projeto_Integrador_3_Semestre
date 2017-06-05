package br.senac.tads3.pi03b.gruposete.models;

public final class Cliente extends Pessoa {

    private int id;

    public Cliente(String nome, String cpf, String sexo, String data_nasc, int numero, 
            String cep, String rua, String bairro, String cidade, 
            String complemento, String celular, String telefone, String email, boolean ativo) {
        
        super(nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, 
                complemento, celular, telefone, email, ativo);
    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
