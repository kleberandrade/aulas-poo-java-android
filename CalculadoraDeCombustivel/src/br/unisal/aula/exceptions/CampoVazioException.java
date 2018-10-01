package br.unisal.aula.exceptions;

public class CampoVazioException extends RuntimeException {

    public CampoVazioException(String campo) {
        super("Campo " + campo + " vazio");
    }

}
