package com.mycompany.lojacalcados.models;

public class VendaItem {
    private int id;
    private int fkVenda;
    private int fkProdutoTamanho;
    private int tamanho;
    private int fkProduto;
    private int qtd;    
    private double precoUnit;

    public VendaItem(int fkVenda, int fkProdutoTamanho, int qtd, double precoUnit) {
        this.fkVenda = fkVenda;
        this.fkProdutoTamanho = fkProdutoTamanho;
        this.qtd = qtd;
        this.precoUnit = precoUnit;
    }

    
    public int getId()
    {
        return this.id;
    }
    
    public int getFkVenda()
    {
        return this.fkVenda;
    }
    
    public int getFkProdutoTamanho()
    {
        return this.fkProdutoTamanho;
    }
    
    public int getTamanho()
    {
        return this.tamanho;
    }
    
    public int getFkProduto()
    {
        return this.fkProduto;
    }
    
    public int getQtd()
    {
        return this.qtd;
    }
    
    public double getPrecoUnit()
    {
        return this.precoUnit;
    }
   
    public void setFkVenda(int fkVenda)
    {
        this.fkVenda = fkVenda;
    }
    
    public void setFkProdutoTamanho(int fkProdutoTamanho)
    {
        this.fkProdutoTamanho = fkProdutoTamanho;
    }
    
    public void setTamanho(int tamanho)
    {
        this.tamanho = tamanho;
    }
    
    public void setFkProduto(int fkProduto)
    {
        this.fkProduto = fkProduto;
    }
     
    public void setQtd(int qtd)
    {
        this.qtd = qtd;
    }
    
    public void setPrecoUnit(double precoUnit)
    {
        this.precoUnit = precoUnit;
    }
}
