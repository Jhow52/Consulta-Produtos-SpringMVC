/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.loja.model;
import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
 
    public Produto() {
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public BigDecimal getPreco() {
        return preco;
    }
 
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
