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
}