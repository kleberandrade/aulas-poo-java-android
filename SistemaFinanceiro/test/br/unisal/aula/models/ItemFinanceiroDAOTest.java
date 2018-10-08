/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.aula.models;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author 1711 MXTI
 */
public class ItemFinanceiroDAOTest {

    public ItemFinanceiroDAOTest() {
    }

    @Test
    @Ignore
    public void inserirUmItemFinanceiro() {

        String descricao = "Almoço";
        String tipo = "Despesa";
        double valor = 30.0;
        String categoria = "Alimentação";
        Date data = new Date();

        ItemFinanceiro item = new ItemFinanceiro(descricao, tipo, valor, categoria, data);
        ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
        int id = dao.inserir(item);
        if (id > 0){
            System.out.println("Id = " + id);
            System.out.println("Item inserido com sucesso!");
        } else {
            fail("Erro ao inserir um item");
        }
    }

    @Test
    @Ignore
    public void listarTodosItensFinanceiros() {

        ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
        List<ItemFinanceiro> itens = dao.buscarTodos();

        if (itens.isEmpty()) {
            fail("Erro ao recuperar um item");
        } else {
            for (ItemFinanceiro iten : itens) {
                System.out.println(iten);
            }
        }
    }
    
    @Test
    @Ignore
    public void atualizarUmItemFinanceiro() {

        String descricao = "Almoço";
        String tipo = "Despesa";
        double valor = 50.0;
        String categoria = "Alimentação";
        Date data = new Date();

        ItemFinanceiro item = new ItemFinanceiro(1, descricao, tipo, valor, categoria, data);
        ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
        if (dao.atualizar(item)){
            System.out.println("Item atualizado com sucesso!");
        } else {
            fail("Erro ao atjualizar um item");
        }
    }

    @Test
    public void excluirUmItemFinanceiro() {

        String descricao = "Almoço";
        String tipo = "Despesa";
        double valor = 50.0;
        String categoria = "Alimentação";
        Date data = new Date();

        ItemFinanceiro item = new ItemFinanceiro(5, descricao, tipo, valor, categoria, data);
        ItemFinanceiroDAO dao = new ItemFinanceiroDAO();
        if (dao.excluir(item)){
            System.out.println("Item excluido com sucesso!");
        } else {
            fail("Erro ao excluido um item");
        }
    }
    
}
