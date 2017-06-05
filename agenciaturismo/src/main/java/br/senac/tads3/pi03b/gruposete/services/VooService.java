package br.senac.tads3.pi03b.gruposete.services;

public class VooService {

    public VooService() {
    }

    public boolean validaVoo(String origem, String destino, 
            int quantidade_passagens, float preco) {
        return validaOrigem(origem)
                && validaDestino(destino)
                && validaQuantidade_passagens(quantidade_passagens)
                && validaPreco(preco);
    }

    public boolean validaOrigem(String origem) {
        return "".equals(origem);
    }

    public boolean validaDestino(String destino) {
        return "".equals(destino);
    }

    public boolean validaQuantidade_passagens(int quantidade_passagens) {
        return quantidade_passagens <= 0;
    }

    public boolean validaPreco(float preco) {
        return preco <= 0;
    }
}
