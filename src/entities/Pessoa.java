package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private Integer id;
    private String nome;
    private Integer idade;
    private String endereco;
    private LocalDateTime dataCadasto;
    private LocalDateTime dataEdicao;

    public Pessoa(Integer id, String nome, Integer idade, String endereco, LocalDateTime data) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.dataCadasto = data;
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

    public LocalDateTime getDataCadasto() {
        return dataCadasto;
    }

    public void editarDados(String novoNome, int novaIdade, String novoEndereco) {
        this.nome = novoNome;
        this.idade = novaIdade;
        this.endereco = novoEndereco;
        this.dataEdicao = LocalDateTime.now();
    }
    public String getInfoEdicao() {
        return dataEdicao == null ? "Dados originais de cadastro" : "Data da ultima edição: " + dataEdicao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public String toString() {
        String nl = System.lineSeparator();

        return  "------------------------" + nl +
                "Id: " + id + nl +
                "Nome: " + nome + nl +
                "Idade: " + idade +  nl +
                "Endereço: " + endereco +  nl +
                "Data de cadastro: " + dataCadasto.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + nl +
                getInfoEdicao();
    }
}
