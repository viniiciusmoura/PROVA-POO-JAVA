/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controles.AcoesListProdutos;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vinicius
 */
public class Produto {
    private String nome;
    private int stq;
    private double valor;

    public Produto(String nome, int stq, double valor) {
        this.nome = nome;
        this.stq = stq;
        this.valor = valor;
    }

    public Produto() {}

    public String getNome() {
        return nome;
    }

    public int getStq() {
        return stq;
    }

    public double getValor() {
        return valor;
    }

    public void setStq(int stq) {
        this.stq -= stq;
    }
    
    public String cadastrar(List<Produto> produtos){
        AcoesListProdutos alp = new AcoesListProdutos();
        return alp.inserir(produtos);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return true;
    }
    
    
    
}
