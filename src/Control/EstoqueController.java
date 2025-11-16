package Control;

import Model.Estoque;
import Model.Produto;

public class EstoqueController {

    private final Estoque estoque;

    public EstoqueController(Estoque estoque) {
        this.estoque = estoque;
    }

    public void cadastrarNovoProduto(String nome, double precoUnitario) {
        this.estoque.salvarProduto(new Produto(nome, precoUnitario));
    }

    public boolean removerProduto(String nomeProduto) {
        this.estoque.removerProduto(nomeProduto);
        return true;
    }

    public void imprimirProduto(String nomeproduto) {
        this.estoque.getProduto(nomeproduto);
    }
}