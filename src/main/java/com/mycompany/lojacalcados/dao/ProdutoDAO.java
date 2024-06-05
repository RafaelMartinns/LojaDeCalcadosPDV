package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    
    public static int adicionar(Produto produto){
        
        int retorno = 0;
        
        try {
            
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "INSERT INTO Produto(nomeProduto,marca,preco,sexo) VALUES (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            instrucaoSQL.setString(1,produto.getNome());
            instrucaoSQL.setString(2,produto.getMarca());
            instrucaoSQL.setDouble(3,produto.getPreco());            
            instrucaoSQL.setString(4,produto.getSexo());
            int linhasAlteradas =  instrucaoSQL.executeUpdate();
            if (linhasAlteradas > 0){
                try (ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        return generatedId;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            ConnectorDAO.FecharConexao();   
        }
        
        return retorno;
    }
    
    public static ArrayList<Produto> consultar(String nomeProduto){
        ArrayList<Produto> listaRetorno = new ArrayList<>();
        
        ResultSet rs = null;

        try {
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "select * from produto where nomeProduto  like ?"
            );
            
            instrucaoSQL.setString(1, nomeProduto + "%");
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idProduto");                    
                    String nome = rs.getString("nomeProduto");
                    String marca = rs.getString("marca");
                    String sexo = rs.getString("sexo");
                    double preco  = rs.getDouble("preco");
                    Produto item = new Produto(id, nome, marca, preco, sexo); 
                   item.setId(id);
                   listaRetorno.add(item);
                }
                
            }
            
        } catch (Exception e) {
            listaRetorno=null;
            System.out.println(e.getMessage());
        } finally {
           ConnectorDAO.FecharConexao(); 
        }
        
    
        return listaRetorno;
    }
    
    public static Produto consultarById(int idProduto){
        Produto retornoProduto = null;
        
        ResultSet rs = null;

        try {
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "select * from produto where idProduto = ?"
            );
            
            instrucaoSQL.setInt(1, idProduto);
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idProduto");                    
                    String nome = rs.getString("nomeProduto");
                    String marca = rs.getString("marca");
                    String sexo = rs.getString("sexo");
                    double preco  = rs.getDouble("preco");
                    retornoProduto = new Produto(id, nome, marca, preco, sexo); 
                    return retornoProduto;
                }
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
           ConnectorDAO.FecharConexao(); 
        }
        
    
        return retornoProduto;
    }
    
    public static ArrayList<Produto> consultarTodos(){
        ArrayList<Produto> listaRetorno = new ArrayList<>();
        
        ResultSet rs = null;

        try {
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                "select * from produto"
            );
            
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idProduto");                    
                    String nome = rs.getString("nomeProduto");
                    String marca = rs.getString("marca");
                    String sexo = rs.getString("sexo");
                    double preco  = rs.getDouble("preco");
                    Produto item = new Produto(id, nome, marca, preco, sexo); 
                   item.setId(id);
                   listaRetorno.add(item);
                }
                
            }
            
        } catch (Exception e) {
            listaRetorno = null;
            System.out.println(e.getMessage());
        } finally {
           ConnectorDAO.FecharConexao(); 
        }
        
    
        return listaRetorno;
    }
    
    public static boolean excluir(int idExcluir){
        boolean retorno = false ;
        
        try{
            
            var conexao = ConnectorDAO.AbrirConexao();           
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "DELETE FROM produto WHERE idProduto = ?;"
            );
            
            instrucaoSQL.setInt(1, idExcluir);
            
            int linhasAfetadas=instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) 
                retorno = true;
            
        }catch(Exception e){
            System.out.println( e.getMessage());        
        }finally{
            ConnectorDAO.FecharConexao(); 
        }
        
        return retorno;

    }
    
    public static boolean alterar(Produto obj){
        boolean retorno = false ;
        
        try{
            
            var conexao = ConnectorDAO.AbrirConexao();
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "UPDATE produto SET nomeProduto=?, marca=?, preco=?, sexo=? WHERE idProduto =?;"
            );
            
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getMarca());
            instrucaoSQL.setDouble(3, obj.getPreco());
            instrucaoSQL.setString(4, obj.getSexo());
            instrucaoSQL.setInt(5, obj.getId());
            
            int linhasAfetadas=instrucaoSQL.executeUpdate();
            if (linhasAfetadas>0) 
                retorno = true;  
        }catch(Exception e){
            System.out.println( e.getMessage());
        }finally{
            ConnectorDAO.FecharConexao();
        }
        
        return retorno; 
    }

    
}
