/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Modelo.Vendedor;
import static Principal.Iniciar.cod;
import static Principal.Iniciar.ler;
import java.util.List;

/**
 *
 * @author Vinícius Moura
 */
public class AcoesListVendedores {
    Vendedor v;
     public void entrada() {
  
        System.out.print("Nome do vendedor: ");
        String nome = ler.next();
        v=new Vendedor(nome,cod);   
    }
       


    public String inserir(List<Vendedor> vendedores) {
        entrada();
        if(vendedores.add(v)){
            cod++;
            return "\nVendedor cadastrado com sucesso.";
        }else
            return "\nErro ao cadastrar Vendedor.";
    }
    
    public void lista(List<Vendedor> vendedores) {
        for(Vendedor p: vendedores){
            System.out.println(p.getCod() + " - "+ p.getNome());
        } 
    }
    public Vendedor consultaVendedor(List<Vendedor> vendedores,Vendedor ven) {
        for(Vendedor v: vendedores){
            if(v.hashCode()==ven.hashCode())
                return v;
        } 
        return null;
    }
}
