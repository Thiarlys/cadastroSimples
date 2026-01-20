package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private Integer id;
    private String nome;
    private Integer idade;
    private String endereco;
    private LocalDateTime dataModificacao;

    public Pessoa(Integer id, String nome, Integer idade, String endereco, LocalDateTime data) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.dataModificacao = data;
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

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void editarDados(String novoNome, int novaIdade, String novoEndereco) {
        this.nome = novoNome;
        this.idade = novaIdade;
        this.endereco = novoEndereco;
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String nl = System.lineSeparator();

        return  "------------------------" + nl +
                "Id: " + id + nl +
                "nome: " + nome + nl +
                "idade: " + idade +  nl +
                "endereço: " + endereco +  nl +
                "ultima modificação: " + dataModificacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

    }
}
