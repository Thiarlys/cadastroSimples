package entities;

public class Pessoa {
    private Integer id;
    private String nome;
    private Integer idade;
    private String endereco;

    public Pessoa(Integer id, String nome, Integer idade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco() {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", nome: " + nome + ", idade: " + idade + ", endereço: " + endereco;
    }
}
