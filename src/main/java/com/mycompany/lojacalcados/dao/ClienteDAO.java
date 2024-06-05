
package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.Cliente;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteDAO {
    

    
    public static boolean Salvar(Cliente obj){
        boolean retorno = false ;
        
        try{
            
            var conexao = ConnectorDAO.AbrirConexao();
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "INSERT INTO cliente (nomeCliente,email,cpf,sexo,estadoCivil,telefone,endereco,nascimento) VALUES(?,?,?,?,?,?,?,?); "
            );
            
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getEmail());
            instrucaoSQL.setString(3, obj.getCpf());
            instrucaoSQL.setString(4, obj.getSexo());
            instrucaoSQL.setString(5, obj.getEstadoCivil());
            instrucaoSQL.setString(6, obj.getTelefone());
            instrucaoSQL.setString(7, obj.getEndereco());
            instrucaoSQL.setDate(8,new java.sql.Date(obj.getNascimento().getTime()) );
            
            int linhasAfetadas=instrucaoSQL.executeUpdate();
            if (linhasAfetadas>0) 
                retorno = true;
        
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "E-mail ou CPF já cadastrado!");
            
        }catch(Exception e){
            System.out.println( e.getMessage());
            
        
        }finally{
            ConnectorDAO.FecharConexao();
        }
        
        return retorno;
        
        
        
    }
    
    public static ArrayList<Cliente> consultar(){
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            var conexao = ConnectorDAO.AbrirConexao();
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "SELECT * FROM Cliente "
            );
            
            
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idCliente");
                    String nome = rs.getString("nomeCliente");
                    String email = rs.getString("email");
                    String cpf = rs.getString("cpf");
                    String sexo = rs.getString("sexo");
                    String telefone =rs.getString("telefone");
                    Date nascimento = rs.getDate("nascimento");
                    String endereco = rs.getString("endereco");
                    String estadoCivil = rs.getString("estadoCivil");
                    Cliente item = new Cliente(nome, cpf, nascimento, endereco, sexo, estadoCivil, email, telefone); 
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
            
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
        return listaRetorno;
    }
    
    public static Cliente consultarByCpf(String cpfBusca){
        ResultSet rs = null;
        
        try {
            var conexao = ConnectorDAO.AbrirConexao();
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "SELECT * FROM Cliente WHERE cpf = ?"
            );
            
            instrucaoSQL.setString(1, cpfBusca);
            rs = instrucaoSQL.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("idCliente");
                    String nome = rs.getString("nomeCliente");
                    String email = rs.getString("email");
                    String cpf = rs.getString("cpf");
                    String sexo = rs.getString("sexo");
                    String telefone =rs.getString("telefone");
                    Date nascimento = rs.getDate("nascimento");
                    String endereco = rs.getString("endereco");
                    String estadoCivil = rs.getString("estadoCivil");
                    Cliente item = new Cliente(nome, cpf, nascimento, endereco, sexo, estadoCivil, email, telefone); 
                    item.setId(id);
                    return item;
                }                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectorDAO.FecharConexao();        
        }
            
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
        return null;
    }
    
    public static boolean alterar(Cliente obj){
        boolean retorno = false ;
        
        try{
            
            var conexao = ConnectorDAO.AbrirConexao();
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "UPDATE cliente SET nomeCliente=?, email=?, cpf=?, sexo=?, estadoCivil=?, telefone=?, endereco=?, nascimento=? WHERE idCliente=?;"
            );
            
            instrucaoSQL.setString(1, obj.getNome());
            instrucaoSQL.setString(2, obj.getEmail());
            instrucaoSQL.setString(3, obj.getCpf());
            instrucaoSQL.setString(4, obj.getSexo());
            instrucaoSQL.setString(5, obj.getEstadoCivil());
            instrucaoSQL.setString(6, obj.getTelefone());
            instrucaoSQL.setString(7, obj.getEndereco());
            instrucaoSQL.setDate(8,new java.sql.Date(obj.getNascimento().getTime()) );
            instrucaoSQL.setInt(9, obj.getId());
            
            int linhasAfetadas=instrucaoSQL.executeUpdate();
            if (linhasAfetadas>0) 
                retorno = true;
            
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "E-mail ou CPF já cadastrado!");
            
        }catch(Exception e){
            System.out.println( e.getMessage());
            
        
        }finally{
            ConnectorDAO.FecharConexao();
        }
        
        return retorno; 
    }
    
    public static boolean excluir(int idExcluir){
        boolean retorno = false ;
        
        try{
            var conexao = ConnectorDAO.AbrirConexao();

            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "DELETE FROM Cliente WHERE idCliente = ?"
            );
            
            instrucaoSQL.setInt(1, idExcluir);
            
            int linhasAfetadas=instrucaoSQL.executeUpdate();
            if (linhasAfetadas>0) {
                retorno = true;
                
            }

        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            
            JOptionPane.showMessageDialog(null, "E-mail ou CPF já cadastrado!");
            
        }catch(Exception e){
            System.out.println( e.getMessage());
            
        
        }finally{
            ConnectorDAO.FecharConexao();
        }
        
        return retorno;
    } 
}
