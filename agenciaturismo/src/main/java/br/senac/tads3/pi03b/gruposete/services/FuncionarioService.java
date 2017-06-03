package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;

public class FuncionarioService {

    public FuncionarioService() {
    }

    public boolean validaFuncionarioCadastro(Funcionario func) {
        return !(validaNome(func.getNome())
                && validaNumero(func.getNumero())
                && validaRua(func.getRua())
                && validaCidade(func.getCidade())
                && validaCep(func.getCep())
                && validaCpf(func.getCpf())
                && validaEmail(func.getEmail())
                && validaCargo(func.getCargo())
                && validaFilial(func.getFilial())
                && validaDepartamento(func.getDepartamento())
                && validaLogin(func.getLogin())
                && validaSenha(func.getSenha())
                && validaAcesso(func.getAcesso()));
    }

    public boolean validaFuncionarioAlteracao(Funcionario func) {
        return !(validaNome(func.getNome())
                && validaNumero(func.getNumero())
                && validaRua(func.getRua())
                && validaCidade(func.getCidade())
                && validaCep(func.getCep())
                && validaEmail(func.getEmail())
                && validaCargo(func.getCargo())
                && validaFilial(func.getFilial())
                && validaDepartamento(func.getDepartamento())
                && validaLogin(func.getLogin())
                && validaSenha(func.getSenha())
                && validaAcesso(func.getAcesso()));
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

    public boolean validaCargo(String cargo) {
        return cargo == null || cargo.length() < 1;
    }
    
    public boolean validaFilial(String filial) {
        return filial == null || filial.length() < 1;
    }
    
    public boolean validaDepartamento(String departamento) {
        return departamento == null || departamento.length() < 1;
    }
    
    public boolean validaLogin(String login) {
        return login == null || login.length() < 1;
    }
    
    public boolean validaSenha(String senha) {
        return senha == null || senha.length() < 4 && senha.length() > 8;
    }
    
    public boolean validaAcesso(String acesso) {
        return acesso == null || acesso.length() < 1;
    }
    
}
