package br.unisal.aula.helper;

import br.unisal.aula.exceptions.CampoVazioException;
import br.unisal.aula.exceptions.LimiteCampoException;

public class ConverterCampoHelper {
    
    private ConverterCampoHelper(){}

    public static double parseDouble(String nome, String texto) {

        double valor = 0.0;
        try {
            valor = Double.parseDouble(texto.replace(',', '.'));
        } catch (NumberFormatException ex) {
            throw new CampoVazioException(nome);
        }

        return valor;
    }
    
    public static void validarMaiorQue(double valor, double limite){
        if (valor < limite){
            throw new LimiteCampoException();
        }
    }
}
