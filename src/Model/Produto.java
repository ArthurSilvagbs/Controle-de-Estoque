package Model;

public class Produto {

    private static int contadorId = 1;

    private final Integer id;
    private final String nome;
    private final Double precoUnitario;
    private int quantidade = 0;

    public Produto(String nome, Double precoUnitario) {
        this.id = contadorId;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        contadorId += 1;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | NOME: %s | PREÇO UNITARIO: R$ %.2f", id, nome, precoUnitario);
    }

    public String produtoFormatado() {
        return String.format("""
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
                    | ID: %d
                    | NOME: %s
                    | PREÇO UNITÁRIO: R$ %.2f
                    | QUANTIDADE EM ESTOQUE: %d und
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-""", getId(), getNome(), getPrecoUnitario(), getQuantidade());
    }

    public String produtoFormatadoConsulta() {
        return String.format("""
                    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
                    ***   PRODUTO   ***
                    | ID: %d
                    | NOME: %s
                    | PREÇO UNITÁRIO: R$ %.2f
                    | QUANTIDADE EM ESTOQUE: %d und
                    | VALOR EM ESTOQUE (R$): R$ %.2f""",getId(), getNome(), getPrecoUnitario(), getQuantidade(), getQuantidade() * getPrecoUnitario());
    }
}