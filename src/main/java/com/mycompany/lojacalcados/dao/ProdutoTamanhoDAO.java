package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.ProdutoTamanho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutoTamanhoDAO {
    public static boolean adicionar(ProdutoTamanho produtoTamanho){
        
        boolean retorno =false;
        
        try {
            
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "INSERT INTO Produto_tamanho (fk_produto, tamanho, quantidade) VALUES (?,?,?)"
            );
            instrucaoSQL.setInt(1,produtoTamanho.getFkProduto());
            instrucaoSQL.setInt(2,produtoTamanho.getTamanho());
            instrucaoSQL.setInt(3,produtoTamanho.getQuantidade()); 
            int linhasAlteradas =  instrucaoSQL.executeUpdate();
            
            if (linhasAlteradas > 0)
                retorno = true;
        
        } catch (Exception e) {
            System.out.println(e.getMessage() + "");
        }finally{
            ConnectorDAO.FecharConexao();   
        }
        
        return retorno;
    }
    
    public static boolean alterarQtd(int fkProdutoTamanho, int novaQtd){
        
        boolean retorno =false;
        
        try {
            
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "UPDATE Produto_tamanho SET quantidade = ? WHERE idProduto_tamanho = ?"
            );
            
            instrucaoSQL.setInt(1,novaQtd);
            instrucaoSQL.setInt(2,fkProdutoTamanho);
            
            int linhasAlteradas =  instrucaoSQL.executeUpdate();
            
            if (linhasAlteradas > 0)
                retorno = true;
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            ConnectorDAO.FecharConexao();   
        }
        
        return retorno;
    }
    
    public static ArrayList<ProdutoTamanho> consultarByProduto(int fkProduto){
        ArrayList<ProdutoTamanho> listaRetorno = new ArrayList<>();
        
        ResultSet rs = null;

        try {
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "select * from produto_tamanho where fk_produto = ?"
            );
            
            instrucaoSQL.setInt(1, fkProduto);
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idProduto_tamanho");                    
                    int fkProdutoRetorno = rs.getInt("fk_produto");
                    int tamanho = rs.getInt("tamanho");
                    int quantidade = rs.getInt("quantidade");
                    ProdutoTamanho item = new ProdutoTamanho(id, fkProdutoRetorno, tamanho, quantidade); 
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
    
    public static ProdutoTamanho consultarByProdutoETamanho(int fkProduto, int tamanhoProcura){
        ProdutoTamanho retorno = null;
        
        ResultSet rs = null;

        try {
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "select * from produto_tamanho where fk_produto = ? and tamanho = ?"
            );
            
            instrucaoSQL.setInt(1, fkProduto);
            instrucaoSQL.setInt(2, tamanhoProcura);
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idProduto_tamanho");                    
                    int fkProdutoRetorno = rs.getInt("fk_produto");
                    int tamanho = rs.getInt("tamanho");
                    int quantidade = rs.getInt("quantidade");
                    retorno = new ProdutoTamanho(id, fkProdutoRetorno, tamanho, quantidade); 
                    return retorno;
                }
                
            }
            
        } catch (Exception e) {
            retorno = null;
            System.out.println(e.getMessage());
        } finally {
           ConnectorDAO.FecharConexao(); 
        }
        
    
        return retorno;
    }
    
    public static boolean excluir(int idExcluir){
        boolean retorno = false ;
        
        try{
            
            var conexao = ConnectorDAO.AbrirConexao();           
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "DELETE FROM produto_tamanho WHERE idProduto_tamanho = ?;"
            );
            
            instrucaoSQL.setInt(1, idExcluir);
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) 
                retorno = true;
            
        }catch(Exception e){
            System.out.println( e.getMessage());        
        }finally{
            ConnectorDAO.FecharConexao(); 
        }
        
        return retorno;

    } 
    
    public static boolean alterar(ProdutoTamanho obj){
        boolean retorno = false ;
        
        try{
            
            var conexao = ConnectorDAO.AbrirConexao();
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "UPDATE produto_tamanho SET tamanho=?, quantidade=? WHERE idproduto_tamanho =?;"
            );
            
            instrucaoSQL.setInt(1, obj.getTamanho());
            instrucaoSQL.setInt(2, obj.getQuantidade());
            instrucaoSQL.setInt(3, obj.getId());
            
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
