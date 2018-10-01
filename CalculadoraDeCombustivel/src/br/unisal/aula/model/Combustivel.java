package br.unisal.aula.model;

public class Combustivel {

    public static final String ETANOL = "Etanol";
    public static final String GASOLINA = "Gasolina";
    
    private String tipo;
    private double preco;
    private double consumo;

    public Combustivel(String tipo, double preco, double consumo) {
        this.tipo = tipo;
        this.preco = preco;
        this.consumo = consumo;
    }

    public double precoPorKm() {
        return preco / consumo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}
