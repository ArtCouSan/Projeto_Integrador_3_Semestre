package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.models.Voo;

public class VooService {

    public VooService() {
    }
    
    public boolean validaVoo(Voo voo){
        return !(validaOrigem(voo.getOrigem())
                && validaDestino(voo.getDestino())
                && validaQuantidade_passagens(voo.getQuantidade_passagens())
                && validaPreco(voo.getPreco()));
    }
    
    public boolean validaOrigem(String origem){
        return origem == null || origem.length() < 1;
    }
    
    public boolean validaDestino (String destino){
        return destino == null || destino.length() < 1;
    }
    
    public boolean validaQuantidade_passagens (int quantidade_passagens){
        return quantidade_passagens < 1;
    }
    
    public boolean validaPreco (float preco){
        return preco < 0;
    }
}
