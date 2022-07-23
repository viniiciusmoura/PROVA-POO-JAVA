/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controles.AcoesListVendedores;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class Vendedor {
    private String nome;
    private int cod;

    public Vendedor(String nome, int cod) {
        this.nome = nome;
        this.cod = cod;
    }

    public Vendedor() {}

    public String getNome() {
        return nome;
    }

    public int getCod() {
        return cod;
    }
    
    public String cadastrar(List<Vendedor> vendedores){
        AcoesListVendedores alv = new AcoesListVendedores();
        return alv.inserir(vendedores);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.cod;
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
        final Vendedor other = (Vendedor) obj;
        return true;
    }
    
    
    
    
}
