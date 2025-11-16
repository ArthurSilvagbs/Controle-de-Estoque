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

    public Produto BuscarProduto(String nome) {
        return this.estoque.acharProdutoNaLista(nome);
    }

    public boolean darEntradaNoEstoque(String identificador, int quantidade) {
        Produto p = this.estoque.acharProdutoNaLista(identificador);
        if (p != null) {
            p.setQuantidade(p.getQuantidade() + quantidade);
            return true;
        } else {
            return false;
        }
    }

    public boolean darBaixaNoEstoque(String identificador, int quantidade) {
        Produto p = this.estoque.acharProdutoNaLista(identificador);
        if (p != null) {
            p.setQuantidade(p.getQuantidade() - quantidade);
            return true;
        } else {
            return false;
        }
    }
}