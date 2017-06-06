package br.senac.tads3.pi03b.gruposete.services;

public class VooService {

    public VooService() {
    }

    public boolean validaVoo(String origem, String destino, String data_ida,
            String data_volta, int quantidade_passagens, float preco) {
        return validaOrigem(origem)
                && validaDestino(destino)
                && validaIda(data_ida)
                && validaVolta(data_volta)
                && validaQuantidade_passagens(quantidade_passagens)
                && validaPreco(preco);
    }

    public boolean validaOrigem(String origem) {
        return "".equals(origem);
    }

    public boolean validaDestino(String destino) {
        return "".equals(destino);
    }
    
    public boolean validaIda(String data_ida) {
        return "".equals(data_ida);
    }
    
    public boolean validaVolta(String data_volta) {
        return "".equals(data_volta);
    }

    public boolean validaQuantidade_passagens(int quantidade_passagens) {
        return quantidade_passagens <= 0;
    }

    public boolean validaPreco(float preco) {
        return preco <= 0;
    }
}
