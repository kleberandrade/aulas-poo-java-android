package br.unisal.aula.model;


public class Pessoa {

    private String nome;
    private double peso;
    private double altura;

    public Pessoa(String nome, double peso, double altura) { //Insere todos os parametros de uma vez
        this.nome = nome;                                    //Construtos - método
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        //return nome;
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
