package com.mycompany.lojacalcados.models;

import java.time.LocalDateTime;

public class Venda {
    private int id;
    private int fkCliente;
    private double vlFinal;    
    private LocalDateTime dhPedido;


    public Venda(int fkCliente, double vlFinal, LocalDateTime dhPedido) {
        this.fkCliente = fkCliente;
        this.vlFinal = vlFinal;
        this.dhPedido = dhPedido;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public int getFkCliente()
    {
        return this.fkCliente;
    }
    
    public double getVlFinal()
    {
        return this.vlFinal;
    }
    
    public LocalDateTime getDhPedido()
    {
        return this.dhPedido;
    }
   
    public void setFkCliente(int fkCliente)
    {
        this.fkCliente = fkCliente;
    }
    
    public void setFkProdutoTamanho(double vlFinal)
    {
        this.vlFinal = vlFinal;
    }
    
    public void setDhPedido(LocalDateTime dhPedido)
    {
        this.dhPedido = dhPedido;
    }
     
}
