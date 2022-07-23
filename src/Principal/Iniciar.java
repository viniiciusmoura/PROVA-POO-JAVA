/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Modelo.Produto;
import Modelo.Venda;
import Modelo.Vendedor;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vinicius
 */
public class Iniciar {
    public static Scanner ler = new Scanner(System.in);
    public static int cod=100;
    static List<Produto> produtos = new ArrayList();
    static List<Vendedor> vendedores = new ArrayList();
    static List<Venda> vendas = new ArrayList();
    
    public static void menu(){
        System.out.print("========== MENU ==========\n"
                + "1 - Realizar Venda\n"
                + "2 - Cadastrar Produto\n"
                + "3 - Cadastrar Vendedor\n"
                + "4 - Totalizar Vendas do dia\n"
                + "5 - Sair do Programa\n"
                + "Opção: ");
    }
    
    public static int validaMenu(){
        int opcao;
        while(true){
            menu();
            try{
                opcao=ler.nextInt();
                if(opcao<1||opcao>5){
                    System.out.println("\nDigite um número entre 1 e 5");
                    continue;
                }
                return opcao;
            }catch(InputMismatchException ex){
                System.out.println("\nDigite apenas números");
                ler.nextLine();
                continue;
            }
           
        }
    }
    
    
    public static String verificaLista(List<?> listaP,List<?> listaV ,Class<?> Prod, Class<?> Vend){
        if(listaP.isEmpty()&&Produto.class.isAssignableFrom(Prod))
            return "Não existe nenhum produto cadastrado para venda!";
        else if(listaV.isEmpty()&&Vendedor.class.isAssignableFrom(Vend))
            return "Não existe nenhum vendedor cadastrado!";
        else
            return "";
    }
    
    public static void main(String [] args){
        Produto p = new Produto();
        Vendedor v = new Vendedor();
        Venda vend = new Venda();
        while(true){
            switch(validaMenu()){
                case 1:
                    if(verificaLista(produtos,vendedores,Produto.class,Vendedor.class)!="")
                        System.out.println("\n-->"+verificaLista(produtos,vendedores,Produto.class,Vendedor.class));
                    else
                        vend.realizarVenda(vendas, produtos, vendedores);
                    break;
                case 2:
                    System.out.println(p.cadastrar(produtos));
                    break;
                case 3:
                    System.out.println(v.cadastrar(vendedores));
                    break;
                case 4:
                    vend.totalizarVendas(vendas);
                    break;
                case 5:
                    System.out.println("Até logo");
                    System.exit(0);
                    break;
            }
        }
        
    }
}
