package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    public Estoque() {}

    public void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public void removerProduto(Produto produto, int idDigitado) {
        for(Produto p : listaProdutos) {
            int idCopia = p.getId();
            if (idCopia == idDigitado) {
                listaProdutos.remove(produto);
            }
        }
    }


}
