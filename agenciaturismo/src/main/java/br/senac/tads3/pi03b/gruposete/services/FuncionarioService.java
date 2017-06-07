package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import java.sql.SQLException;

public class FuncionarioService {
    
    public FuncionarioService() {
    }
    
    public boolean validaFuncionario(String nome, String cpf, String nascimento,
            String rua, int numero, String cep, String cidade, String email,
            String departamento, String cargo, String filial, String login, String senha,
            String acesso) throws SQLException, ClassNotFoundException {
        return validaNome(nome)
                || validaCpf(cpf)
                || validaNascimento(nascimento)
                || validaRua(rua)
                || validaNumero(numero)
                || validaCep(cep)
                || validaCidade(cidade)
                || validaEmail(email)
                || validaDepartamento(departamento)
                || validaCargo(cargo)
                || validaFilial(filial)
                || validaLogin(login)
                || validaSenha(senha)
                || validaAcesso(acesso);
    }
    
        public boolean validaFuncionario(String nome, String nascimento,
            String rua, int numero, String cep, String cidade, String email,
            String departamento, String cargo, String filial, 
            String acesso) throws SQLException, ClassNotFoundException {
        return validaNome(nome)
                || validaNascimento(nascimento)
                || validaRua(rua)
                || validaNumero(numero)
                || validaCep(cep)
                || validaCidade(cidade)
                || validaEmail(email)
                || validaDepartamento(departamento)
                || validaCargo(cargo)
                || validaFilial(filial)
                || validaAcesso(acesso);
    }
    
    public boolean validaFuncionario(String nome, String cpf, String nascimento,
            String rua, int numero, String cep, String cidade, String email,
            String departamento, String cargo, String filial,
            String acesso) throws SQLException, ClassNotFoundException {
        return validaNome(nome)
                || validaCpf(cpf)
                || validaNascimento(nascimento)
                || validaRua(rua)
                || validaNumero(numero)
                || validaCep(cep)
                || validaCidade(cidade)
                || validaEmail(email)
                || validaDepartamento(departamento)
                || validaCargo(cargo)
                || validaFilial(filial)
                || validaAcesso(acesso);
    }
    
    public boolean validaNome(String nome) {
        return "".equals(nome);
    }
    
    public boolean validaCpf(String cpf) throws SQLException, ClassNotFoundException {
        FuncionarioDAO verificacao = new FuncionarioDAO();
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
    
    public boolean validaDepartamento(String departamento) {
        return "".equals(departamento);
    }
    
    public boolean validaCargo(String cargo) {
        return "".equals(cargo);
    }
    
    public boolean validaFilial(String filial) {
        return "".equals(filial);
    }
    
    public boolean validaLogin(String login) {
        return "".equals(login);
    }
    
    public boolean validaSenha(String senha) {
        return "".equals(senha);
    }
    
    public boolean validaAcesso(String acesso) {
        return "".equals(acesso);
    }
    
}
