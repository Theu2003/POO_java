/*
@Mateus Martins Peres
@victor martins santos 
*/
import java.util.Scanner;

public class Main {
    private static Livraria livraria = new Livraria();
    private static final int SAIR = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            montaMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro(sc);
                    break;
                case 2:
                    buscarLivro(sc);
                    break;
                case 3:
                    listarLivros(sc);
                    break;
                case 4:
                    removerLivro(sc);
                    break;
                case SAIR:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != SAIR);

        sc.close();
    }

    private static void montaMenu() {
        System.out.println("Menu:");
        System.out.println("1. Inserir");
        System.out.println("2. Buscar por título");
        System.out.println("3. Listar a partir de um ano");
        System.out.println("4. Remover por ISBN");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarLivro(Scanner sc) {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Ano de publicação: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Livro livro = new Livro(isbn,titulo,ano);

        if (livraria.incluirLivro(livro) == 1) {
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Já existe um livro com esse ISBN!");
        }
    }

    private static void buscarLivro(Scanner sc) {
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        Livro livro = livraria.buscarLivro(titulo);

        if (livro != null) {
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private static void listarLivros(Scanner sc) {
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        livraria.listarLivros(ano);
    }

    private static void removerLivro(Scanner sc) {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        if (livraria.excluirLivro(isbn) == 1) {
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }
}