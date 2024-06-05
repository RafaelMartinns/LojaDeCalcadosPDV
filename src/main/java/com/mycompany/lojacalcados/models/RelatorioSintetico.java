package com.mycompany.lojacalcados.models;

import java.util.Date;


public class RelatorioSintetico {
    private int idVenda;
    private Date dhPedido;
    private int fk_Cliente;
    private String nomeCliente;
    private float vlFinal;

    public RelatorioSintetico(int idVenda, Date dhPedido, int fk_Cliente, String nomeCliente, float vlFinal) {
        this.idVenda = idVenda;
        this.dhPedido = dhPedido;
        this.fk_Cliente = fk_Cliente;
        this.nomeCliente = nomeCliente;
        this.vlFinal = vlFinal;
    }

    
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDhPedido() {
        return dhPedido;
    }

    public void setDhPedido(Date dhPedido) {
        this.dhPedido = dhPedido;
    }

    public int getFk_Cliente() {
        return fk_Cliente;
    }

    public void setFk_Cliente(int fk_Cliente) {
        this.fk_Cliente = fk_Cliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getVlFinal() {
        return vlFinal;
    }

    public void setVlFinal(float vlFinal) {
        this.vlFinal = vlFinal;
    }
    
    
}
