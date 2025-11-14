package Control;

import Model.Estoque;
import Model.Produto;

public class EstoqueController {

    private Estoque estoque;

    public EstoqueController(Estoque estoque) {
        this.estoque = estoque;
    }

    public void cadastrarNovoProduto(int id, String nome, double precoUnitario) {

        this.estoque.salvarProduto(new Produto(id, nome, precoUnitario));
    }

    public void removerProduto(String nomeProduto) {
        this.estoque.removerProduto(nomeProduto);
    }

    public void imprimirProduto(String nomeproduto) {
        this.estoque.getProduto(nomeproduto);
    }
}