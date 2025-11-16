package Model;

public class Produto {

    private static int contadorId = 1;

    private Integer id;
    private String nome;
    private Double precoUnitario;
    private int quantidade;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
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
}