package br.unisal.aula.models;

import br.unisal.aula.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemFinanceiroDAO implements IGenericDAO<ItemFinanceiro> {

    private static final String SQL_INSERIR = "INSERT INTO itemfinanceiro(descricao, tipo, valor, categoria, data) VALUES(?,?,?,?,?)";
    private static final String SQL_ATUALIZAR = "UPDATE itemfinanceiro SET descricao = ?, tipo = ?, valor = ?, categoria = ?, data = ? WHERE id = ?";
    private static final String SQL_BUSCAR_TODOS = "SELECT * FROM itemfinanceiro";
    private static final String SQL_EXCLUIR = "DELETE FROM itemfinanceiro WHERE id = ?";

    private Connection connection = null;

    public ItemFinanceiroDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public int inserir(ItemFinanceiro item) {

        int id = -1;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getDescricao());
            statement.setString(2, item.getTipo());
            statement.setDouble(3, item.getValor());
            statement.setString(4, item.getCategoria());
            statement.setDate(5, new java.sql.Date(item.getData().getTime()));
            int linhaModificada = statement.executeUpdate();

            if (linhaModificada == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    item.setId(id);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return id;
    }

    @Override
    public ArrayList<ItemFinanceiro> buscarTodos() {

        ArrayList<ItemFinanceiro> itens = new ArrayList<>();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQL_BUSCAR_TODOS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ItemFinanceiro item = new ItemFinanceiro();
                item.setId(resultSet.getInt("id"));
                item.setDescricao(resultSet.getString("descricao"));
                item.setTipo(resultSet.getString("tipo"));
                item.setValor(resultSet.getDouble("valor"));
                item.setCategoria(resultSet.getString("categoria"));
                item.setData(new java.util.Date(resultSet.getDate("data").getTime()));

                itens.add(item);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

        return itens;
    }

    
    @Override
    public boolean atualizar(ItemFinanceiro item) {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_ATUALIZAR);
            statement.setString(1, item.getDescricao());
            statement.setString(2, item.getTipo());
            statement.setDouble(3, item.getValor());
            statement.setString(4, item.getCategoria());
            statement.setDate(5, new java.sql.Date(item.getData().getTime()));
            
            statement.setInt(6, (int)item.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return true;
    }
    
    @Override
    public boolean excluir(ItemFinanceiro item) {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_EXCLUIR);
            statement.setInt(1, (int)item.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        return true;
    }
    
}
