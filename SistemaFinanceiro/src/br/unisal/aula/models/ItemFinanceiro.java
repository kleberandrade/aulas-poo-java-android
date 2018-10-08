package br.unisal.aula.models;

import java.io.Serializable;
import java.util.Date;

public class ItemFinanceiro implements Serializable {

    private long id;
    private String descricao;
    private String tipo;
    private double valor;
    private String categoria;
    private Date data;

    public ItemFinanceiro(String descricao, String tipo, double valor, String categoria, Date data) {
        this.id = 0;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    public ItemFinanceiro(long id, String descricao, String tipo, double valor, String categoria, Date data) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    public ItemFinanceiro() {
        
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ItemFinanceiro{" + "id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", valor=" + valor + ", categoria=" + categoria + ", data=" + data + '}';
    }
}
