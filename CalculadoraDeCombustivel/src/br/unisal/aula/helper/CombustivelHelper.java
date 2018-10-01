package br.unisal.aula.helper;

import br.unisal.aula.model.Combustivel;

public class CombustivelHelper {

    private CombustivelHelper() {
    }

    public static double relacao(Combustivel a, Combustivel b) {
        return a.getPreco() / b.getPreco() * 100;
    }
}
