/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controles.AcoesListProdutos;
import Controles.AcoesListVendedores;
import static Principal.Iniciar.ler;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class Venda {
    private LocalDate data;
    private LocalTime hora;
    private Produto produto;
    private int qtd;
    private double totalVenda;
    private Vendedor vendedor;

    public Venda(LocalDate data, LocalTime hora, Produto produto, int qtd, double totalVenda, Vendedor vendedor) {
        this.data = data;
        this.hora = hora;
        this.produto = produto;
        this.qtd = qtd;
        this.totalVenda = totalVenda;
        this.vendedor = vendedor;
    }

    public Venda() {}

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public String toString() {
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("dd/MM/yyy");
        DateTimeFormatter sh = DateTimeFormatter.ofPattern("HH:mm");
        return "Vendedor: " + vendedor.getNome() + " =>\t Produto: "+ produto.getNome() +
                " =>\tQtd.:" + qtd + " => \t Total: "+ totalVenda +
                " =>\t Data: "+ data.format(sf) + " =>\t Hora: "+ hora.format(sh);
    }
    
    
    
    public void realizarVenda(List<Venda> vendas, List<Produto> produtos,List<Vendedor> vendedores){
        AcoesListProdutos alp = new AcoesListProdutos();
        AcoesListVendedores alv = new AcoesListVendedores();
        while(true){
            alp.lista(produtos);
            System.out.print("Produto(Nome): ");
            String nome = ler.next();
            Produto pr=alp.consultaProduto(produtos, new Produto(nome,0,0));
            if(pr!=null){
                while(true){
                    alv.lista(vendedores);
                    try{
                        System.out.print("Informe o código do vendedor: ");
                        int cod = ler.nextInt();
                        Vendedor ve = alv.consultaVendedor(vendedores,new Vendedor("",cod));
                        if(ve!=null){
                            while(true){
                                System.out.print("Qtd a ser vendida: ");
                                int qtd = ler.nextInt();
                                if(qtd<=pr.getStq()){
                                    vendas.add(new Venda(LocalDate.now(),LocalTime.now(),pr,qtd,pr.getValor()*qtd,ve));
                                    pr.setStq(qtd);
                                    System.out.println("\nProduto vendido com sucesso.");
                                    break;
                                }else
                                    System.out.println("\nValor informado superior ao estoque.");
                                    continue;
                                }
                            break;
                        }else{
                            System.out.println("\nInforme um código válido.");
                            continue;
                        }
                     
                    }catch(InputMismatchException ex){
                        System.out.println("\nInforme apenas números..");
                        ler.nextLine();
                        continue;
                    }
                }
                break;
            }else{
                System.out.println("\nProduto inexistente. Selecione um dos produtos da lista.");
                continue;
            }
        }
    
    }
    
    public void totalizarVendas(List<Venda> vendas){
        double total=0.0;
        for(Venda v: vendas){
            System.out.println(v);
            total += v.totalVenda;
        }
        System.out.println("Totais em venda: R$"+total);
    }
    
}
