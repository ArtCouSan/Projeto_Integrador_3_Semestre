package br.senac.tads3.pi03b.gruposete.models;

public class Menu {

    private String caminho;

    private String icone;

    public String getCaminho() {
        return caminho;
    }

    public String getIcone() {
        return icone;
    }

    public String[] pegarCaminho() {

        String[] listaMenu = this.caminho.split(",");

        return listaMenu;

    }

    public String[] pegarIcone() {

        String[] listaMenu = this.icone.split(",");

        return listaMenu;

    }

}
