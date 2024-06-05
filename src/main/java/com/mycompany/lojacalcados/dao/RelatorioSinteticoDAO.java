package com.mycompany.lojacalcados.dao;

import com.mycompany.lojacalcados.models.RelatorioSintetico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class RelatorioSinteticoDAO {
    
    public static ArrayList<RelatorioSintetico> listarPorPeriodo(Date dtInicio, Date dtTermino){
        Connection conexao = null;
        ResultSet rs = null;
        ArrayList<RelatorioSintetico> listaRetorno = new ArrayList<>();
        try {
            conexao = ConnectorDAO.AbrirConexao();
            String sql = "SELECT venda.idVenda, venda.fk_cliente,cliente.nomeCliente,venda.vlFinal,venda.dhPedido FROM venda "
                    + "INNER JOIN cliente ON venda.fk_cliente = cliente.idCliente"
                    + " WHERE dhpedido BETWEEN ? AND ? ";
            PreparedStatement instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setDate(1, new java.sql.Date(dtInicio.getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(dtTermino.getTime()));
            rs = instrucaoSQL.executeQuery();
            if (rs!=null) {
                
                while (rs.next()) {                    
                    RelatorioSintetico item = null;
                    int idVenda = rs.getInt("idVenda");
                    int fk_cliente = rs.getInt("fk_cliente");
                    String nomeCliente = rs.getString("nomeCliente");
                    Date dhPedido = rs.getDate("dhPedido");
                    float vlFinal = rs.getFloat("vlFinal");

                    item = new RelatorioSintetico(idVenda, dhPedido, fk_cliente, nomeCliente, vlFinal);
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
