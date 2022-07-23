/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

import Modelo.Produto;
import static Principal.Iniciar.ler;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author Vinícius Moura
 */
public class AcoesListProdutos {
    Produto p;
    
    public void entrada() {
        while(true){
            try{
                System.out.print("Nome: ");
                String nome = ler.next();
                System.out.print("Quantidade: ");
                int qtd = ler.nextInt();
                System.out.print("Preço: ");
                double preco = ler.nextDouble();
                p=new Produto(nome,qtd,preco);
                break;
            }catch(InputMismatchException ex){
                System.out.println("Digite apenas número na QUANTIDADE e PREÇO.");
                ler.nextLine();
                continue;
            }
        }
        
    }


    public String inserir(List<Produto> lista) {
        entrada();
        if(lista.add(p))
            return "\nProduto cadastrado com sucesso.";
        else
            return "\nErro ao cadastrar produto.";
    }


    public void lista(List<Produto> produtos) {
        int i =1;
        for(Produto p: produtos){
            System.out.println(i + " - "+ p.getNome() + "     => Qtd: "+p.getStq()+"     => Preço: R$"+p.getValor());
            i++;
        } 
    }

   
    public Produto consultaProduto(List<Produto> produtos,Produto pro) {
        for(Produto p: produtos){
            if(p.hashCode()==pro.hashCode())
                return p;
        } 
        return null;
    }
    
}
