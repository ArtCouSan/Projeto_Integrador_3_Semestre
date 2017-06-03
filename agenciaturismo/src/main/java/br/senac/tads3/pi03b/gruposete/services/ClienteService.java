package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.models.Cliente;

public class ClienteService {

    public ClienteService() {
    }

    public boolean validaCliente(Cliente cliente) {
        return !(validaNome(cliente.getNome())
                && validaNumero(cliente.getNumero())
                && validaRua(cliente.getRua())
                && validaCidade(cliente.getCidade())
                && validaCep(cliente.getCep())
                && validaCpf(cliente.getCpf())
                && validaEmail(cliente.getEmail()));
    }

    public boolean validaNome(String nome) {
        return nome == null || nome.length() < 1;
    }

    public boolean validaNumero(int numero) {
        return numero <= 0;
    }

    public boolean validaRua(String rua) {
        return rua == null || rua.length() < 1;
    }

    public boolean validaCidade(String cidade) {
        return cidade == null || cidade.length() < 1;
    }

    public boolean validaCep(String cep) {
        return cep == null || cep.length() < 1;
    }

    public boolean validaCpf(String cpf) {
        return false;
    }

    public boolean validaEmail(String email) {
        if (email != null) {
            if (!email.contains("@") && !email.contains(".com")
                    || !email.contains(".com.br")) {
                return true;
            }
        }
        return false;
    }

}
