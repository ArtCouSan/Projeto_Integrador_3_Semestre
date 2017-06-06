package br.senac.tads3.pi03b.gruposete.services;

public class ClienteService {

    public ClienteService() {
    }

    public boolean validaCliente(String nome, String cpf, String sexo, String nascimento,
            String rua, int numero, String cep, String cidade, String estado, String email) {
        return validaNome(nome)
                && validaCpf(cpf)
                && validaSexo(sexo)
                && validaNascimento(nascimento)
                && validaRua(rua)
                && validaNumero(numero)
                && validaCep(cep)
                && validaCidade(cidade)
                && validaEstado(estado)
                && validaEmail(email);
    }

    public boolean validaNome(String nome) {
        return "".equals(nome);
    }
    
    public boolean validaCpf(String cpf) {
        return false;
    }
    
    public boolean validaSexo(String sexo){
        return "".equals(sexo);
    }
    
    public boolean validaNascimento(String nascimento){
        return "".equals(nascimento);
    }
    
    public boolean validaRua(String rua) {
        return "".equals(rua);
    }
    
    public boolean validaNumero(int numero) {
        return numero <= 0;
    }

    public boolean validaCep(String cep) {
        return "".equals(cep);
    }

    public boolean validaCidade(String cidade) {
        return "".equals(cidade);
    }
    
    public boolean validaEstado(String estado){
        return "".equals(estado);
    }
    
    public boolean validaEmail(String email){
        return "".equals(email);
    }

}
