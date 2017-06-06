package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import java.sql.SQLException;

public class ClienteService {

    public ClienteService() {
    }

    public boolean validaCliente(String nome, int numero, String rua,
            String cidade, String cep, String cpf) throws SQLException, ClassNotFoundException {
        return validaNome(nome)
                && validaNumero(numero)
                && validaRua(rua)
                && validaCidade(cidade)
                && validaCep(cep)
                && validaCpf(cpf);
    }

    public boolean validaNome(String nome) {
        return "".equals(nome);
    }

    public boolean validaNumero(int numero) {
        return numero <= 0;
    }

    public boolean validaRua(String rua) {
        return "".equals(rua);
    }

    public boolean validaCidade(String cidade) {
        return "".equals(cidade);
    }

    public boolean validaCep(String cep) {
        return "".equals(cep);
    }

    public boolean validaCpf(String cpf) throws SQLException, ClassNotFoundException {
        ClienteDAO cliente = new ClienteDAO();
        return cliente.verificarCPF(cpf);
    }

}
