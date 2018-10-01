/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.aula.exceptions;

/**
 *
 * @author lab4l
 */
public class LimiteCampoException extends RuntimeException {

    public LimiteCampoException() {
        super("Valor fora do limite permitido");
    }
}
