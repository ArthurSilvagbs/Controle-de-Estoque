package View;

import Control.EstoqueController;
import Model.Estoque;
import Model.Produto;

import java.util.Scanner;

public class ControleDeEstoque {

    public static final Scanner sc = new Scanner(System.in);
    public static Estoque e = new Estoque();
    public static EstoqueController estoque = new EstoqueController(e);

    public static void main(String[] args) {

        menuPrincipal();

    }

    public static void menuPrincipal() {

        do {
            System.out.println("======================================================\n");
            System.out.println("================= CONTROLE DE ESTOQUE ================\n");
            System.out.println("======================================================\n");
            System.out.println("***** Selecione uma operação que deseja realizar *****\n");
            System.out.println("======================================================\n");
            System.out.print("""
                    |\s\s            [ 1 ] - MENU ADMINISTRADOR           \s\s|
                    |\s\s            [ 2 ] - MENU USUÁRIO                 \s\s|
                    |\s\s            [ 3 ] - SAIR DO PROGRAMA             \s\s|
                    
                    Selecione um opção:\s""");

            int opcaoMenuPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenuPrincipal) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 3:
                    System.out.println("Finalizando o programa. Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    menuPrincipal();
            }
        } while (true);
    }

    public static void menuAdministrador() {

        do{
            System.out.println("======================================================\n");
            System.out.println("================= MENU ADMINISTRADOR =================\n");
            System.out.println("======================================================\n");
            System.out.println("***** Selecione uma operação que deseja realizar *****\n");
            System.out.println("======================================================\n");
            System.out.println("""
                |\s\s [ 1 ] - CADASTRAR NOVO PRODUTO NO SISTEMA       \s\s|
                |\s\s [ 2 ] - REMOVER UM PRODUTO EXISTENTE NO SISTEMA \s\s|
                |\s\s [ 3 ] - DAR ENTRADA À UM PRODUTO NO SISTEMA     \s\s|
                |\s\s [ 4 ] - DAR BAIXA EM UM PRODUTO NO ESTOQUE      \s\s|
                |\s\s [ 5 ] - CONSULTAR UM PRODUTO                    \s\s|
                |\s\s [ 6 ] - VER TODOS OS PRODUTOS DO ESTOQUE        \s\s|
                |\s\s [ 7 ] - VOLTAR AO MENU PRINCIPAL                \s\s|
                """);

            int opcaoMenuAdministrador = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenuAdministrador) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    darEntradaProduto();
                    break;
                case 4:
                    darBaixaProduto();
                    break;
                case 5:
                    consultarProduto();
                    break;
                case 6:
                    verListaProdutos();
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (true);

    }

    public static void menuUsuario() {
        do {
            System.out.println("======================================================\n");
            System.out.println("==================== MENU USUARIO ====================\n");
            System.out.println("======================================================\n");
            System.out.println("***** Selecione uma operação que deseja realizar *****\n");
            System.out.println("======================================================\n");
            System.out.println("""
                |\s\s [ 1 ] - DAR ENTRADA À UM PRODUTO NO SISTEMA     \s\s|
                |\s\s [ 2 ] - DAR BAIXA EM UM PRODUTO NO ESTOQUE      \s\s|
                |\s\s [ 3 ] - CONSULTAR UM PRODUTO                    \s\s|
                |\s\s [ 4 ] - VER TODOS OS PRODUTOS DO ESTOQUE        \s\s|
                |\s\s [ 5 ] - VOLTAR AO MENU PRINCIPAL                \s\s|
                """);

            int opcaoMenuUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenuUsuario) {
                case 1:
                    darEntradaProduto();
                    break;
                case 2:
                    darBaixaProduto();
                    break;
                case 3:
                    consultarProduto();
                    break;
                case 4:
                    verListaProdutos();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (true);
    }

    public static void cadastrarProduto() {
        do {
            System.out.println("\nCADASTRAR PRODUTO");

            System.out.print("NOME do produto: ");
            String nome = sc.nextLine();

            System.out.print("PREÇO UNITÁRIO do produto: ");
            double precoUnitario = sc.nextDouble();
            sc.nextLine();

            estoque.cadastrarNovoProduto(nome, precoUnitario);

            System.out.println("\nProduto cadastrado com sucesso!\n");

            System.out.println("""
                    CADASTRAR UM NOVO PRODUTO?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoConfirmacao = sc.nextInt();
            sc.nextLine();

            switch (opcaoConfirmacao) {
                case 1:
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(true);
    }

    public static void removerProduto() {
        do {
            System.out.println("\nREMOVER PRODUTO");

            System.out.print("\nNOME do produto: ");
            String nomeProduto = sc.nextLine();

            Produto p = estoque.BuscarProduto(nomeProduto);

            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Produto não encontrado!");
                System.out.println("\nVerifique se o NOME ou o ID foram digitados corretamente.");
                continue;
            }

            System.out.println("Confirma que é esse produto?");
            System.out.println("""
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoConfirmacao = sc.nextInt();
            sc.nextLine();

            switch (opcaoConfirmacao) {
                case 1:
                    boolean validacao = estoque.removerProduto(nomeProduto);

                    if (validacao) {
                        System.out.println("PRODUTO REMOVID0");
                    }else {
                        System.out.println("Erro ao removerproduto!");
                    }
                    break;

                case 2:
                    continue;

                default:
                    System.out.println("Opção inválida!");

            }

            System.out.print("""
                    \n
                    REMOVER UM OUTRO PRODUTO?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoRemoverOutroProduto = sc.nextInt();
            sc.nextLine();

            switch (opcaoRemoverOutroProduto) {
                case 1:
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (true);
    }

    public static void darEntradaProduto() {
        do {
            System.out.println("DAR ENTRADA EM UM PRODUTO NO ESTOQUE");
            System.out.println("""
                    Pesquisa de produto (ID ou NOME):
                    
                    Digite aqui:\s""");

            String identificador = sc.nextLine();

            Produto p = estoque.BuscarProduto(identificador);

            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Produto não encontrado!");
                System.out.println("\nVerifique se o NOME ou o ID foram digitados corretamente.");
                continue;
            }

            System.out.println("Confirma que é esse produto?");
            System.out.println("""
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoConfirmacao = sc.nextInt();
            sc.nextLine();

            switch (opcaoConfirmacao) {
                case 1:

                    System.out.print("Quantidade a entrar no estoque: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    if (estoque.darEntradaNoEstoque(identificador, quantidade)) {
                        System.out.println("Entrada feita com sucesso!");
                    } else {
                        System.out.println("Erro na entrada!");
                    }

                    break;

                case 2:
                    continue;

                default:
                    System.out.println("Opção inválida!");

            }

            System.out.println();

            System.out.print("""
                    \n
                    DAR ENTRADA EM UM OUTRO PRODUTO?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoDarEntradaOutroProduto = sc.nextInt();
            sc.nextLine();

            switch (opcaoDarEntradaOutroProduto) {
                case 1:
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (true);
    }

    public static void darBaixaProduto() {
        do {
            System.out.println("DAR BAIXA EM UM PRODUTO NO ESTOQUE");
            System.out.println("""
                    Pesquisa de produto (ID ou NOME):
                    
                    Digite aqui:\s""");

            String identificador = sc.nextLine();

            Produto p = estoque.BuscarProduto(identificador);

            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Produto não encontrado!");
                System.out.println("\nVerifique se o NOME ou o ID foram digitados corretamente.");
                continue;
            }

            System.out.println("Confirma que é esse produto?");
            System.out.println("""
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoConfirmacao = sc.nextInt();
            sc.nextLine();

            switch (opcaoConfirmacao) {
                case 1:

                    System.out.print("Quantidade a sair no estoque: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    if (quantidade > p.getQuantidade()) {
                        System.out.println("Estoque insuficiente para retirada!");
                        continue;
                    } else {
                        if (estoque.darBaixaNoEstoque(identificador, quantidade)) {
                            System.out.println("Baixa feita com sucesso!");
                        } else {
                            System.out.println("Erro na saida!");
                            continue;
                        }
                    }
                    break;

                case 2:
                    continue;

                default:
                    System.out.println("Opção inválida!");

            }

            System.out.println();

            System.out.print("""
                    \n
                    DAR BAIXA EM UM OUTRO PRODUTO?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoDarEntradaOutroProduto = sc.nextInt();
            sc.nextLine();

            switch (opcaoDarEntradaOutroProduto) {
                case 1:
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (true);
    }

    public static void consultarProduto() {
        do {
            System.out.println("CONSULTAR PRODUTO");
            System.out.println("""
                    Pesquisa de produto (ID ou NOME):
                    
                    Digite aqui:\s""");
            String identificador = sc.nextLine();

            Produto p = estoque.BuscarProduto(identificador);

            if (p != null) {
                System.out.println(p.produtoFormatado());
            } else {
                System.out.println("Produto não encontrado!");
                System.out.println("\nVerifique se o NOME ou o ID foram digitados corretamente.");
                continue;
            }

            System.out.println("""
                    Consultar outro produto?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
            int opcaoConsultarOutroProduto = sc.nextInt();
            sc.nextLine();

            switch (opcaoConsultarOutroProduto) {
                case 1:
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (true);

    }

    public static void verListaProdutos(){

        for (Produto p : estoque.obterListaCompleta()) {
            System.out.println(p.produtoFormatadoConsulta());
        }
    }

}
