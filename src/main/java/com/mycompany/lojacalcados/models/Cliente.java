package com.mycompany.lojacalcados.models;

import java.util.Date;


public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String endereco;
    private String sexo;
    private String estadoCivil;
    private String email;
    private String telefone;

    public Cliente(String nome, String cpf, Date nascimento, String endereco, String sexo, String estadoCivil, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getCpf()
    {
        return this.cpf;
    }
    
    public Date getNascimento()
    {
        return this.nascimento;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getTelefone()
    {
        return this.telefone;
    }
   
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setNascimento(Date nascimento)
    {
        this.nascimento = nascimento;
    }
     
     public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
      
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }
       
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    
}
