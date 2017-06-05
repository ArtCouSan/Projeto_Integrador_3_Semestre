package br.senac.tads3.pi03b.gruposete.services;


public class HotelService {

    public HotelService() {
    }

    public boolean validaHotel(String nome, int quantidade_quartos, 
            int quantidade_hospedes, float preco) {
        return validaNome(nome)
                && validaQuantidade_quartos(quantidade_quartos)
                && validaQuantidade_hospedes(quantidade_hospedes)
                && validaPreco(preco);
    }

    public boolean validaNome(String nome) {
        return "".equals(nome);
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
