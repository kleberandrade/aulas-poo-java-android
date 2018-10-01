package br.unisal.aula.helper;

import javax.swing.JOptionPane;

public class MensagemHelper {
    
    private MensagemHelper(){}
    
    public static void exibir(String text){
        JOptionPane.showMessageDialog(null, text);
    }
   
}
