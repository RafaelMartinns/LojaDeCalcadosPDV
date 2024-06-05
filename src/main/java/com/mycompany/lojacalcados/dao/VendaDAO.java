package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class VendaDAO {
    public static int adicionar(Venda venda){
        
        int idRetorno = 0;
        
        try {
            
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "INSERT INTO venda (fk_Cliente, vlFinal, dhPedido) VALUES (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            
            instrucaoSQL.setInt(1,venda.getFkCliente());
            instrucaoSQL.setDouble(2,venda.getVlFinal());
            instrucaoSQL.setTimestamp(3, Timestamp.valueOf(venda.getDhPedido()));
            
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
        
        return idRetorno;
    }
}
