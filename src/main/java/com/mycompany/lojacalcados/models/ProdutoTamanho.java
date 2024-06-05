package com.mycompany.lojacalcados.models;

public class ProdutoTamanho {
    private int id;
    private int fkProduto;
    private int tamanho;
    private int quantidade;

    public ProdutoTamanho(int fkProduto, int tamanho, int quantidade) {
        this.fkProduto = fkProduto;
        this.tamanho = tamanho;        
        this.quantidade = quantidade;
    }
    
    public ProdutoTamanho(int id, int fkProduto, int tamanho, int quantidade) {
        this.id = id;
        this.fkProduto = fkProduto;
        this.tamanho = tamanho;        
        this.quantidade = quantidade;
    }

    
    public int getId() {
        return id;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
