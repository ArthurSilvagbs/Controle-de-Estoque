package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Estoque {

    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    public Estoque() {}

    public void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public boolean removerProduto(String nomeProduto) {

        boolean sucesso = false;
        Iterator<Produto> iterator = listaProdutos.iterator();

        while (iterator.hasNext()) {
            Produto p = iterator.next();

            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                iterator.remove();

                sucesso = true;

                return sucesso;
            }
        }

        return sucesso;
    }

    public Produto getProduto(String nome) {

        for (Produto p : listaProdutos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

}