package br.senac.tads3.pi03b.gruposete.services;

public class FuncionarioService {

    public FuncionarioService() {
    }

    public boolean validaFuncionario(String nome, String cpf, String sexo, String nascimento,
            String rua, int numero, String cep, String cidade, String estado, String email,
            String departamento, String cargo, String filial, String login, String senha,
            String acesso){
        return validaNome(nome)
                && validaCpf(cpf)
                && validaSexo(sexo)
                && validaNascimento(nascimento)
                && validaRua(rua)
                && validaNumero(numero)
                && validaCep(cep)
                && validaCidade(cidade)
                && validaEstado(estado)
                && validaEmail(email)
                && validaDepartamento(departamento)
                && validaCargo(cargo)
                && validaFilial(filial)
                && validaLogin(login)
                && validaSenha(senha)
                && validaAcesso(acesso);
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
