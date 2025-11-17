package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Estoque {

    private final ArrayList<Produto> listaProdutos = new ArrayList<>();

    public Estoque() {}

    public void salvarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public void removerProduto(String nomeProduto) {

        Iterator<Produto> iterator = listaProdutos.iterator();

        while (iterator.hasNext()) {
            Produto p = iterator.next();

            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                iterator.remove();

                return;
            }
        }
    }

    public Produto acharProdutoNaLista(String identificador) {
          for (Produto produto: listaProdutos) {

              String idTemporario = String.valueOf(produto.getId());

              if (listaProdutos.size() > 0) {
                  if (identificador.equalsIgnoreCase(produto.getNome()) || identificador.equalsIgnoreCase(idTemporario)) {
                      return produto;
                  }
              } else {
                  break;
              }
          }

          return null;
    }

    public ArrayList<Produto> listarTodosOsProdutos() {
        return listaProdutos;
    }

}