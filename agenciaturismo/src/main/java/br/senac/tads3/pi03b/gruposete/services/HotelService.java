package br.senac.tads3.pi03b.gruposete.services;

public class HotelService {

    public HotelService() {
    }

    public boolean validaHotel(String nome, int quantidade_quartos, String data_entrada,
            String data_saida, int quantidade_hospedes, float preco) {
        return validaNome(nome)
                && validaQuantidade_quartos(quantidade_quartos)
                && validaEntrada(data_entrada)
                && validaSaida(data_saida)
                && validaQuantidade_hospedes(quantidade_hospedes)
                && validaPreco(preco);
    }

    public boolean validaNome(String nome) {
        return "".equals(nome);
    }
    
    public boolean validaEntrada(String data_entrada) {
        return "".equals(data_entrada);
    }
    
    public boolean validaSaida(String data_saida) {
        return "".equals(data_saida);
    }

    public boolean validaQuantidade_quartos(int quantidade_quartos) {
        return quantidade_quartos <= 0;
    }

    public boolean validaQuantidade_hospedes(int quantidade_hospedes) {
        return quantidade_hospedes <= 0;
    }

    public boolean validaPreco(float preco) {
        return preco <= 0;
    }
}
