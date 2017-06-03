package br.senac.tads3.pi03b.gruposete.services;

import br.senac.tads3.pi03b.gruposete.models.Hotel;

public class HotelService {

    public HotelService() {
    }

    public boolean validaHotel(Hotel hotel) {
        return !(validaNome_hotel(hotel.getNome())
                && validaQuantidade_quartos(hotel.getQuantidade_quartos())
                && validaQuantidade_hospedes(hotel.getQuantidade_hospedes())
                && validaPreco(hotel.getPreco()));
    }

    public boolean validaNome_hotel(String nome_hotel) {
        return nome_hotel == null || nome_hotel.length() < 1;
    }

    public boolean validaQuantidade_quartos(int quantidade_quartos) {
        return quantidade_quartos < 1;
    }

    public boolean validaQuantidade_hospedes(int quantidade_hospedes) {
        return quantidade_hospedes < 1;
    }

    public boolean validaPreco(float preco) {
        return preco < 0;
    }
}
