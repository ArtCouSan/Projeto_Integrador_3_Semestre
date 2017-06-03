package br.senac.tads3.pi03b.gruposete.services;

public class FuncionarioService {

    public FuncionarioService() {
    }

    public boolean validaFuncionarioCadastro(String nome, int numero, String rua,
            String cidade, String cep, String cpf, String cargo, 
            String filial, String departamento, String login, String senha, String acesso) {
        return validaNome(nome)
                && validaNumero(numero)
                && validaRua(rua)
                && validaCidade(cidade)
                && validaCep(cep)
                && validaCpf(cpf)
                && validaCargo(cargo)
                && validaFilial(filial)
                && validaDepartamento(departamento)
                && validaLogin(login)
                && validaSenha(senha)
                && validaAcesso(acesso);
    }
    
    public boolean validaFuncionarioAlteracao(String nome, int numero, String rua,
            String cidade, String cep, String cargo, String filial, 
            String departamento, String login, String senha, String acesso) {
        return validaNome(nome)
                && validaNumero(numero)
                && validaRua(rua)
                && validaCidade(cidade)
                && validaCep(cep)
                && validaCargo(cargo)
                && validaFilial(filial)
                && validaDepartamento(departamento)
                && validaLogin(login)
                && validaSenha(senha)
                && validaAcesso(acesso);
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

    public boolean validaCpf(String cpf) {
        return false;
    }

    public boolean validaCargo(String cargo) {
        return "".equals(cargo);
    }

    public boolean validaFilial(String filial) {
        return "".equals(filial);
    }

    public boolean validaDepartamento(String departamento) {
        return "".equals(departamento);
    }

    public boolean validaLogin(String login) {
        return "".equals(login);
    }

    public boolean validaSenha(String senha) {
        return "".equals(senha) || senha.length() < 4 && senha.length() > 8;
    }

    public boolean validaAcesso(String acesso) {
        return "".equals(acesso);
    }

}
