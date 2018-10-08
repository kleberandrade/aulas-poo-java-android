package br.unisal.aula.models;

import java.util.ArrayList;
import java.util.List;

public interface IGenericDAO<T> {
    
    int inserir(T t);

    ArrayList<T> buscarTodos();

    boolean atualizar(T t);
    
    public boolean excluir(T t);
    
}
