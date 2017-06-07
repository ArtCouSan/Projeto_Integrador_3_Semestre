package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import java.sql.SQLException;

public class ClienteService {

    public ClienteService() {
    }

    public boolean validaCliente(String nome, String cpf, String nascimento,
            String rua, int numero, String cep, String cidade, String email) throws SQLException, ClassNotFoundException {
        return validaNome(nome)
                || validaCpf(cpf)
                || validaNascimento(nascimento)
                || validaRua(rua)
                || validaNumero(numero)
                || validaCep(cep)
                || validaCidade(cidade)
                || validaEmail(email);
    }

    public boolean validaCliente(String nome, String nascimento,
            String rua, int numero, String cep, String cidade, String email) throws SQLException, ClassNotFoundException {
        return validaNome(nome)
                || validaNascimento(nascimento)
                || validaRua(rua)
                || validaNumero(numero)
                || validaCep(cep)
                || validaCidade(cidade)
                || validaEmail(email);
    }

    public boolean validaNome(String nome) {
        return "".equals(nome);
    }

    public boolean validaCpf(String cpf) throws SQLException, ClassNotFoundException {
        ClienteDAO verificacao = new ClienteDAO();
        ValidaCPF validador = new ValidaCPF();
        return verificacao.verificarCPF(cpf) || validador.isCPF(cpf);
    }

    public boolean validaNascimento(String nascimento) {
        return "".equals(nascimento);
    }

    public boolean validaRua(String rua) {
        return "".equals(rua);
    }

    public boolean validaNumero(int numero) {
        return numero <= 0;
    }

    public boolean validaCep(String cep) {
        return ("".equals(cep) || cep.contains("_"));
    }

    public boolean validaCidade(String cidade) {
        return "".equals(cidade);
    }

    public boolean validaEmail(String email) {
        return "".equals(email) || !email.contains("@");
    }

}
