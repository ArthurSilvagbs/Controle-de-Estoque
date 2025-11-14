package Model;

public class Produto {

    private Integer id;
    private String nome;
    private Double precoUnitario;

    public Produto(Integer id, String nome, Double precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public Produto(Integer id, String nome) {
        this(id, nome, null);
    }

//    public Produto(String nome) {
//        this(null , nome, null, null);
//    }
//
//    public Produto(Integer id) {
//        this(id, null, null, null);
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}