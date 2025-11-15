package View;

import Control.EstoqueController;
import Model.Estoque;

import java.util.Scanner;

public class SistemaControleDeEstoque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Estoque e = new Estoque();
        EstoqueController estoque = new EstoqueController(e);

        boolean programaLigado = true;

        do {
            int opcao = menu(sc);

            switch (opcao) {
                case 1:
                    System.out.print(""" 
                            =-=-=-=-=-=-=-=-  MENU ADMINISTRADOR -=-=-=-=-=-=-=-=
                            
                            [ 1 ] CADASTRAR NOVO PRODUTO NO SISTEMA
                            [ 2 ] REMOVER UM PRODUTO EXISTENTE NO SISTEMA
                            [ 3 ] DAR ENTRADA À PRODUTO AO ESTOQUE
                            [ 4 ] DAR BAIXA EM UM PRODUTO NO ESTOQUE
                            [ 5 ] CONSULTAR UM PRODUTO
                            [ 6 ] VER TODOS OS PRODUTOS DO ESTOQUE
                            [ 7 ] VOLTAR AO MENU PRINCIPAL
                            
                            Selecione um opção:\s""");
                    int opcaoMenuAdm = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoMenuAdm) {

                        case 1:
                            int opcaoCadastrarNovoProduto;

                            do {
                                System.out.println("\nCADASTRAR PRODUTO");

                                System.out.print("\nID do produto: ");
                                int id = sc.nextInt();
                                sc.nextLine();

                                System.out.print("NOME do produto: ");
                                String nome = sc.nextLine();

                                System.out.print("PREÇO UNITÁRIO do produto: ");
                                double precoUnitario = sc.nextDouble();


                                estoque.cadastrarNovoProduto(id, nome, precoUnitario);

                                System.out.print("""
                                    \n
                                    CADASTRAR UM NOVO PRODUTO?
                                    
                                    [ 1 ] SIM
                                    [ 2 ] NÃO
                                    
                                    Selecione uma opção:\s""");
                                opcaoCadastrarNovoProduto = sc.nextInt();
                                sc.nextLine();
                            } while (opcaoCadastrarNovoProduto == 1);

                            break;

                        case 2:
                            int opcaoRemoverProduto;

                            do {
                                System.out.println("\nREMOVER PRODUTO");

                                System.out.print("\nNOME do produto: ");
                                String nomeProduto = sc.nextLine();

                                System.out.println("Confirma que é esse produto?");
                                System.out.println("""
                                            [ 1 ] SIM
                                            [ 2 ] NÃO
                                            
                                            Selecione uma opção:\s""");
                                int opcaoConfirmacao = sc.nextInt();
                                sc.nextLine();

                                while (opcaoConfirmacao < 1 || opcaoConfirmacao > 2) {
                                    System.out.println("Opção Inválida! Tente novamente");

                                    System.out.println("\nConfirma que é esse produto?");
                                    System.out.println("""
                                            [ 1 ] SIM
                                            [ 2 ] NÃO
                                            
                                            Selecione uma opção:\s""");
                                    opcaoConfirmacao = sc.nextInt();
                                    sc.nextLine();
                                }

                                if (opcaoConfirmacao == 1) {
                                    boolean validacao = estoque.removerProduto(nomeProduto);

                                    if (validacao) {
                                        System.out.println("PRODUTO REMOVID0");
                                    }else {
                                        System.out.println("Erro!");
                                    }

                                }

                                System.out.print("""
                                    \n
                                    REMOVER UM OUTRO PRODUTO?
                                    
                                    [ 1 ] SIM
                                    [ 2 ] NÃO
                                    
                                    Selecione uma opção:\s""");
                                opcaoRemoverProduto = sc.nextInt();
                                sc.nextLine();

                                while (opcaoRemoverProduto < 1 || opcaoRemoverProduto > 2) {
                                    System.out.println("Opção Inválida! Tente novamente");

                                    System.out.print("""
                                    \n
                                    REMOVER UM OUTRO PRODUTO?
                                    
                                    [ 1 ] SIM
                                    [ 2 ] NÃO
                                    
                                    Selecione uma opção:\s""");
                                    opcaoRemoverProduto = sc.nextInt();
                                    sc.nextLine();
                                }


                            } while (opcaoRemoverProduto == 1);

                            break;
                    }

                    break;

                case 2:
                    System.out.print("""
                            =-=-=-=-=-=-=-=-      MENU USER      -=-=-=-=-=-=-=-=
                            
                            [ 1 ] DAR ENTRADA À PRODUTO AO ESTOQUE
                            [ 2 ] DAR BAIXA EM UM PRODUTO NO ESTOQUE
                            [ 3 ] CONSULTAR UM PRODUTO
                            [ 4 ] VER TODOS OS PRODUTOS DO ESTOQUE
                            [ 5 ] VOLTAR AO MENU PRINCIPAL
                            
                            Selecione um opção:\s""");
                    int opcaoMenuUser = sc.nextInt();
                    sc.nextLine();

                    break;
                case 3:
                    programaLigado = false;
                    break;

            }

        } while (programaLigado);

        sc.close();

    }

    private static int menu(Scanner sc){

        System.out.println("=-=-=-=-=-=-=-=-    SEJA BEM VINDO   -=-=-=-=-=-=-=-=");
        System.out.println("=-=-=-=-=-=-=-=- CONTROLE DE ESTOQUE -=-=-=-=-=-=-=-=");

        System.out.println("\n=-=-=-=-=-=-=-=-        LOGIN        -=-=-=-=-=-=-=-=");
        System.out.print("""
                \n[ 1 ] ADMINISTRADOR
                [ 2 ] USER
                [ 3 ] SAIR DO PROGRAMA
                
                Selecione uma opção:\s""");

        return sc.nextInt();

    }

}