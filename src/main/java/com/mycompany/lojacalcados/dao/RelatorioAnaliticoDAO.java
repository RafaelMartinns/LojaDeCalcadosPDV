package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.RelatorioAnalitico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RelatorioAnaliticoDAO {
    public static ArrayList<RelatorioAnalitico> listarItensPedido(int fkVenda){
        Connection conexao = null;
        ResultSet rs = null;
        ArrayList<RelatorioAnalitico> listaRetorno = new ArrayList<>();
        try {
            conexao = ConnectorDAO.AbrirConexao();
            
            String sql = "SELECT ITEM.IDITEMVENDA, PROD.NOMEPRODUTO, TAM.TAMANHO, ITEM.QTD, ITEM.PRECOUNIT  FROM ITEMVENDA ITEM " 
                    + "LEFT JOIN PRODUTO_TAMANHO TAM ON ITEM.FKPRODUTOTAMANHO = TAM.IDPRODUTO_TAMANHO "
                    + "LEFT JOIN PRODUTO PROD ON PROD.IDPRODUTO = TAM.FK_PRODUTO "
                    + "WHERE ITEM.FKVENDA = ?";
            
            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
           
            instrucaoSQL.setInt(1, fkVenda);
            rs = instrucaoSQL.executeQuery();
            
            if (rs!=null) {
                
                while (rs.next()) {                    
                    RelatorioAnalitico item = null;
                    int idItemVenda = rs.getInt("IDITEMVENDA");
                    String nomeProduto = rs.getString("NOMEPRODUTO");
                    int tamanho = rs.getInt("tamanho");
                    int qtd = rs.getInt("qtd");
                    double vlFinal = rs.getDouble("precounit");

                    item = new RelatorioAnalitico(idItemVenda, nomeProduto, tamanho, qtd, vlFinal);
                    listaRetorno.add(item);
                }
                
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            listaRetorno=null;
        } 
        
        return listaRetorno;
    }
}
