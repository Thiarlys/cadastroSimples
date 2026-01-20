package program;

import entities.Pessoa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("---------------");
            System.out.println("Digite a ação desejada: ");
            System.out.println("1 - Cadastrar novo usuário. ");
            System.out.println("2 - Editar cadastro de usuário. ");
            System.out.println("3 - Excluir usuário. ");
            System.out.println("4 - Exibir todos usuários. ");
            System.out.println("5 - Sair. ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Id do usuário: ");
                    int id = sc.nextInt();

                    System.out.println("Digite o nome do usuário: ");
                    sc.nextLine();
                    String nome = sc.nextLine();

                    System.out.println("Digite a idade do usuário: ");
                    int idade = sc.nextInt();

                    System.out.println("Digite o endereço do usuário: ");
                    sc.nextLine();
                    String endereco = sc.nextLine();

                    LocalDateTime data = LocalDateTime.now();

                    pessoas.add(new Pessoa(id,nome,idade,endereco,data));
                    break;
                case 2:
                    boolean editado = false;

                    System.out.println("Digite o ID do usuário que deseja fazer a edição: ");
                    int idEditar = sc.nextInt();
                    for (int i = 0; i < pessoas.size(); i++) {
                        Integer idPessoa = pessoas.get(i).getId();
                        if (idPessoa != null && idPessoa.equals(idEditar)) {
                            System.out.println("Digite o novo nome: ");
                            sc.nextLine();
                            String novoNome = sc.nextLine();
                            System.out.println("Digite a nova idade: ");
                            int novaIdade = sc.nextInt();
                            System.out.println("Digite o novo endereço: ");
                            sc.nextLine();
                            String novoEndereco = sc.nextLine();

                            pessoas.get(i).editarDados(novoNome,novaIdade,novoEndereco);
                            editado = true;
                            break;
                        }
                    }
                    if (editado) {
                        System.out.println("Edição salva com sucesso!");
                    }else {
                        System.out.println("Id não encontrado!");
                    }
                    break;
                case 3:
                    boolean removido = false;

                    System.out.println("Digite o id do usuário que deseja excluir: ");
                    int idExcluir = sc.nextInt();
                    for (int i = 0; i < pessoas.size(); i++) {
                        Integer idPessoa = pessoas.get(i).getId();
                        if (idPessoa != null && idPessoa.equals(idExcluir)) {
                            pessoas.remove(i);
                            removido = true;
                            break;
                        }
                    }
                    if (removido) {
                        System.out.println("Usuário removido com sucesso.");
                    }else {
                        System.out.println("Id não encontrado.");
                    }
                    break;
                case 4 :
                    for (Pessoa p : pessoas) {
                        System.out.println(p);
                    }
                    break;
                case 5 :
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (opcao != 5);

        sc.close();

    }
}
