package View;

import Control.EstoqueController;
import Model.Estoque;
import Model.Produto;

import java.util.Scanner;

public class SistemaControleDeEstoque {

    static void main() {

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
                            [ 5 ] VOLTAR AO MENU PRINCIPAL
                            
                            Selecione um opção:\s""");
                    int opcaoMenuAdm = sc.nextInt();

                    switch (opcaoMenuAdm) {

                        case 1:
                            System.out.println("CADASTRAR PRODUTO");

                            System.out.print("\nID do produto: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("NOME do produto: ");
                            String nome = sc.nextLine();

                            System.out.print("PREÇO UNITÁRIO do produto: ");
                            double precoUnitario = sc.nextDouble();

                            estoque.cadastrarNovoProduto(id, nome, precoUnitario);

                            System.out.printf("""
                                    \nDADOS DO PRODUTO CADASTRADO:
                                    ID: %d | NOME: %s | PREÇO UNITÁRIO: R$ %.2f""", id, nome.toLowerCase(), precoUnitario);
                            System.out.print("""
                                    CADASTRAR UM NOVO PRODUTO?
                                    
                                    [ 1 ] SIM
                                    [ 2 ] NÃO
                                    
                                    Selecione uma opção:\s""");
                            int opcaoCadastrarNovoProduto = sc.nextInt();

                            break;
                    }

                    break;

                case 2:
                    System.out.print("""
                            =-=-=-=-=-=-=-=-      MENU USER      -=-=-=-=-=-=-=-=
                            
                            [ 1 ] DAR ENTRADA À PRODUTO AO ESTOQUE
                            [ 2 ] DAR BAIXA EM UM PRODUTO NO ESTOQUE
                            [ 3 ] VOLTAR AO MENU PRINCIPAL
                            
                            Selecione um opção:\s""");
                    int opcaoMenuUser = sc.nextInt();

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