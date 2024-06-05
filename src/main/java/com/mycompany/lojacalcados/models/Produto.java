package com.mycompany.lojacalcados.models;

public class Produto {
    private int id;
    private String nome;
    private String marca;    
    private String sexo;
    private double preco;

    public Produto(int id, String nome, String marca, double preco, String sexo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;        
        this.sexo = sexo;
    }
    
    public Produto(String nome, String marca, double preco, String sexo) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.sexo = sexo;

    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getMarca()
    {
        return this.marca;
    }
    
    public String getSexo()
    {
        return this.sexo;
    }
    
    public double getPreco()
    {
        return this.preco;
    }
   
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setNome(String titulo)
    {
        this.nome = titulo;
    }
     
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }
      
    public void setPreco(double preco)
    {
        this.preco = preco;
    }

}
