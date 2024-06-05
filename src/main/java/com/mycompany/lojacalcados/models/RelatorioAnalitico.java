package com.mycompany.lojacalcados.models;


public class RelatorioAnalitico {
    private int idItem;
    private String nomeProduto;
    private int tamanho;
    private int qtd;
    private double total;

    public RelatorioAnalitico(int idItem, String nomeProduto, int tamanho, int qtd, double total) {
        this.idItem = idItem;
        this.nomeProduto = nomeProduto;
        this.tamanho = tamanho;
        this.qtd = qtd;
        this.total = total;
    }

    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int id) {
        this.idItem = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
