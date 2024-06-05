/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.VendaItem;
import java.sql.PreparedStatement;

public class VendaItemDAO {
    public static boolean adicionar(VendaItem vendaItem){
        
        boolean isSucessoRetorno = false;
        
        try {
            
            var conexao = ConnectorDAO.AbrirConexao();
            PreparedStatement instrucaoSQL = conexao.prepareStatement(
                     "INSERT INTO ItemVenda (fkVenda, fkProdutoTamanho, qtd, precoUnit) VALUES (?,?,?,?)"
            );
            
            instrucaoSQL.setInt(1,vendaItem.getFkVenda());
            instrucaoSQL.setInt(2,vendaItem.getFkProdutoTamanho());
            instrucaoSQL.setInt(3, vendaItem.getQtd());
            instrucaoSQL.setDouble(4, vendaItem.getPrecoUnit());
            
            int linhasAlteradas =  instrucaoSQL.executeUpdate();
            
            if (linhasAlteradas > 0){                    
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            ConnectorDAO.FecharConexao();   
        }
        
        return isSucessoRetorno;
    }
}
